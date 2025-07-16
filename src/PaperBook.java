public class PaperBook extends Book {
    private double price;
    private int quantity;
    private ShippingDeliverable delivery;

    public PaperBook(String ISBN, String title, int year, double price, int quantity) {
        super(ISBN, title, year);
        this.price = price;
        this.quantity = quantity;
        this.delivery = new ShippingDeliveryStrategy();
    }

    @Override
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public double sell(int quantity, String email, String address) {
        if (quantity <= 0 || quantity > this.quantity) {
            System.out.println("Invalid quantity or not enough stock.");
            return 0.0;
        }
        this.quantity -= quantity;
        double total = price * quantity;
        printBookDetails();
        delivery.deliverToAddress(address);
        return total;
    }
}