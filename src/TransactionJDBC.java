import java.sql.*;

public class TransactionJDBC {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;
        Savepoint sp =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_practice",
                    "root",
                    "akshu@ft16");
            con.setAutoCommit(false);//disable suto commit
            ps1 = con.prepareStatement("UPDATE User SET balance = balance - 10000 WHERE id=1");
            ps1.executeUpdate();
            // Create savepoint — so if next update fails, rollback to here
            sp = con.setSavepoint("AfterDeduction");
            ps2 = con.prepareStatement("UPDATE User SET balance = balance + 500 WHERE id=2");
            ps2.executeUpdate();
            con.commit();
            System.out.println("Transaction Completed Successfully");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            try {
                if (con != null) {
                    System.out.println("Error occurred! Rolling back to Savepoint...");
                    con.rollback(sp);
                    con.commit();
                    System.out.println("Rolled back to savepoint successfully!");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }finally {
        try {
            if (ps1 != null) ps1.close();
            if (ps2 != null) ps2.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            System.out.println("Close Failed: " + ex.getMessage());
        }

            }

        }

}
