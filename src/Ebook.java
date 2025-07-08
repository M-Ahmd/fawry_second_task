public class Ebook extends Book{
    private double price;
    private String fileType;
    
    
    /**
     * Constructs an Ebook with the specified details.
     * @param author The author of the ebook.
     * @param ISBN The ISBN of the ebook.
     * @param title The title of the ebook.
     * @param publicationYear The year the ebook was published.
     * @param price The price of the ebook.
     * @param fileType The type of file (e.g., PDF, EPUB).
     */
    public Ebook(String ISBN, String title, int publicationYear, double price, String fileType) {
        super(ISBN, title, publicationYear);
        this.price = price;
        this.fileType = fileType;
    }
    @Override
    public double getPrice() {
        return price;
    }

    public String getFileType() {
        return fileType;
    }
    
    public void printBookDetails() {
        super.printBookDetails();
        System.out.println("File Type: " + fileType);
        System.out.println("Will be delivered via email.");
    }
    /**
     * Sells a specified quantity of the ebook.
     * @param quantity The number of copies to sell.
     * @param email The email address to send the ebook details.
     * @param address The address to ship the ebook (not applicable for ebooks).
     * @return The total price for the sold quantity.
     * This method checks if the requested quantity is valid and processes the sale by sending an email
     */
    @Override
    public double sell(int quantity, String email, String address) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return 0.0;
        }

        double total = getPrice() * quantity;
        printBookDetails();
        System.out.println("Sent to email: " + email);
        MailService.sendMail(email);
        return total;
    }
    
}