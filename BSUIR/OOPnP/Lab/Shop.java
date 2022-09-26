package BSUIR.OOPnP.Lab;

import java.util.List;


public class Shop {
    private List<Toy> assortment;
    private List<Customer> customers;

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
}
