package OOPnP.OOP;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> clientList;
    private List<Check> checksList;

    public Bank(){
        clientList = new ArrayList<>();
        checksList = new ArrayList<>();
    }

    public Bank(List<Client> clientList, List<Check> checksList){
        this.clientList = clientList;
        this.checksList = checksList;
    }

    public List<Client> getClientList(){
        return clientList;
    }

    public void setClientList(List<Client> clientList){
        this.clientList = clientList;
    }

    public List<Check> getChecksList(){
        return checksList;
    }

    public void setChecksList(List<Check> checksList){
        this.checksList = checksList;
    }
    
    public void addClient(Client client){
        clientList.add(client);
    }

    public void addCheck(Check check){
        checksList.add(check);
    }

}
