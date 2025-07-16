public class DemoBook extends Book {
    private EmailDeliverable delivery;

    public DemoBook(String ISBN, String title, int year) {
        super(ISBN, title, year);
        this.delivery = new EmailDeliveryStrategy();
    }

    @Override
    public double getPrice() { return 0.0; }

    @Override
    public double sell(int quantity, String email, String address) {
        printBookDetails();
        delivery.deliverToEmail(email);
        return 0.0;
    }
}
