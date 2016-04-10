
package eu.epfc.cours3449.LibrarySQL;

public class Work {
    private String workid;
    private String authorid;
    private String title;
    private String firstPublication;
    private String origLanguage;

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstPublication() {
        return firstPublication;
    }

    public void setFirstPublication(String firstPublication) {
        this.firstPublication = firstPublication;
    }

    public String getOrigLanguage() {
        return origLanguage;
    }

    public void setOrigLanguage(String origLanguage) {
        this.origLanguage = origLanguage;
    }
    
    public void toDisplay() {
        System.out.println(workid+" "+authorid+" "+title+" "+firstPublication+" "+origLanguage);
    }
    
}
