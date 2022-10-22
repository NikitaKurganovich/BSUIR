package BSUIR.OOPnP.Lab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Constants implements Serializable{

    static Double defPrice = 16.;

    static String SHOP_FILE_DIRECTION = "C://Users//Shop.txt";

    static List<Toy> assortment = new ArrayList<Toy>(){{
        add(new Toy("small", "cat"));    add(new Toy("medium", "cat"));     add(new Toy("big", "cat"));
        add(new Toy("small", "dog"));    add(new Toy("medium", "dog"));     add(new Toy("big", "dog"));
        add(new Toy("small", "shark"));  add(new Toy("medium", "shark"));   add(new Toy("big","shark"));
        add(new Toy("small", "dolphin"));add(new Toy("medium", "dolphin")); add(new Toy("big","dolphin"));
        add(new Toy("small", "bear"));   add(new Toy("medium", "bear"));    add(new Toy("big","bear"));
        add(new Toy("small", "deer"));   add(new Toy("medium", "deer"));    add(new Toy("big","deer"));
    }};

    static List<Toy> PetrovList = new ArrayList<Toy>(){{
        add(new Toy("small", "bear"));
        add(new Toy("big","shark"));
    }};

    static List<Toy> IvanovList = new ArrayList<Toy>(){{
        add(new Toy("small", "dolphin")); 
        add(new Toy("medium", "deer"));
        add(new Toy("medium", "bear"));
    }};

    static List<Toy> KurganovichList = new ArrayList<Toy>(){{
        add(new Toy("medium", "deer"));
        add(new Toy("big","shark"));
        add(new Toy("medium", "bear"));
    }};

    static Cart PetrovCart = new Cart(PetrovList);
    static Cart IvanovCart = new Cart(IvanovList);
    static Cart KurganovichCart = new Cart(KurganovichList);

    static Customer Petrov = new Customer("Petrov", PetrovCart);
    static Customer Ivanov  = new Customer("Ivanov", IvanovCart);
    static Customer Kurganovich = new Customer("Kurganovich", KurganovichCart);
    
    static List<Customer> customers = new ArrayList<Customer>(){{
        add(Petrov);
        add(Ivanov);
        add(Kurganovich);
    }};
    static List<Cart> carts = new ArrayList<Cart>(){{
        add(PetrovCart);
        add(IvanovCart);
        add(KurganovichCart);
    }};

    static String[] options = {
        "1 - add customer",
        "2 - print all customer and carts",
        "3 - add toy to any customer's cart",
        "4 - all carts sum",
        "5 - print all assortment",
        "0 - exit",
    };
    static String[] sizes = {
    "1 - small",
    "2 - medium",
    "3 - big",
    };
    static String[] types = {
    "1 - cat",
    "2 - dog",
    "3 - shark",
    "4 - dolphin",
    "5 - bear",
    "6 - deer",
    };
}
