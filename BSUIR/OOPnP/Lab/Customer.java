package BSUIR.OOPnP.Lab;

import java.io.Serializable;

public class Customer implements Serializable, Comparable<Customer>{
    private String name;
    private Cart customerCart;
    
    public Customer(String name, Cart customerCart){
        this.name = name;
        this.customerCart = customerCart;
    }

    public void setCustomerCart(Cart customerCart) {
        this.customerCart = customerCart;
    }

    public Cart getCustomerCart() {
        return customerCart;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int compareTo(Customer customer){
        int comp = name.compareTo(customer.name);
        return (comp != 0 ? comp: name.compareTo(customer.name));
    }
}
