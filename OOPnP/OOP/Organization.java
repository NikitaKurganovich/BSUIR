package BSUIR.OOPnP.OOP;

public class Organization extends Client {
    private Client owner;

    public Organization(String name, int checkAmount, Client owner){
        super(name, checkAmount);
        this.owner = owner;
    }
    
    public void setOwner(Client owner){
        this.owner = owner;
    }

    public Client getOwner(){
        return owner;
    }
}
