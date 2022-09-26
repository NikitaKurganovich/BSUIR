package BSUIR.OOPnP.Lab;

public class Customer{
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

}
