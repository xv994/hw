package course.Store;

public class Book {
    private String bookNo;
    private String bookName;
    private float bookPrice;

    public Book(){}
    public Book(String bookNo, String bookName, float bookPrice){
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    
    
}
