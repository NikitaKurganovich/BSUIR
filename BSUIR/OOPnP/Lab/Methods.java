package BSUIR.OOPnP.Lab;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public interface Methods {

    static void printMenu(String[] options){
        for (String option: options){
            System.out.println(option);
        }
        System.out.println("Choose your option: ");
    }

    static void printPrices(List<Toy> assortment){
        for(Toy animal : assortment) System.out.print("Price for " 
        + animal.getSize() + " " + animal.getType() + 
        " is " + toyPrice.calculatePrice(animal.getSize(), animal.getType()) + "\n");
    }

    Calculation toyPrice = (size, type) -> {
        Double price = Constants.defPrice;
        if(size.equals("small")) price *=0.5;
        if(size.equals("big")) price *=1.5;
        
        if(type.equals("dog") || type.equals("cat")) price *=0.5;
        if(type.equals("bear") || type.equals("deer")) price *=1.5;
        return price;
    };


    static void addCustomer(Scanner scanner, Shop shop){
        System.out.println("Adding a customer. Entre name: ");
        String customerName = checkingCustomerInfo(scanner, shop);

        System.out.println("Entre a customer's toy amount: ");
        int toyAmount = numberValidation(scanner);
        scanner.nextLine();
        List<Toy> temp = new ArrayList<Toy>();
        

        for(int i = 0; i < toyAmount; i++){
            System.out.println("Choose a size of toy: ");
            String size = choosingSize(scanner);

            System.out.println("Choose a toy type: ");
            String type = choosingType(scanner);

            for(Toy animal : shop.getAssortment()){
                if(animal.getSize().equalsIgnoreCase(size) && animal.getType().equalsIgnoreCase(type)){
                temp.add(animal);
                };}
            if(temp.size() == i){
                System.out.println("Toy wasn't found! Try choose other");
                i--;
                continue;
            }
        }
        Cart customerCart = new Cart(temp);
        Customer customer = new Customer(customerName, customerCart);
        System.out.println("Customer was added");
        shop.addCustomerToShop(customer);
        System.out.println(" ");
    }

    static void addToyToCustomer(Scanner scanner, Shop shop){
        System.out.println("Searching a customer. Entre name: ");
        String name = scanner.nextLine();

        for(Customer cust:shop.getCustomers()){
            if(cust.getName().equals(name)) {
                while(true){
                    System.out.println("Choose a size of toy: ");
                    String size = choosingSize(scanner);
    
                    System.out.println("Choose a toy type: ");
                    String type = choosingType(scanner);
    
                for(Toy animal : shop.getAssortment()){
                    if(animal.getSize().equalsIgnoreCase(size) && animal.getType().equalsIgnoreCase(type)){
                        cust.getCustomerCart().addToyToCart(animal);
                        System.out.println("Toy was added to " + cust.getName());
                        System.out.println(" ");
                        return;
                    };}
                    System.out.println("Toy wasn't found! Try choose other");
                    System.out.println(" ");
                    continue;
                }
            }
            }
        
    }


    static String checkingCustomerInfo(Scanner scanner, Shop shop){
        String customerName;
        int index = 1;
        while(true){
            customerName = scanner.nextLine();
            for(Customer customer: shop.getCustomers()){
                if(customerName.equals(customer.getName())){
                    System.out.println("This name is taken!");
                    index = 0;
                    break;
                }
                index = 1; 
            }
            if(index != 1) continue;
            return customerName;
        }   
    }

    static int numberValidation( Scanner scanner){
        int temp;
        while(true){
            try{
                temp = Integer.parseInt(scanner.next());
                break;
            }
            catch(Exception ex){
                System.out.println("Entre a number!");
            }
        }
        return temp;
    }



    static String choosingSize(Scanner scanner){
        int option = 1;
        while(true){
            Methods.printMenu(Constants.sizes);
            try{
                option = scanner.nextInt();
                scanner.nextLine();
                switch(option){
                    case 1:  return "small";
                    case 2:  return "medium";
                    case 3: return "big";
                }
            }catch(Exception ex){
                System.out.println("Please, entre a value between 1 and " + Constants.sizes.length);
                scanner.nextLine();
            }
        }
    }

    static String choosingType(Scanner scanner){
        int option = 1;
        while(true){
            Methods.printMenu(Constants.types);
            try{
                option = scanner.nextInt();
                scanner.nextLine();
                switch(option){
                    case 1:  return "cat";
                    case 2:  return "dog";
                    case 3: return "shark";
                    case 4: return "dolphin";
                    case 5: return "bear";
                    case 6: return "deer";
                }
            }catch(Exception ex){
                System.out.println("Please, entre a value between 1 and " + Constants.types.length);
                scanner.nextLine();
            }
        }
    }
    
    static void chooseSortType(Scanner scanner, SubThreadSort sort,SubThreadReverseSort reverseSort){
        int option = 1;
        while(true){
            Methods.printMenu(Constants.sorts);
            try{
                option = scanner.nextInt();
                scanner.nextLine();
                switch(option){
                    case 1:  new Thread(sort).start();
                        System.out.println("Customers were sort by alphabet!");
                        return;
                    case 2:  new Thread(reverseSort).start();
                        System.out.println("Customers were sort by reverse alphabet!");
                        return;
                }
            }catch(Exception ex){
                System.out.println("Please, entre a value between 1 and " + Constants.types.length);
                scanner.nextLine();
            }
        }
    }

}
