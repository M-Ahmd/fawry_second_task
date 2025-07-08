import java.util.HashSet;
import java.util.Set;

public class Library {
    private Set<Book> books;
    private int numberOfYears;
    public Library(int numberOfYears) {
        books = new HashSet<>();
        this.numberOfYears = numberOfYears;
    }
    public Library() {
        books = new HashSet<>();
        this.numberOfYears = 5; // Default to 5 years if not specified
    }
    public Library(Set<Book> books) {
        this.books = new HashSet<>();
    }

    public void addBook(Book book)
    {
        if (book != null) {
            books.add(book);
        }
    }
    public void cleanOutDatedBooks()
    {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        books.removeIf(book -> book.getPublicationYear() < currentYear - numberOfYears);
    }
    public Set<Book> getBooks() {
        return books;
    }
    public int getNumberOfYears() {
        return numberOfYears;
    }
    public void displayBooks() {
        for (Book book : books) {
            System.out.println("ISBN: " + book.getISBN() + ", Title: " + book.getTitle() + ", Year: " + book.getPublicationYear());
        }
    }
}
