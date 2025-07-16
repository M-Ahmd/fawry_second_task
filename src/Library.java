import java.util.*;

public class Library {
    private Map<String, Book> books = new HashMap<>();
    private int numberOfYears = 5;

    public void addBook(Book book) {
        if (book != null) {
            books.put(book.getISBN(), book);
        }
    }

    public void cleanOutDatedBooks() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        books.values().removeIf(book -> currentYear - book.getPublicationYear() > numberOfYears);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        for (Book book : books.values()) {
            if (book instanceof PaperBook pb && pb.getQuantity() == 0) continue;
            System.out.println(book.getTitle() + " | ISBN: " + book.getISBN() + " | Year: " + book.getPublicationYear() + " | Price: $" + book.getPrice());
        }
    }

    public double sellBook(String ISBN, int quantity, String email, String address) {
        Book book = books.get(ISBN);
        if (book == null) {
            System.out.println("Book not found.");
            return 0.0;
        }
        double total = book.sell(quantity, email, address);
        System.out.println("Total paid: $" + total);
        return total;
    }
}