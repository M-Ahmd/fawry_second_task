public abstract class Book {
    private String ISBN;
    private String title;
    private int publicationYear;

    public Book(String ISBN, String title, int publicationYear) {
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
}
