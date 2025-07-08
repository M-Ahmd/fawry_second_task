public abstract class Book {
    private String ISBN;
    private String title;
    private int publicationYear;
    private String author;
    public Book(String author, String ISBN, String title, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }
    public String getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public String getAuthor() {
        return author;
    }
    public abstract double getPrice();
    public void printBookDetails()
    {
        QuantumPrint.println("Book Details:");
        QuantumPrint.println("Title: " + getTitle());
        QuantumPrint.println("Author: " + getAuthor());
        QuantumPrint.println("ISBN: " + getISBN());
        QuantumPrint.println("Publication Year: " + getPublicationYear());
        QuantumPrint.println("Price: $" + getPrice());
    }
    public abstract double sell(int quantity, String email, String address);
}