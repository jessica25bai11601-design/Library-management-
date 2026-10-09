import java.util.Scanner;

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
