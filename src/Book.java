public abstract class Book {
    private String ISBN;
    private String title;
    private int publicationYear;

    public Book(String ISBN, String title, int publicationYear) {
        this.ISBN = ISBN;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public int getPublicationYear() { return publicationYear; }

    public void printBookDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + getTitle());
        System.out.println("ISBN: " + getISBN());
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Price: $" + getPrice());
    }

    public abstract double getPrice();
    public abstract double sell(int quantity, String email, String address);
}