package BSUIR.OOPnP.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface FileMethods{

    
    static Shop shopDeserialization(){
        try
        {    
            FileInputStream file = new FileInputStream(Constants.SHOP_FILE_DIRECTION); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            Shop obj = (Shop)in.readObject(); 
        
            in.close();
            file.close();
            return obj;
        } 
        catch(IOException ex) 
        { 
            ex.printStackTrace();
            System.out.println("ERROR"); 
            return null;
        } 
        catch(ClassNotFoundException ex) 
        { 
            ex.printStackTrace();
            System.out.println("CLASS ERROR"); 
            return null;
        } 
    }

    static void serializeShop(Shop shop){
        try
        {
        FileOutputStream file = new FileOutputStream(Constants.SHOP_FILE_DIRECTION); 
        ObjectOutputStream out = new ObjectOutputStream(file); 
          
        out.writeObject(shop); 
        out.close(); 
        file.close(); 
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR");
        }
    }

    static Shop createShopFile(){
        try
        {   
            Shop shop = new Shop(Constants.assortment, Constants.customers, Constants.carts);
            FileOutputStream file = new FileOutputStream(Constants.SHOP_FILE_DIRECTION); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            out.writeObject(shop); 
              
            out.close(); 
            file.close(); 
            return shop;
        } 
        catch(IOException ex) 
        { 
            ex.printStackTrace();
            System.out.println("ERROR");

            return null;
        } 
    }
}
