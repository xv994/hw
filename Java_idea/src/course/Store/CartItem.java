package course.Store;

public class CartItem {

    private Book book;
    private int count;
    
    public CartItem(){}
    public CartItem(Book book, int count){
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        String str = "%1$-10s %2$-10s %3$-10.2f %4$-10d %5$-10.2f";
        return String.format(str, book.getBookNo(), book.getBookName(), book.getBookPrice(), count, book.getBookPrice());
    }

    
    
}
