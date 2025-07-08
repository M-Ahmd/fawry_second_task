public class QuantumBookstoreFullTest {
    public static void main(String[] args) throws Exception {
        Book book = new PaperBook("Hamid", "1234567890", "Quantum Physics", 2023, 29.99, 100);
        Book ebook = new Ebook("Elgamed", "0987654321", "Quantum Mechanics", 2022, 19.99);
        Book demoBook = new DemoBook("Karim Adel", "1122334455", "Quantum Computing", 2023);
        Library library = new Library();
        library.addBook(book);
        library.addBook(ebook);
        library.addBook(demoBook);
        library.cleanOutDatedBooks();
        library.displayBooks();

    }
}
