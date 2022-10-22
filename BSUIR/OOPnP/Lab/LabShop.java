package BSUIR.OOPnP.Lab;

import java.util.Scanner;
import java.io.File;;

public class LabShop{


    public static void main(String[] args){
        Shop shop;
        File shopFile = new File(Constants.SHOP_FILE_DIRECTION);

        if(!shopFile.exists()){
            System.out.println("Customers list doesn't exist! Standart one will be created");
            shop = FileMethods.createShopFile();
        }
        shop = FileMethods.shopDeserialization();

        SubThreadSerialize serialize = new SubThreadSerialize(shop);
        SubThreadSort sort = new SubThreadSort(shop);
        SubThreadReverseSort reverseSort = new SubThreadReverseSort(shop);

        Scanner scanner = new Scanner(System.in);
        int option = 1;

        while(option != 0){
            Methods.printMenu(Constants.options);
            try{
                option = scanner.nextInt();
                scanner.nextLine();
                switch(option){
                    case 1: Methods.addCustomer(scanner, shop); 
                            new Thread(serialize).start();
                            System.out.println(" "); 
                            break;
                    case 2:  shop.printCustomersAndCarts(); 
                            break;

                    case 3: Methods.addToyToCustomer(scanner, shop);
                            new Thread(serialize).start();
                            System.out.println(" "); 
                            break;
                    case 4:  shop.printCartsPrices();
                             System.out.println(" ");
                             break;
                    case 5:  Methods.printPrices(shop.getAssortment());
                            System.out.println(" ");
                            break;
                    case 6: Methods.chooseSortType(scanner, sort, reverseSort);
                            break;
                    case 0: System.exit(0);
                }
            }
            catch(Exception ex){
                System.out.println("Please, entre a value between 1 and " + Constants.options.length);
                scanner.nextLine();
            }
        }
        scanner.close();
        
       

    

   }
    
}

