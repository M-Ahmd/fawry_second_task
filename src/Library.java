import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private int numberOfYears;
    public Library(int numberOfYears) {
        books = new HashMap<>();
        this.numberOfYears = numberOfYears;
    }
    public Library() {
        books = new HashMap<>();
        this.numberOfYears = 5; // Default to 5 years if not specified
    }
    public Library(Map<String, Book> books) {
        this.books = new HashMap<>();
    }

    public void addBook(Book book)
    {
        if (book != null) {
            books.put(book.getISBN(), book);
        }
    }
    public void cleanOutDatedBooks()
    {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        books.values().removeIf(book -> (currentYear - book.getPublicationYear()) > numberOfYears);
    }
    public Map<String, Book> getBooks() {
        return books;
    }
    public int getNumberOfYears() {
        return numberOfYears;
    }
    private boolean decreaseTheStock(Book book, int quantity) {
        PaperBook paper = (PaperBook) book;
        if (paper.getQuantity() >= quantity) {
            paper.setQuantity(paper.getQuantity() - quantity);
            return true;
        } else {
            System.out.println("Error: Not enough stock to decrease.");
            return false;
        }
    }

    private void printBookDetails(Book book, int quantity) {
        System.out.println("Order confirmed!");
        System.out.println("-----------------------------");
        System.out.println("Book: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: $" + (book.getPrice() * quantity));
        System.out.println("-----------------------------");
    }
    private void printBookDetails(Book book) {
        System.out.println("Order confirmed!");
        System.out.println("-----------------------------");
        System.out.println("DemoBook: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("-----------------------------");
    }

    public void sellBook(String ISBN, int quantity, String email, String address) {
        Book book = books.get(ISBN);

        if (book == null) {
            System.out.println("Error: This book does not exist.");
        } else if (quantity <= 0) {
            System.out.println("Error: Please enter a valid quantity.");
        } else if (book instanceof PaperBook) {
            if (decreaseTheStock(book, quantity)) {
                printBookDetails(book, quantity);
                ShippingService.shipping(address);
            } else {
                System.out.println("The requested quantity exceeds available stock.");
            }
        } else if (book instanceof Ebook) {
            printBookDetails(book, quantity);
            MailService.sendMail(email);
        } 
        else if (book instanceof DemoBook) {
            printBookDetails(book);
            System.out.println("This is a demo book. No shipping or payment required.");
            MailService.sendMail(email); // or just show: "link sent to email"
        }
        else {
            System.out.println("Error: Unsupported book type.");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books.values()) {
                if(book instanceof PaperBook && ((PaperBook) book).getQuantity() == 0)
                    continue; // Skip demo books with quantity 0
                System.out.println(book.getTitle() + " by " + book.getAuthor() +
                   " (ISBN: " + book.getISBN() +
                   ", Year: " + book.getPublicationYear() +
                   (book.getPrice() != 0 ? ", Price: $" + book.getPrice() : "") +
                   ")");
            }
        }
    }
}
