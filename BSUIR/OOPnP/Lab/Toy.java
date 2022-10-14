package BSUIR.OOPnP.Lab;

import java.io.Serializable;

public class Toy implements Serializable{
    
    private String type;
    private String size;

    public Toy(String size, String type){
        this.size = size;
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public String getSize() {
        return size;
    }

}
