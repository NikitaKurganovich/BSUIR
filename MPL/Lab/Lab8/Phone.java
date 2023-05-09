package MPL.Lab.Lab8;

import java.util.Arrays;

public class Phone {
    private String number;
    private String model;
    private double weight;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public Phone() {
        this("", "", 0);
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    public void receiveCall(String callerName) {
        System.out.println("You have call from " + callerName);
    }

    public void receiveCall(String callerName, String callerNumber) {
        System.out.println("You have call from " + callerName + ", with phone number: " + callerNumber);
    }

    public void sendMessage(String... numbers) {
        System.out.println("Now sending message to numbers: " + Arrays.toString(numbers));
    }
   
}

