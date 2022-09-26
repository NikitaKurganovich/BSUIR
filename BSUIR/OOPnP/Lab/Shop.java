package BSUIR.OOPnP.Lab;

import java.util.List;


public class Shop {
    private List<Toy> assortment;
    private List<Customer> customers;

    public Shop(List<Toy> assortment, List<Customer> customers){
        this.assortment = assortment;
        this.customers = customers;
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

    protected void printPrices(){
        for(Customer people : customers) System.out.print(people.getName() 
        + " has to pay " + people.getCustomerCart().calculateCart() + " tugricks \n");
    }
}
