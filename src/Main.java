public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book ebook = BookFactory.createEbook("111", "Java 101", 2020, 100.0, "PDF");
        Book paper = BookFactory.createPaperBook("222", "Design Patterns", 2018, 200.0, 5);
        Book demo = BookFactory.createDemoBook("333", "Intro to CS", 2015);

        library.addBook(ebook);
        library.addBook(paper);
        library.addBook(demo);

        library.displayBooks();

        library.sellBook("111", 2, "user@example.com", "N/A");
        library.sellBook("222", 1, "user@example.com", "123 Main St");
        library.sellBook("333", 1, "user@example.com", "N/A");
    }
}
