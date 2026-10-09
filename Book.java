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
