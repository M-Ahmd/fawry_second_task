public class Ebook extends Book{
    private double price;
    private String fileType;
    public Ebook(String author, String ISBN, String title, int publicationYear, double price, String fileType) {
        super(author, ISBN, title, publicationYear);
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
        QuantumPrint.println("File Type: " + fileType);
        QuantumPrint.println("Will be delivered via email.");
    }
    @Override
    public double sell(int quantity, String email, String address) {
        if (quantity <= 0) {
            QuantumPrint.println("Invalid quantity.");
            return 0.0;
        }

        double total = getPrice() * quantity;
        printBookDetails();
        QuantumPrint.println("Sent to email: " + email);
        MailService.sendMail(email);
        return total;
    }
    
}