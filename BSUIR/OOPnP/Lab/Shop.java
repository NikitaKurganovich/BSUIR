package BSUIR.OOPnP.Lab;

import java.util.List;
import java.io.Serializable;

public class Shop implements Serializable{
    private List<Toy> assortment;
    private List<Customer> customers;
    private List<Cart> carts;

    public Shop(List<Toy> assortment, List<Customer> customers, List<Cart> carts){
        this.assortment = assortment;
        this.customers = customers;
        this.carts = carts;
    }

    public List<Cart> getCarts() {
    return carts;
    }

    public void setCarts(List<Cart> carts) {
    this.carts = carts;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Toy> getAssortment() {
        return assortment;
    }

    public void setAssortment(List<Toy> assortment) {
        this.assortment = assortment;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomerToShop(Customer customer){
        customers.add(customer);
    }

    public void removeCustomerAndCartFromShop(Customer customer){
        int indexCust = -1;
        int indexCart = -1;
        Cart cart = null;
        for (Customer c: customers){
            if (c.getName().equals(customer.getName())){
                indexCust = customers.indexOf(c);
                cart = c.getCustomerCart();
            } 
        }
        for(Cart c: carts){
            if(c.getCustomerCart().equals(cart.getCustomerCart())) indexCart = carts.indexOf(c);
        }
        customers.remove(indexCust);
        carts.remove(indexCart);
    }

    public void printCustomersAndCarts(){
        for (Customer cust: customers){
            System.out.println(cust.getName() + " has in their cart \n");
            for(Toy toy: cust.getCustomerCart().getCustomerCart()){
                System.out.println("A " + toy.getSize() + " " + toy.getType());
            }
        } 
    }

    public void printCartsPrices(){
        for(Customer people : customers) System.out.print(people.getName() 
        + " has to pay " + people.getCustomerCart().calculateCart() + " tugricks \n");
    }
}
