public class QuantumBookstoreFullTest {
    public static void main(String[] args) throws Exception {
        Book book = new PaperBook("1234567890", "Quantum Physics", 2023, 29.99, 100);
        Book ebook = new Ebook("0987654321", "Quantum Mechanics", 2022, 19.99, "PDF");
        Book demoBook = new DemoBook("1122334455", "Quantum Computing", 2023);
        Library library = new Library();

        library.addBook(book);// Adding a paper book
        library.addBook(ebook);// Adding an ebook
        library.addBook(demoBook);// Adding a demo book
        library.displayBooks();// Displaying all books in the library

        library.sellBook(book.getISBN(), 100, "ma0950082@gmail.com", "123 Main St");

        library.sellBook(ebook.getISBN(), 1, "fa0950082@gmail.com", "456 Elm St");
        
        library.sellBook(demoBook.getISBN(), 1, "sa0950082@gmail.com", "789 Oak St");
        
        library.sellBook(book.getISBN(), 1, "fdasfj", "123 Main St");
    }
}
