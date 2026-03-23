# 💼 Job Portal Application (Java Console-Based)

A simple console-based Job Portal application built using **Java, JDBC, and Stream API**.  
This project allows users to create accounts, view jobs, and filter jobs based on **location, skills, or both**.

---

## 🚀 Features

- 👤 Create new user account
- 📄 View all available jobs
- 🔍 Filter jobs by:
  - Location
  - Skills
  - Combined (Location + Skills)
- 📊 Job recommendations (basic logic)
- 🧠 Uses Java Stream API for filtering
- 🗄️ JDBC integration with database
- 🔗 Relationship between `User` and `UserProfile` using UID (foreign key)

---

## 🏗️ Project Structure


controller/
UserController.java
NewAccount.java

service/
JobService.java

repository/
JobRepo.java
UserRepo.java

model/
Job.java
User.java


---

## ⚙️ Technologies Used

- Java (Core Java)
- JDBC (Database Connectivity)
- MySQL (Database)
- Java Streams & Functional Interfaces
- Scanner (Console Input)

---

## 🧾 Database Design

### Users Table

uid (Primary Key, Auto Increment)
name


### UserProfile Table

id (Primary Key)
uid (Foreign Key referencing users.uid)
job_title
skills
location


### Jobs Table

jid (Primary Key)
jtitle
skills
location


---

## ▶️ How to Run

1. Clone the repository
2. Configure your database connection in `db.getConnection()`
3. Create required tables in MySQL
4. Run the main class
5. Use console menu to interact with the app

---

## 📌 Example Flow


=======User Actions=======

Update Profile
View All Jobs
Filter Jobs
Get Job Recommendations
Exit

### Filtering Example:

- Select:

3 → Filter Jobs

- Choose:

2 → Filter by Skills

- Enter:

Java, Spring


---

## 🧠 Key Concepts Implemented

- Java Streams (`filter`, `map`, `anyMatch`)
- Functional Interfaces (`Consumer`)
- Method References (`::`)
- JDBC Prepared Statements
- Data normalization (User & UserProfile relationship)

---

## 🔍 Filtering Logic

- **Location Filter** → matches exact location (case-insensitive)
- **Skills Filter** → matches any skill from user input
- **Combined Filter** → both conditions must match (AND logic)

---

## ⚠️ Notes

- Skills are stored as comma-separated values
- Input skills should also be comma-separated
- Case-insensitive matching is applied
- Ensure database connection is properly configured before running

---

## 📈 Future Improvements

- GUI (JavaFX / Swing / Web UI)
- REST API version (Spring Boot)
- Advanced recommendation system
- Pagination for job listings
- Better normalization for skills (separate table)
- Authentication & login system

---

## 👨‍💻 Author

- Developed as a learning project for understanding:
- Java backend fundamentals
- Database integration
- Stream API usage
- Real-world filtering logic

---

## 📜 License

This project is for educational purposes.
