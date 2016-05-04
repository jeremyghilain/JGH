
package eu.epfc.cours3449.LibraryDAOmodel;

public class Book {
    private String bookid;
    private String workid;
    private String editionid;
    private String location;
    private String buyDate;
    private String isbn;
    private String format;
    private String language;

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getEditionid() {
        return editionid;
    }

    public void setEditionid(String editionid) {
        this.editionid = editionid;
    }
    
    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    @Override
    public String toString() {
        return "Book{" + "identifier=" + bookid + ", location=" + location + ", buyDate=" + buyDate + '}';
    }
    
    public void toDisplay() {
        System.out.println(bookid+" "+workid+" "+editionid+" "+location+" "+buyDate+" "+isbn+" "+format+" "+language);
    }    
    
}
