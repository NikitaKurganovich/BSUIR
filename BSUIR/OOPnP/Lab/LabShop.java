package BSUIR.OOPnP.Lab;

import java.util.ArrayList;
import java.util.List;

public class LabShop{
    
    public static void main(String[] args){

        Toy smallCat = new Toy("small", "cat");
        Toy mediumCat = new Toy("medium", "cat");
        Toy bigCat = new Toy("big", "cat");

        Toy smallDog = new Toy("small", "dog");
        Toy mediumDog = new Toy("medium", "dog");
        Toy bigDog = new Toy("big", "dog");

        Toy smallShark = new Toy("small", "shark");
        Toy mediumShark = new Toy("medium", "shark");
        Toy bigShark = new Toy("big","shark");

        Toy smallDolphin = new Toy("small", "dolphin");
        Toy mediumDolphin = new Toy("medium", "dolphin");
        Toy bigDolphin = new Toy("big","dolphin");

        Toy smallBear = new Toy("small", "bear");
        Toy mediumBear = new Toy("medium", "bear");
        Toy bigBear = new Toy("big","bear");

        Toy smallDeer = new Toy("small", "deer");
        Toy mediumDeer = new Toy("medium", "deer");
        Toy bigDeer = new Toy("big","deer");

        List<Toy> assortment = new ArrayList<Toy>(){{
            add(smallCat); add(mediumCat); add(bigCat);
            add(smallDog); add(mediumDog); add(bigDog);
            add(smallShark);add(mediumShark); add(bigShark);
            add(smallDolphin);add(mediumDolphin); add(bigDolphin);
            add(smallBear);add(mediumBear); add(bigBear);
            add(smallDeer);add(mediumDeer); add(bigDeer);
        }};

        List<Toy> PetrovList = new ArrayList<Toy>(){{
            add(smallBear);
            add(bigShark);
        }};

        List<Toy> IvanovList = new ArrayList<Toy>(){{
            add(bigDeer); 
            add(mediumShark);
            add(bigDog);
        }};

        List<Toy> KurganovichList = new ArrayList<Toy>(){{
            add(smallDolphin);
            add(smallCat);
            add(smallShark);
        }};

        Cart PetrovCart = new Cart(PetrovList);
        Cart IvanovCart = new Cart(IvanovList);
        Cart KurganovichCart = new Cart(KurganovichList);

        Customer Petrov = new Customer("Petrov", PetrovCart);
        Customer Ivanov  = new Customer("Ivanov", IvanovCart);
        Customer Kurganovich = new Customer("Kurganovich", KurganovichCart);

        List<Customer> customers = new ArrayList<Customer>(){{
            add(Petrov);
            add(Ivanov);
            add(Kurganovich);
        }};

        Shop toyShop = new Shop(assortment, customers);
        toyShop.printPrices();
        //  for(Toy animal : assortment) System.out.print("Price for " 
        // + animal.getSize() + " " + animal.getType() + 
        // " is " + animal.toyPrice.calculatePrice(animal.getSize(), animal.getType()) + "\n");

    }
    
}

