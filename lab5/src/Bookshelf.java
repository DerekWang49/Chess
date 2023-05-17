//public class Bookshelf {
//    private Book[] bookshelf;
//    private int nextEmpty;
//    private String output;
//    public Bookshelf() {
//        this.bookshelf = new Book[20];
//    }
//
//    public Bookshelf(int size) {
//        this.bookshelf = new Book[size];
//    }
//
//    public boolean add(Book newBook) {
//        for (int i = 0; i < bookshelf.length; i++) {
//            if (bookshelf[nextEmpty] == null) {
//                bookshelf[i] = newBook;
//                return true;
//            }
//            else {
//                nextEmpty++;
//            }
//        }
//        return false;
//    }
//
//    public Bookshelf getBooksByAuthor(String author) {
//        Bookshelf authorBookshelf = new Bookshelf(bookshelf.length);
//        for (int i = 0; i < bookshelf.length; i++) {
//            if (bookshelf[i] != null) {
//                if (bookshelf[i].getAuthor().equals(author)) {
//                    authorBookshelf.bookshelf[i] = bookshelf[i];
//                }
//            }
//
//        }
//
//        return authorBookshelf;
//
//    }
//
//    public String toString() {
//        for (int i = 0; i < bookshelf.length; i++) {
//            if (bookshelf[i] != null) {
//                output += bookshelf[i].getTitle() + bookshelf[i].getAuthor() + bookshelf[i].getRating() + "\n";
//            }
//
//        }
//        return output;
//
//    }
//
//    public static void main(String[] args) {
//        Bookshelf bs = new Bookshelf(5);
//        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
//        bs.add(new Book("Eldest", "Christopher Paolini", 10.0));
//        bs.add(new Book("Brisingr", "Christopher Paolini", 10.0));
//        bs.add(new Book("Inheritance", "Christopher Paolini", 10.0));
//        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
//        Bookshelf goodbooks = bs.getBooksByAuthor("Christopher Paolini");
//        System.out.println(goodbooks);
//    }
//}

public class Bookshelf {
    Book[] books;
    private int nextEmpty;
    public Bookshelf() {
        books = new Book[20];
    }

    public Bookshelf(int size) {
        books = new Book[size];
    }

    public boolean add(Book newBook) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                nextEmpty = i;
                books[nextEmpty] = newBook;
                return true;
            }
        }
        return false;
    }

    public Bookshelf getBooksByAuthor(String author) {
        int authorCount = 0;
        Book[] authorBooks;
        authorBooks = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthor().equals(author)) {
                authorBooks[authorCount] = books[i];
                authorCount++;
            }
        }
        Bookshelf authorOnly = new Bookshelf(authorCount + 1);
        authorOnly.books = authorBooks;
        return authorOnly;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                output += books[i].getTitle() + ", " + books[i].getAuthor() + ", " + books[i].getRating() + "\n";
            }

        }
        return output;
    }

    public void sort(char sortBy) {
        int i, j;
        Book n;
        int counter = 0;
        for (i = 1; i < books.length; i++) {
            n = books[i];
            for (j = i - 1; j >= 0 && n.compareTo(books[j]) < 0; j--) {
                counter++;
                books[j+1] = books[j];
            }
            books[j+1] = n;
        }
    }



    public static void main(String[] args) {
        Bookshelf bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("Eldest", "Christopher Paolini", 10.0));
        bs.add(new Book("Brisingr", "Christopher Paolini", 10.0));
        bs.add(new Book("Inheritance", "Christopher Paolini", 10.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        Bookshelf goodbooks = bs.getBooksByAuthor("Christopher Paolini");
        System.out.println(goodbooks);

//        Bookshelf bs = new Bookshelf(5);
//        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
//        bs.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkein", 10.0));
//        bs.add(new Book("Twilight", "Stephenie Meyer", 0.0));
//        bs.add(new Book("The Diary of a Wimpy Kid", "Jeff Kinney", 0.0));
//        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
//        bs.sort('a');
//        System.out.println(bs);
    }
}
