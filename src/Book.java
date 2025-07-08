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
        System.out.println("Book Details:");
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + getISBN());
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Price: $" + getPrice());
    }
    public abstract double sell(int quantity, String email, String address);
}