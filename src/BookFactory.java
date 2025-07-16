public class BookFactory {
    public static Book createEbook(String ISBN, String title, int year, double price, String fileType) {
        return new Ebook(ISBN, title, year, price, fileType);
    }

    public static Book createPaperBook(String ISBN, String title, int year, double price, int quantity) {
        return new PaperBook(ISBN, title, year, price, quantity);
    }

    public static Book createDemoBook(String ISBN, String title, int year) {
        return new DemoBook(ISBN, title, year);
    }
}