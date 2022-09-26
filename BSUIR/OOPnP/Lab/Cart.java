package BSUIR.OOPnP.Lab;

import java.util.List;

public class Cart {
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
        for(Toy animal : customerCart) sum += animal.toyPrice.calculatePrice(animal.getSize(), animal.getType());
        return sum;
    }
    
    
}


