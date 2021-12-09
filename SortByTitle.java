import java.util.Comparator;

public class SortByTitle implements Comparator<Book> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Book s, Book a)
    {
        return s.getTitle().compareTo(a.getTitle());
    }

}
