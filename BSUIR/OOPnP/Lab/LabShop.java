package BSUIR.OOPnP.Lab;

import java.util.Scanner;
import java.io.File;;

public class LabShop{

    static String[] options = {
    "1 - add customer",
    "2 - print all customer and carts",
    "3 - add toy to any customer's cart",
    "4 - all carts sum",
    "5 - print all assortment",
    "0 - exit",
};

    public static void main(String[] args){
        Shop shop;
        File shopFile = new File(Constants.SHOP_FILE_DIRECTION);

        if(!shopFile.exists()){
            System.out.println("Customers list doesn't exist! Standart one will be created");
            shop = FileMethods.createShopFile();
        }
        shop = FileMethods.shopDeserialization();

        Scanner scanner = new Scanner(System.in);
        int option = 1;

        while(option != 0){
            Methods.printMenu(options);
            try{
                option = scanner.nextInt();
                scanner.nextLine();
                switch(option){
                    case 1:  Methods.addCustomer(scanner, shop); 
                            FileMethods.serializeShop(shop);
                            System.out.println(" "); 
                            break;
                    case 2:  shop.printCustomersAndCarts(); 
                            System.out.println(" ");
                            break;
                    case 3:  Methods.addToyToCustomer(scanner, shop);
                            FileMethods.serializeShop(shop);
                            System.out.println(" "); 
                            break;
                    case 4:  shop.printCartsPrices();
                             System.out.println(" ");
                             break;
                    case 5:  Methods.printPrices(shop.getAssortment());
                            System.out.println(" ");
                            break;
                    case 0: System.exit(0);
                }
            }
            catch(Exception ex){
                System.out.println("Please, entre a value between 1 and " + options.length);
                scanner.nextLine();
            }
        }
        scanner.close();
        
       

    

   }
    
}

