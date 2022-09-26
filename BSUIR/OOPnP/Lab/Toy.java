package BSUIR.OOPnP.Lab;

public class Toy {
    final Double defPrice = 16.;
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
    // dog cat dolphin shark bear deer
    Calculation toyPrice = (size, type) -> {
        Double price = defPrice;
        if(size.equals("small")) price *=0.5;
        if(size.equals("big")) price *=1.5;
        
        if(type.equals("dog") || type.equals("cat")) price *=0.5;
        if(type.equals("bear") || type.equals("deer")) price *=1.5;
        return price;
    };
}
