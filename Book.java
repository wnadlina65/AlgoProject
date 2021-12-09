
public class Book 
{
    String title;
    String author;
    String publisher;
    String genre;
    int year;
    int page;
    
    public Book(String title, String author, String publisher, String genre, int year, int page) {
        super();
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.year = year;
        this.page = page;
    }

    public Book() 
    {}

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getPage() {
        return page;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return " Title:" + title + "\n Author:" + author + "\n Publisher:" + publisher + "\n Genre:" + genre
                + "\n Year:" + year + "\n Page:" + page;
    }
    
    
}
