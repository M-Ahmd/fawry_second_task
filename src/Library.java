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
    public void sellBook(String ISBN, int quantity, String email, String address)
    {


    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books.values()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + 
                                   " (ISBN: " + book.getISBN() +
                                   ", Year: " + book.getPublicationYear() +
                                   ", Price: $" + book.getPrice() + ")");
                
            }
        }
    }
}
