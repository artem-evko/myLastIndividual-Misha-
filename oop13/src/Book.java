import java.util.Comparator;

public class Book  {
    private String title;
    private String Author;
    private int year;
    Book(String title,String Author,int year){
        this.Author=Author;
        this.title=title;
        this.year=year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", Author='" + Author + '\'' +
                ", year=" + year +
                '}';
    }
    public static Comparator<Book>YearComparator=new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getYear()- o2.getYear();
        }
    };
    public static Comparator<Book>AuthorComparator=new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getAuthor().compareToIgnoreCase(o2.getAuthor());
        }
    };
}
