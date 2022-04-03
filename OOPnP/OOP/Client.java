package BSUIR.OOPnP.OOP;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private int checkAmount;
    private List<Check> checks;

    public Client(String name, int checkAmount){
        this.name = name;
        this.checkAmount = checkAmount;
        checks = new ArrayList<>();
    }

    public Client(String name,int checkAmount, List<Check> checks){
        this.name = name;
        this.checkAmount = checkAmount;
        this.checks = checks;
    }

    public String getName(){
        return name;
    }


    public int getCheckAmount(){
        return checkAmount;
    }

    public void setCheckAmount(int checkAmount){
        this.checkAmount = checkAmount;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Check> getChecks(){
        return checks;
    }

    public void setChecks(List<Check> checks){
        this.checks = checks;
    }

    public void addCheckToClient(Check check){
        checks.add(check);
    }

    public void removeCheckFromClient(String number){
        int index = -1;
        for (Check c:checks){
            if (c.getNumber().equals(number)) index = checks.indexOf(c);
        }
        checks.remove(index);
    }
}


