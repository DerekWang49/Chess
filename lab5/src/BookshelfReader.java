import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BookshelfReader {
    public static Bookshelf readBooksFromFile(String fileName) {
        Bookshelf fileBooks = new Bookshelf();
        try {
            int numLines = 0;
            File f = new File(fileName);
            Scanner scanner = new Scanner(f);
            while(scanner.hasNextLine()) {
                numLines++;
                String s = scanner.nextLine();
            }
            scanner.close();
            scanner = new Scanner(f);

            for (int i = 0; i < numLines; i++) {
                String s = scanner.nextLine();
                String[] t = s.split(",");
                String title = t[0];
                String author = t[1];
                double rating = Double.parseDouble(t[2]);
                Book tempBook = new Book(title, author, rating);
                fileBooks.add(tempBook);
            }

        } catch (Exception e) {
            System.out.println(e);
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
                if (b.books[i] != null) {
                    String title = b.books[i].getTitle();
                    String author = b.books[i].getAuthor();
                    double rating = b.books[i].getRating();
                    p.println(title + ", " + author + ", " + rating);
                }
            }

            p.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Bookshelf b1 = readBooksFromFile("bookinput.txt");
        System.out.println(b1);
        writeShelfToFile(b1, "output.txt");
    }
}
