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
