import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;// Map to store books with ISBN as key
    private int numberOfYears;// Number of years to consider a book outdated
    
    /**
     * Constructor to initialize the library with a specific number of years.
     * @param numberOfYears The number of years to consider a book outdated.
     * * This constructor initializes the books map and sets the number of years.
     * If the number of years is not specified, it defaults to 5 years.
     */
    public Library(int numberOfYears) {
        books = new HashMap<>();
        this.numberOfYears = numberOfYears;
    }
    /**
     * Default constructor that initializes the library with a default number of years.
     * This constructor initializes the books map and sets the number of years to 5.
     */
    public Library() {
        books = new HashMap<>();
        this.numberOfYears = 5; // Default to 5 years if not specified
    }
    /**
     * Constructor to initialize the library with a map of books.
     * @param books A map of books to initialize the library with.
     * This constructor initializes the books map with the provided books.
     */
    public Library(Map<String, Book> books) {
        this.books = new HashMap<>(books);
    }

    /**
     * Adds a book to the library.
     * @param book The book to be added.
     * This method adds a book to the library's collection if it is not null.
     */
    public void addBook(Book book)
    {
        if (book != null) {
            books.put(book.getISBN(), book);
        }
    }

    /**
     * cleans out outdated books from the library.
     * This method removes books that are older than the specified number of years.
     */
    public void cleanOutDatedBooks()
    {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        books.values().removeIf(book -> (currentYear - book.getPublicationYear()) > numberOfYears);
    }

    /**
     * Gets the collection of books in the library.
     * @return A map of books where the key is the ISBN and the value is the Book object.
     * This method returns the current collection of books in the library.
     */
    public Map<String, Book> getBooks() {
        return books;
    }
    
    public int getNumberOfYears() {
        return numberOfYears;
    }
    
    /**
     * Sells a book from the library.
     * @param ISBN The ISBN of the book to be sold.
     * @param quantity The quantity of the book to be sold.
     * @param email The email address for sending confirmation.
     * @param address The address for shipping the book (if applicable).
     * This method processes the sale of a book, handling different types of books (paper, ebook, demo).
     */
    public double sellBook(String ISBN, int quantity, String email, String address) {
        Book book = books.get(ISBN);
        if (book == null) {
            System.out.println("Book not found.");
            return 0.0;
        }
        double totalPrice = book.sell(quantity, email, address);
        System.out.println("Total paid: $" + totalPrice);
        System.out.println("---------------------------------------------------");
        return totalPrice;
    }
    /**
     * Checks if a book should be skipped based on its type and quantity.
     * @param book The book to check.
     * @return true if the book is a PaperBook with zero quantity, false otherwise.
     * This method determines if a book should be skipped when displaying the library's collection.
     */
    private boolean shouldSkip(Book book) {
        return book instanceof PaperBook paperBook && paperBook.getQuantity() == 0;
    }

    /**
     * Formats the details of a book for display.
     * @param book The book to format.
     * @return A string containing the formatted details of the book.
     * This method creates a string representation of a book's details, including title, author, ISBN, year, and price.
     */
    private String formatBookDetails(Book book) {
        StringBuilder details = new StringBuilder();
        details.append("Title: ").append(book.getTitle())
            .append(", Author: ").append(book.getAuthor())
            .append(", ISBN: ").append(book.getISBN())
            .append(", Year: ").append(book.getPublicationYear());

        double price = book.getPrice();
        if (price > 0) {
            details.append(", Price: $").append(price);
        }

        return details.toString();
    }
    /**
     * Displays all books in the library.
     * This method prints the details of all books in the library, excluding paper books with no stock.
     */
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("Books in the library:");
        for (Book book : books.values()) {
            if (shouldSkip(book)) continue;

            System.out.println(formatBookDetails(book));
        }
        System.out.println("---------------------------------------------------");
    }
}
