
package eu.epfc.cours3449.LibrarySQL;

public class Book {
    private String bookid;
    private String location;
    private String buyDate;
    private Edition edition;
    private String isbn;
    private String format;
    private String language;
    private Work work;

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

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
    
    @Override
    public String toString() {
        return "Book{" + "identifier=" + bookid + ", location=" + location + ", buyDate=" + buyDate + '}';
    }
    
    public String toStringLong() {
        return "Book{" + "identifier=" + bookid + ", location=" + location + ", buyDate=" + buyDate + ", edition=" + edition + ", isbn=" + isbn + ", format=" + format + ", language=" + language + '}';
    }
    /*
    public void toDisplay() {
        System.out.println(techid+" "+identifier+" "+location+" "+buyDate+" "+edition.getName()+" "+isbn+" "+format+" "+language+" "
                +this.getAuthor().getName()+" "+this.getAuthor().getFamilyName()+" "+this.getTitle()+" "+this.getFirstPublication()+" "+this.getOrigLanguage() );
    }
    
    public String toCsv() {
        return techid+";"+identifier+";"+location+";"+buyDate+";"+edition.getName()+";"+isbn+";"+format+";"+language+";"
                +this.getAuthor().getName()+";"+this.getAuthor().getFamilyName()+";"+this.getTitle()+";"+this.getFirstPublication()+";"+this.getOrigLanguage();
    }

    */
            
}
