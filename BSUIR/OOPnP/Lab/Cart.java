package BSUIR.OOPnP.Lab;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable{
    
    private List<Toy> customerCart;

    public Cart(List<Toy> customerCart){
        this.customerCart = customerCart;
    }

    public List<Toy> getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(List<Toy> customerCart) {
        this.customerCart = customerCart;
    }

    protected double calculateCart(){
        Double sum = 0.;
        for(Toy animal : customerCart) sum += Methods.toyPrice.calculatePrice(animal.getSize(), animal.getType());
        return sum;
    }

    public void addToyToCart(Toy toy){
        customerCart.add(toy);
    }

    public int size(){
        return customerCart.size();
    }

    public void removeToyFromCustomer(Toy toy){
        int index = -1;
        for (Toy c: customerCart){
            if (c.getSize().equalsIgnoreCase(toy.getSize())&&c.getType().equalsIgnoreCase(toy.getType())) index = customerCart.indexOf(c);
        }
        customerCart.remove(index);
    }
    
}


