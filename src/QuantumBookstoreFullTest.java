public class QuantumBookstoreFullTest {
    public static void main(String[] args) throws Exception {
        Book book = new PaperBook("1234567890", "Quantum Physics", 2023, 29.99, 100);
        System.out.println("Book ISBN: " + book.getISBN());
    }
}
