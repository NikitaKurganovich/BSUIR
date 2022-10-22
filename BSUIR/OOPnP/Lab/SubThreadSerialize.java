package BSUIR.OOPnP.Lab;

public class SubThreadSerialize implements Runnable{
    
    Shop shop;
    
    SubThreadSerialize(Shop shop){
        this.shop = shop;
    }

    @Override
    public void run(){
        FileMethods.serializeShop(shop);
    }
}
