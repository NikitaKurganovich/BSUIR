package OOPnP.Lab;

public class Toy {
    final Double defPrice = 34.;
    private String type;
    private String size;

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
