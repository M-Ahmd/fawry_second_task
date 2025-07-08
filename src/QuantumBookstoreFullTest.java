public class QuantumBookstoreFullTest {
    public static void main(String[] args) throws Exception {
        Book book = new PaperBook("Basel Ebaid", "1234567890", "Quantum Physics", 2023, 29.99, 100);
        Book ebook = new Ebook("Mohammed Saad", "0987654321", "Quantum Mechanics", 2022, 19.99);
        Book demoBook = new DemoBook("Karim Adel", "1122334455", "Quantum Computing", 2023);
        Library library = new Library();
        library.addBook(book);
        library.addBook(ebook);
        library.addBook(demoBook);
        library.displayBooks();
        library.sellBook(book.getISBN(), 100, "ma0950082@gmail.com", "123 Main St");
        library.sellBook(ebook.getISBN(), 1, "fa0950082@gmail.com", "456 Elm St");
        library.sellBook(demoBook.getISBN(), 1, "sa0950082@gmail.com", "789 Oak St");
        library.sellBook(book.getISBN(), 1, "fdasfj", "123 Main St");
    }
}
