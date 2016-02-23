
package eu.epfc.cours3449.Library;

public class Book extends Work {
    private static int count=0;
    public int techid;
    private String identifier;
    private String location;
    private String buyDate;
    private Edition edition;
    private String isbn;
    private String format;
    private String language;

    public Book(String identifier) {
        count++;
        this.techid=count;
        this.identifier = identifier;
    }
    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    @Override
    public String toString() {
        return "Book{" + "identifier=" + identifier + ", location=" + location + ", buyDate=" + buyDate + '}';
    }
    
    public String toStringLong() {
        return "Book{" + "identifier=" + identifier + ", location=" + location + ", buyDate=" + buyDate + ", edition=" + edition + ", isbn=" + isbn + ", format=" + format + ", language=" + language + '}';
    }
    
    public void toDisplay() {
        System.out.println(techid+" "+identifier+" "+location+" "+buyDate+" "+edition.getName()+" "+isbn+" "+format+" "+language+" "
                +this.getAuthor().getName()+" "+this.getAuthor().getFamilyName()+" "+this.getTitle()+" "+this.getFirstPublication()+" "+this.getOrigLanguage() );
    }
    
    public String toCsv() {
        return techid+";"+identifier+";"+location+";"+buyDate+";"+edition.getName()+";"+isbn+";"+format+";"+language+";"
                +this.getAuthor().getName()+";"+this.getAuthor().getFamilyName()+";"+this.getTitle()+";"+this.getFirstPublication()+";"+this.getOrigLanguage();
    }

    
            
}
