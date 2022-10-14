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

        List<Toy> temp = new ArrayList<Toy>();
        

        for(int i = 0; i < toyAmount; i++){
            System.out.println("Entre a size of toy (small, medium, big): ");
            scanner.nextLine();
            String size = scanner.nextLine();

            System.out.println("Entre a toy type (cat, dog, dolphin, shark, deer or bear): ");
            String type = scanner.nextLine();

            for(Toy animal : shop.getAssortment()){
                if(animal.getSize().equalsIgnoreCase(size) && animal.getType().equalsIgnoreCase(type)){
                temp.add(animal);
                };}
            if(temp.size() == i){
                System.out.println("Toy wasn't found! Try choose other");
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
                System.out.println("Entre a size of toy (small, medium, big): ");
                String size = scanner.nextLine();
    
                System.out.println("Entre a toy type (cat, dog, dolphin, shark, deer or bear): ");
                String type = scanner.nextLine();
    
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

}
