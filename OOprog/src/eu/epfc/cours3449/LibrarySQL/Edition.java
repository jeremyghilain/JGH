
package eu.epfc.cours3449.LibrarySQL;

public class Edition {
    private String editionid;
    private String name;

    public String getEditionid() {
        return editionid;
    }

    public void setEditionid(String editionid) {
        this.editionid = editionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void toDisplay() {
        System.out.println(editionid+" "+name);
    }
    
     
}
