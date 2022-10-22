package BSUIR.OOPnP.Lab;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SubThreadSort implements Runnable{
    Shop shop;
    SubThreadSort(Shop shop){
        this.shop = shop;
    }

    List<Customer> customers = shop.getCustomers();

    @Override
    public void run(){
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer a1, Customer a2){
                return a1.getName().compareTo(a2.getName());
            }
        });
    }
}
