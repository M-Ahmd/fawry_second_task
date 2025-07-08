public abstract class Book {
    private String ISBN;
    private String title;
    private int publicationYear;
    private String author;
    public Book(String author, String ISBN, String title, int publicationYear) {
        this.author = author;
        this.ISBN = ISBN;
        this.title = title;
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
}
