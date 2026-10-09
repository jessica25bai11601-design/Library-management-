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
