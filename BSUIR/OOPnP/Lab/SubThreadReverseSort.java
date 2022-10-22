package BSUIR.OOPnP.Lab;

import java.util.Collections;
import java.util.Comparator;

public class SubThreadReverseSort implements Runnable{
    Shop shop;
    SubThreadReverseSort(Shop shop){
        this.shop = shop;
    }

    @Override
    public void run(){

        Collections.sort(shop.getCustomers(), Collections.reverseOrder(new Comparator<Customer>() {
            @Override
            public int compare(Customer a1, Customer a2){
                return a1.getName().compareTo(a2.getName());
            }
        }));
    }
}
