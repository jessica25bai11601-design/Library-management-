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
