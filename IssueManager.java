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
