public class Ebook extends Book{
    private double price;

    public Ebook(String ISBN, String title, int publicationYear, double price) {
        super(ISBN, title, publicationYear);
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    
}