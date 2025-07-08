public class DemoBook extends Book{

    public DemoBook(String author, String ISBN, String title, int publicationYear) {
        super(author, ISBN, title, publicationYear);
    }
    @Override
    public double getPrice() {
        return 0.0; // Demo books are free
    }
    @Override
    public double sell(int quantity, String email, String address) {
        printBookDetails();
        QuantumPrint.println("This is a demo copy. Free download sent to: " + email);
        MailService.sendMail(email);
        return 0.0;
    }
}
