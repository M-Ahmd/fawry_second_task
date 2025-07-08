public class Ebook extends Book{
    private double price;

    public Ebook(String author, String ISBN, String title, int publicationYear, double price) {
        super(author, ISBN, title, publicationYear);
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    
}