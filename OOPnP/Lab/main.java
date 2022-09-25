package OOPnP.Lab;

public class main {
    public static void main(String[] args){
        
    }

    MyInterface calculateCat = (Double price, String size) -> {
        if(size.equals("medium")) price = price *1.3;
        if(size.equals("big"))  price = price*1.3*1.3;
        return price*0.5;
    };
    MyInterface calculateDog = (Double price, String size) -> {
        if(size.equals("medium")) price = price *1.3;
        if(size.equals("big"))  price = price*1.3*1.3;
        return price*0.5;
    };
    MyInterface calculateDolphin = (Double price, String size) -> {
        if(size.equals("medium")) price = price *1.3;
        if(size.equals("big"))  price = price*1.3*1.3;
        return price;
    };
    MyInterface calculateShark = (Double price, String size) -> {
        if(size.equals("medium")) price = price *1.3;
        if(size.equals("big"))  price = price*1.3*1.3;
        return price;
    };
    MyInterface calculateBear = (Double price, String size) -> {
        if(size.equals("medium")) price = price *1.3;
        if(size.equals("big"))  price = price*1.3*1.3;
        return price*1.5;
    };
    MyInterface calculateDeer = (Double price, String size) -> {
        if(size.equals("medium")) price = price *1.3;
        if(size.equals("big"))  price = price*1.3*1.3;
        return price*1.5;
    };
}

@FunctionalInterface
interface MyInterface{
    double calculatePrice(Double price, String size);
}
