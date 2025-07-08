public class DemoBook extends Book{

    public DemoBook(String author, String ISBN, String title, int publicationYear) {
        super(author, ISBN, title, publicationYear);
    }
    @Override
    public double getPrice() {
        return 0.0; // Demo books are free
    }
    /**
     * Prints the details of the demo book.
     * This method overrides the printBookDetails method from the Book class to provide specific details for
     * demo books.
     * @param quantity The quantity of the demo book (not used in this case).
     * @param email The email address to send the demo book details (not used in this case).
     * @param address The address to ship the demo book (not used in this case).
     * @return The total price for the demo book, which is always 0.0.
     * This method prints the book details and simulates sending a free download link to the provided email.
     * It does not require a shipping address since demo books are typically digital.
     */
    @Override
    public double sell(int quantity, String email, String address) {
        printBookDetails();
        QuantumPrint.println("This is a demo copy. Free download sent to: " + email);
        MailService.sendMail(email);
        return 0.0;
    }
}
