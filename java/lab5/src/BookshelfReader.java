import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BookshelfReader {
    public static Bookshelf readBooksFromFile(String fileName) {
            int numBooks = 0;
            Bookshelf fileBooks = new Bookshelf(numBooks);
            try {
                File f = new File(fileName);
                Scanner scanner = new Scanner(f);
                while (scanner.hasNextLine()) {
                    String s = scanner.nextLine();
                    String[] t = s.split(",");
                    String title = t[0];
                    String author = t[1];
                    double rating = Double.parseDouble(t[2]);
                    fileBooks.books[numBooks] = new Book(title, author, rating);
                    numBooks++;
            }

            } catch (Exception e) {
                System.out.println("Error in filename");
            }
            return fileBooks;
    }

    public static void writeShelfToFile(Bookshelf b, String fileName) {
        Scanner s = null;
        try {
            s = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.out.println("File doesn't exist");
        }
        PrintWriter p = null;
        try {
            p = new PrintWriter(new File(fileName));
            for (int i = 0; i < b.books.length; i++) {
                String title = String.valueOf(b.books[i].getTitle());
                String author = String.valueOf(b.books[i].getAuthor());
                String rating = String.valueOf(b.books[i].getRating());
                p.println(title + author + rating);
            }

            p.close();
        } catch (Exception e) {
            System.out.println("Could not add to file");
        }
    }

    public static void main(String[] args) {
        Bookshelf b1 = readBooksFromFile("b.txt");
    }
}
