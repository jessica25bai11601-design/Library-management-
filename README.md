# Library Management System

## Project overview
Library Management System is a Java application that runs on a command-line interface. The program makes library management easier by providing a number of operations.
The system can add and manage books, add and register library members, issue and return books, search records and generate library status report on the current status of the library.
The project is developped using Java and uses basic Object-Oriented Programming.


---

## Features
The features of the Library Management System are as follows:
Add new books
View all books
Search for a book
Remove a book
Add library members
View members
Search for members
Issue books
Return books
View issued books
Generate library report
Validate basic user input
Save basic book information using file handling

---

## Technologies and tools used
### Programming Language
Java
### Concepts used
Classes and Objects
Constructors
Encapsulation
Methods
Loops
Conditional Statements
Switch Case
ArrayList
Input Validation
File Handling
### Tools
Java JDK
Java Compiler / IDE
Git
GitHub

---

## Project structure
```text
LibraryManagementSystem/
│
├── README.md
├── statement.md
├── .gitignore
│
├── src/
│ ├── Main.java
│ ├── Book.java
│ ├── Member.java
│ ├── Library.java
│ ├── BookManager.java
│ ├── MemberManager.java
│ ├── IssueManager.java
│ ├── LibraryReport.java
│ ├── InputValidator.java
│ └── FileManager.java
│
├── data/
│ ├── books.txt
│ └── members.txt
│
├── tests/
│ └── TestLibrary.java
│
├── docs/
│
└── screenshots/
``
---
## How to run the project
### Step 1: Install Java
Make sure Java JDK is installed on your computer.
You can check it using:
```bash
java -version
```
and:
``bash
javac -version
```
### Step 2: Open the project
Open the project folder in a Java-supported IDE or terminal.
### Step 3: Compile the program
Go to the project folder and run:
```bash
javac src/.java
```
### Step 4: Run the program
Run the Main class using:
```bash
java -cp src Main
```
The Library Management System menu will then appear in the command-line environment.
---
## How to use
After running the program, the main menu is displayed.
```text
====================================

LIBRARY MANAGEMENT SYSTEM

====================================

1. Add Book

2. View All Books

3. Search Book

4. Remove Book

5. Add Member

6. View Members

7. Search Member

8. Issue Book

9. Return Book

10. View Issued Books

11. Library Report

12. Exit

====================================

```
The user can select an option by entering the corresponding number.
For example:
Select 1 to add a book.
Select 3 to search for a book.
Select 8 to issue a book.
Select 9 to return a book.
Select 11 to generate a library report.
Select 12 to exit the program.
---
## Testing
The project contains a separate test file:
```text
tests/TestLibrary.java
```
The test program checks basic operations such as:
Checking book availability
Issuing a book
Returning a book
Searching for a book
Handling a missing book
Example test output:
```text
Test 1 Passed: Book is available.
Test 2 Passed: Book issued successfully.
Test 3 Passed: Book returned successfully.
Test 4 Passed: Book search successful.
Test 5 Passed: Missing book handled.
```
---
## Sample report
The system can generate a report showing the current status of the library.
Example:
```text

==============================

LIBRARY REPORT

==============================

Total Books : 3

Available Books : 2

Issued Books : 1

Total Members : 2

==============================

```

---



## Limitations



The current version of the project is designed as a basic command-line application.



It does not currently include:



Online login system

Database connectivity

Online book reservation

Fine calculation

Due-date tracking

Graphical User Interface

Online access

---
## Future improvements
The project can be improved in the future by adding:
MySQL database connectivity

Login and authentication

Student/member accounts

Book reservation

Fine calculation

Due-date tracking

Automatic loading of saved data

Graphical User Interface

Advanced search and filtering

---
## Conclusion
The Library Management System provides a simple way to manage basic library operations. The project helped in understanding how Java programming and OOP concepts can be used to create a practical application.
The project also provided practice with classes, objects, ArrayList, input validation, file handling and basic testing.
