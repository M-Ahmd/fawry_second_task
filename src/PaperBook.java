public class PaperBook extends Book{
    private double price;
    private int quantity;

    public PaperBook(String author, String ISBN, String title, int publicationYear, double price, int quantity) {
        super(author, ISBN, title, publicationYear);
        this.price = price;
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private void printBookDetails(int quantity) {
        super.printBookDetails();
        QuantumPrint.println("Quantity: " + quantity);
    }
    @Override
    public double sell(int quantity, String email, String address) {
        if (quantity <= 0) {
            QuantumPrint.println("Invalid quantity.");
            return 0.0;
        }
        if (quantity > this.quantity) {
            QuantumPrint.println("Not enough stock.");
            return 0.0;
        }

        this.quantity -= quantity;
        double total = getPrice() * quantity;
        printBookDetails(quantity);
        QuantumPrint.println("Shipped to: " + address);
        ShippingService.shipping(address);
        return total;
    }
}
