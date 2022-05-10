package BSUIR.OOPnP.OOP
public class Check {

private int balance;
private String number;
private Client owner;

public Check(int balance, String number, Client owner){
    this.balance = balance;
    this.number = number;
    this.owner = owner;
}
public String getNumber(){
    return number;
}

public int getBalance(){
    return balance;
}

public void setBalance(int balance){
    this.balance = balance;
}

public void setNumber(String number){
    this.number = number;
}

public Client getOwner(){
    return owner;
}

public void setOwner(Client owner){
    this.owner = owner;
}

}
