public class Ebook extends Book {
    private double price;
    private String fileType;
    private EmailDeliverable delivery;

    public Ebook(String ISBN, String title, int year, double price, String fileType) {
        super(ISBN, title, year);
        this.price = price;
        this.fileType = fileType;
        this.delivery = new EmailDeliveryStrategy();
    }

    @Override
    public double getPrice() { return price; }

    @Override
    public double sell(int quantity, String email, String address) {
        if (quantity <= 0) return 0.0;
        double total = price * quantity;
        printBookDetails();
        delivery.deliverToEmail(email);
        return total;
    }
}
