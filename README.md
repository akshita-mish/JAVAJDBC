📚 JDBC Student Management & Money Transfer System

This Java project demonstrates JDBC connectivity with MySQL and includes:
✔ Student CRUD Operations (Add, View, Update, Delete)
✔ Bank-like Transaction Handling using Savepoint
✔ PreparedStatement & rollback mechanism
✔ Manual Commit transaction example

🛠️ Tech Stack

Technology	   Purpose
Java	         Application logic
JDBC	         Database connectivity
MySQL          Database storage
IntelliJ       IDE


🗄️ Database Setup

Create a MySQL database:
CREATE DATABASE JDBC_practice;

Student Table:
CREATE TABLE student (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  age INT
);

User Table for Transaction:
CREATE TABLE User (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  balance INT
);


📌 Features

👩‍🎓 Student Management (CRUD)
Add new student
View all students
Update student age
Delete student by ID

💰 Money Transfer System
Deducts and deposits balances between two users
Uses:
setAutoCommit(false)
Savepoint
commit()
rollback(savepoint)
Prevents data loss in case of errors.


## 📸 MySQL Database Screenshot

![Database Screenshot](https://github.com/user-attachments/assets/d30aa3a8-b50d-4979-834e-6ada6cf75643)
![Database Screenshot](https://github.com/user-attachments/assets/b47d726f-8c6d-4b11-b670-e81759064045)


🚀 Future Enhancements
Add validation (e.g., balance should not go negative)
Use separate DAO classes for clean architecture
Add Search student feature
Switch to Spring JDBC or Hibernate later


