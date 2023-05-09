package MPL.Lab.Lab8;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("123456789", "Samsung", 0.2);
        Phone phone2 = new Phone("987654321", "iPhone");
        Phone phone3 = new Phone();

        System.out.println("First phone data:"); 
        System.out.println(phone1.getNumber()); 
        System.out.println(phone1.getModel()); 
        System.out.println(phone1.getWeight()); 
        
        System.out.println("Second phone data:");
        System.out.println(phone2.getNumber()); 
        System.out.println(phone2.getModel()); 
        System.out.println(phone2.getWeight()); 
    
        phone1.receiveCall("John"); 
        phone2.receiveCall("Kate", "555-1234"); 
    
        phone3.setModel("Nokia");
        phone3.setNumber("555-4321");
        phone3.sendMessage("123-4567", "234-5678", "345-6789"); 
    }
}
