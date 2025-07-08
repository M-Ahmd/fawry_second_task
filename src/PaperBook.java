public class PaperBook extends Book{
    private double price;
    private int quantity;

    public PaperBook(String ISBN, String title, int publicationYear, double price, int quantity) {
        super(ISBN, title, publicationYear);
        this.price = price;
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
