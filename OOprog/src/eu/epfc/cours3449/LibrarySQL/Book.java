
package eu.epfc.cours3449.LibrarySQL;

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

    public void modBookVar(String option, String newval) {
        Edition e=new Edition();
        Author a=new Author();
        switch (option) {
                case "identifier":
                    this.identifier=newval;
                    break;
                case "location":
                    this.location=newval;
                    break;
                case "buy date":
                    this.buyDate=newval;
                    break;
                case "edition":
                    this.edition=e;
                    e.setName(newval);
                    break;
                case "isbn":
                    this.isbn=newval;
                    break;
                case "format":
                    this.format=newval;
                    break;
                case "language":
                    this.language=newval;
                    break;
                case "author name":
                    this.setAuthor(a);
                    a.setName(newval);
                    break;
                case "author family name":
                    this.setAuthor(a);
                    a.setFamilyName(newval);
                    break;
                case "title":
                    this.setTitle(newval);
                    break;
                case "first publication":
                    this.setFirstPublication(newval);
                    break;
                case "original language":
                    this.setOrigLanguage(newval);
                    break;
                default:
                    System.out.println("Error! the variable enterred in not valid! No modification was made!");
                    break;
            }
    }
            
}
