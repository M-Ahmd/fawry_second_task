public class DemoBook extends Book{

    public DemoBook(String author, String ISBN, String title, int publicationYear) {
        super(author, ISBN, title, publicationYear);
    }
    @Override
    public double getPrice() {
        return 0.0; // Demo books are free
    }
}
