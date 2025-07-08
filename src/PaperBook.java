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
        System.out.println("Quantity: " + quantity);
    }
    /**
     * Sells a specified quantity of the book.
     * @param quantity The number of copies to sell.
     * @param email The email address to send the book details.
     * @param address The address to ship the book.
     * @return The total price for the sold quantity.
     * This method checks if the requested quantity is valid and available in stock.
     */
    @Override
    public double sell(int quantity, String email, String address) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return 0.0;
        }
        if (quantity > this.quantity) {
            System.out.println("Not enough stock.");
            return 0.0;
        }

        this.quantity -= quantity;
        double total = getPrice() * quantity;
        printBookDetails(quantity);
        System.out.println("Shipped to: " + address);
        ShippingService.shipping(address);
        return total;
    }
}
