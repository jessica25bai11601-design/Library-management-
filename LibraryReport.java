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
