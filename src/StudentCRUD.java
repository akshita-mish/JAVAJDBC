import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        try{
            //Load and register Driver (mysql)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_practice",
                    "root",
                    "akshu@ft16");
            while(true){
                System.out.println("---------STUDENT MANAGEMENT---------");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student Age");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice= sc.nextInt();
                sc.nextLine();//buffer clean up
                switch (choice){
                    case 1: //Insert
                        String query1 ="INSERT INTO student(id,name,age) VALUES (?,?,?)";
                        PreparedStatement psIn = con.prepareStatement(query1);
                        System.out.println("Enter student id:");
                        int id=sc.nextInt();
                        sc.nextLine();
                        psIn.setInt(1,id);
                        System.out.println("Enter student name:");
                        String name=sc.nextLine();
                        psIn.setString(2,name);
                        System.out.println("Enter age:");
                        int age= sc.nextInt();
                        psIn.setInt(3,age);
                        psIn.executeUpdate();
                        System.out.println("Student added successfully");
                        break;
                    case 2: // Read
                        String query2="SELECT * FROM STUDENT";
                        Statement sRead=con.createStatement();
                        ResultSet rs=sRead.executeQuery(query2);
                        while(rs.next()){
                             id=rs.getInt("id");
                             name=rs.getString("name");
                             age=rs.getInt("age");
                            System.out.println(id+" "+name+" "+age);

                        }
                        break;
                    case 3: //Update
                        String update  = "UPDATE student SET age=? WHERE id=?";
                        PreparedStatement psUpdate = con.prepareStatement(update);
                        System.out.print("Enter ID to Update: ");
                        psUpdate.setInt(2, sc.nextInt());
                        sc.nextLine();
                        System.out.print("Enter New Age: ");
                        psUpdate.setInt(1, sc.nextInt());
                        sc.nextLine();
                        int updated = psUpdate.executeUpdate();
                        if (updated > 0)
                            System.out.println("Age Updated Successfully!");
                        else
                            System.out.println("Invalid ID!");
                        break;
                    case 4:
                        String  delete="DELETE FROM student WHERE id=?";
                        PreparedStatement psdel=con.prepareStatement(delete);
                        System.out.println("Enter id you want to delete");
                       psdel.setInt(1,sc.nextInt());
                       sc.nextLine();
                       int deleted= psdel.executeUpdate();
                       if(deleted>0){
                           System.out.println("Deleted successfully");
                       }else{
                           System.out.println("Invalid id");
                       }
                       break;
                    case 5:
                        con.close();
                        System.out.println("Connection Closed!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice!");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
