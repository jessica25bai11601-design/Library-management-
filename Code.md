Book.java:

public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean issued;
    
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    public void displayBook() {
        String status = issued ? "Issued" : "Available";

        System.out.println(
            bookId + " | " + title + " | " + author + " | " + status

  
        );
    }
}

Member.java:

public class Member {
    private int memberId;
    private String name;
    private String department;

    public Member(int memberId, String name, String department) {
        this.memberId = memberId;
        this.name = name;
        this.department = department;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void displayMember() {
        System.out.println(
            memberId + " | " + name + " | " + department
        );
    }
}

Library.java:

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    public Member findMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }

        return null;
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nID | Title | Author | Status");
        System.out.println("--------------------------------------");

        for (Book book : books) {
            book.displayBook();
        }
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        System.out.println("\nID | Name | Department");
        System.out.println("----------------------------");

        for (Member member : members) {
            member.displayMember();
        }
    }
}


InputValidator.java:

public class InputValidator {

    public static boolean isValidId(int id) {
        return id > 0;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}

BookManager.java:

import java.util.Scanner;

public class BookManager {

    private Library library;
    private Scanner scanner;

    public BookManager(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    public void addBook() {

        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (!InputValidator.isValidId(id)) {
            System.out.println("Invalid Book ID.");
            return;
        }

        if (library.findBook(id) != null) {
            System.out.println("A book with this ID already exists.");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        if (!InputValidator.isValidName(title) ||
            !InputValidator.isValidName(author)) {

            System.out.println("Title and author cannot be empty.");
            return;
        }

        Book book = new Book(id, title, author);
        library.addBook(book);

        System.out.println("Book added successfully!");
    }

    public void searchBook() {

        System.out.print("Enter Book ID to search: ");
        int id = scanner.nextInt();

        Book book = library.findBook(id);

        if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println("\nBook found:");
            System.out.println("ID | Title | Author | Status");
            book.displayBook();
        }
    }

    public void removeBook() {

        System.out.print("Enter Book ID to remove: ");
        int id = scanner.nextInt();

        Book book = library.findBook(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Issued book cannot be removed.");
            return;
        }

        library.getBooks().remove(book);

        System.out.println("Book removed successfully.");
    }
}

MemberManager.java:

import java.util.Scanner;

public class MemberManager {

    private Library library;
    private Scanner scanner;

    public MemberManager(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    public void addMember() {

        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (!InputValidator.isValidId(id)) {
            System.out.println("Invalid Member ID.");
            return;
        }

        if (library.findMember(id) != null) {
            System.out.println("A member with this ID already exists.");
            return;
        }

        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        if (!InputValidator.isValidName(name) ||
            !InputValidator.isValidName(department)) {

            System.out.println("Name and department cannot be empty.");
            return;
        }

        Member member = new Member(id, name, department);
        library.addMember(member);

        System.out.println("Member added successfully!");
    }

    public void searchMember() {

        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();

        Member member = library.findMember(id);

        if (member == null) {
            System.out.println("Member not found.");
        } else {
            System.out.println("\nMember found:");
            System.out.println("ID | Name | Department");
            member.displayMember();
        }
    }
}

IssueManager.java:

import java.util.Scanner;

public class IssueManager {

    private Library library;
    private Scanner scanner;

    public IssueManager(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    public void issueBook() {

        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        Book book = library.findBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }

        book.issueBook();

        System.out.println("Book issued successfully!");
    }

    public void returnBook() {

        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        Book book = library.findBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("This book is already available.");
            return;
        }

        book.returnBook();

        System.out.println("Book returned successfully!");
    }

    public void viewIssuedBooks() {

        boolean found = false;

        System.out.println("\n===== ISSUED BOOKS =====");

        for (Book book : library.getBooks()) {

            if (book.isIssued()) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently issued.");
        }
    }
}

LibraryReport.java:

public class LibraryReport {

    private Library library;

    public LibraryReport(Library library) {
        this.library = library;
    }

    public void generateReport() {

        int totalBooks = library.getBooks().size();
        int issuedBooks = 0;

        for (Book book : library.getBooks()) {
            if (book.isIssued()) {
                issuedBooks++;
            }
        }

        int availableBooks = totalBooks - issuedBooks;
        int totalMembers = library.getMembers().size();

        System.out.println("\n==============================");
        System.out.println("       LIBRARY REPORT");
        System.out.println("==============================");
        System.out.println("Total Books     : " + totalBooks);
        System.out.println("Available Books : " + availableBooks);
        System.out.println("Issued Books    : " + issuedBooks);
        System.out.println("Total Members   : " + totalMembers);
        System.out.println("==============================");
    }
}

FileManager.java:

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveBooks(Library library) {

        try {

            File folder = new File("data");

            if (!folder.exists()) {
                folder.mkdir();
            }

            FileWriter writer = new FileWriter("data/books.txt");

            for (Book book : library.getBooks()) {

                writer.write(
                    book.getBookId() + "|" +
                    book.getTitle() + "|" +
                    book.getAuthor() + "|" +
                    book.isIssued() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error while saving books.");
        }
    }
}

Main.java:

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();

        BookManager bookManager =
            new BookManager(library, scanner);

        MemberManager memberManager =
            new MemberManager(library, scanner);

        IssueManager issueManager =
            new IssueManager(library, scanner);

        LibraryReport report =
            new LibraryReport(library);

        // Sample books
        library.addBook(
            new Book(101, "Java Basics", "Herbert Schildt")
        );

        library.addBook(
            new Book(102, "Operating Systems", "Galvin")
        );

        library.addBook(
            new Book(103, "Digital Logic", "Morris Mano")
        );

        // Sample members
        library.addMember(
            new Member(1, "Rahul", "CSE")
        );

        library.addMember(
            new Member(2, "Ananya", "ECE")
        );

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("       LIBRARY MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Add Member");
            System.out.println("6. View Members");
            System.out.println("7. Search Member");
            System.out.println("8. Issue Book");
            System.out.println("9. Return Book");
            System.out.println("10. View Issued Books");
            System.out.println("11. Library Report");
            System.out.println("12. Exit");
            System.out.println("====================================");

            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {

                System.out.println("Please enter a number.");

                scanner.next();

                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    bookManager.addBook();
                    break;

                case 2:
                    library.displayAllBooks();
                    break;

                case 3:
                    bookManager.searchBook();
                    break;

                case 4:
                    bookManager.removeBook();
                    break;

                case 5:
                    memberManager.addMember();
                    break;

                case 6:
                    library.displayAllMembers();
                    break;

                case 7:
                    memberManager.searchMember();
                    break;

                case 8:
                    issueManager.issueBook();
                    break;

                case 9:
                    issueManager.returnBook();
                    break;

                case 10:
                    issueManager.viewIssuedBooks();
                    break;

                case 11:
                    report.generateReport();
                    break;

                case 12:
                    FileManager.saveBooks(library);
                    System.out.println("Thank you for using the Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 12);

        scanner.close();
    }
}

TestLibrary.java:

public class TestLibrary {

    public static void main(String[] args) {

        Library library = new Library();

        Book book = new Book(
            101,
            "Java Basics",
            "Herbert Schildt"
        );

        library.addBook(book);

        // Test 1: Book should be available initially
        if (!book.isIssued()) {
            System.out.println("Test 1 Passed: Book is available.");
        }

        // Test 2: Issue book
        book.issueBook();

        if (book.isIssued()) {
            System.out.println("Test 2 Passed: Book issued successfully.");
        }

        // Test 3: Return book
        book.returnBook();

        if (!book.isIssued()) {
            System.out.println("Test 3 Passed: Book returned successfully.");
        }

        // Test 4: Search book
        if (library.findBook(101) != null) {
            System.out.println("Test 4 Passed: Book search successful.");
        }

        // Test 5: Search missing book
        if (library.findBook(999) == null) {
            System.out.println("Test 5 Passed: Missing book handled.");
        }
    }
}
