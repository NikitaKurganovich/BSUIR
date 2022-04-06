package OOPnP.OOP;

import java.util.Scanner;
import static java.lang.System.exit;

public class Lab_1_oop {

    static Bank bank;

    public static void printMenu(String[] options){
        for (String option: options){
            System.out.println(option);
        }
        System.out.println("Choose your option: ");
    }

    public static void main(String[] args){
        bank = new Bank();

        String[] options = {"1 - add client",
                            "2 - print all clients from bank",
                            "3 - add check to any client",
                            "4 - all checks sum",
                            "5 - negative check sum",
                            "6 - positive check sum",
                            "7 - search check by name",
                            "0 - exit",
                        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;

        while(option != 0){
            printMenu(options);
            try{
                option = scanner.nextInt();
                scanner.nextLine();
                switch(option){
                    case 1: addClientOrOrganisation(scanner); break;
                    case 2: printAllClients(); break;
                    case 3: addCheckToClient(scanner); break;
                    case 4: checkSum(TextForSum1, TextForSum2, 1); break;
                    case 5: checkSum(TextForNeg1, TextForNeg2, 2); break;
                    case 6: checkSum(TextForPos1, TextForPoS2, 3); break;
                    case 7: searchCheck(scanner); break;
                    case 0: exit(0);
                }
            }
            catch(Exception ex){
                System.out.println("Please, entre a value between 1 and " + options.length);
                scanner.nextLine();
            }
        }
        scanner.close();
    }
   
    private static void addClient(Scanner scanner){
        System.out.println("Adding a client. Entre name: ");

        String clientName = checkingClientInfo(scanner);
        System.out.println("Entre a client's check amount: ");

        int checkAmount = numberValidation(scanner);
        Client client = new Client(clientName, checkAmount);

        for(int i = 0; i < checkAmount; i++){
            System.out.println("Entre a new check name: ");
            scanner.nextLine();
            String checkNumber = checkingCheckInfo(scanner);

            System.out.println("Entre a check balance: ");
            int checkBalance = numberValidation(scanner);

            Check check = new Check(checkBalance, checkNumber, client);
            client.addCheckToClient(check);
            bank.addCheck(check);
        }
        bank.addClient(client);
        
    }

    private static void addClientOrOrganisation(Scanner scanner){
        int option = 1;
        while(option != 0){
            System.out.println("1 - add a client"+ "\n"+"2 - add an organisation");
            try{
                option = scanner.nextInt();
                scanner.nextLine();
                switch(option){
                    case 1: addClient(scanner);
                    option = 0;
                    break;
                    case 2: addOrganization(scanner); 
                    option = 0;
                    break;
                }
            }
            catch(Exception ex){
                System.out.println("Please, entre a 1 or 2" );
                scanner.nextLine();
            }
        }
    }
    private static void addOrganization(Scanner scanner){
        System.out.println("Adding a organization. Entre name: ");

        String organizationName = checkingClientInfo(scanner);

        System.out.println("Entre owner's name: ");

        String ownerName = checkingClientInfo(scanner);
        System.out.println("Entre a client's check amount: ");

        int checkAmount = numberValidation(scanner);

        Client owner = new Client(ownerName, checkAmount);

        Organization organization = new Organization(organizationName, checkAmount, owner);

        for(int i = 0; i < checkAmount; i++){
            System.out.println("Entre a new check name: ");
            scanner.nextLine();
            String checkNumber = checkingCheckInfo(scanner);

            System.out.println("Entre a check balance: ");
            int checkBalance = scanner.nextInt();

            Check check = new Check(checkBalance, checkNumber, owner);
            organization.addCheckToClient(check);
            bank.addCheck(check);
        }
        bank.addClient(organization);
    }

    private static void printAllClients(){
        System.out.println("Clients in bank:");
        for(Client client: bank.getClientList()){
            System.out.println(client.getName() +" with " + client.getCheckAmount() + " checks");
        }
    }

    private static void addCheckToClient(Scanner scanner){
        System.out.println("Adding a check to client. Entre a client's name: ");
        String clientName = scanner.nextLine();

        for(Client client: bank.getClientList()){
          
            if(client.getName().equals(clientName)){
                System.out.println("Entre a new check name: ");
                String checkNumber = checkingCheckInfo(scanner);
    
                System.out.println("Entre a check balance: ");
                int checkBalance = scanner.nextInt();
    
                Check check = new Check(checkBalance, checkNumber, client);
                client.addCheckToClient(check);
                client.setCheckAmount(client.getCheckAmount() + 1);
                return;
            }
            System.out.println("Client with this name wasn't found!");
        }
    }

    private static void checkSum(String Text, String TEXT2, int num) {
       
        switch(num){
            case 1: 
            System.out.println(Text);
            for(Client client: bank.getClientList()){
                int sum = 0;
                    for(Check check: client.getChecks()){
                        sum += check.getBalance();
                    }
                System.out.println(client.getName() + " has " + sum + TEXT2);
            }
            break;
            case 2:
            System.out.println(Text);
            for(Client client: bank.getClientList()){
                int sum = 0;
                    for(Check check: client.getChecks()){
                        if (check.getBalance() < 0){
                        sum += check.getBalance();
                        }
                    }
                System.out.println(client.getName() + " has " + sum + TEXT2);
            }
            break;
            case 3:
            System.out.println(Text);
            for(Client client: bank.getClientList()){
                int sum = 0;
                    for(Check check: client.getChecks()){
                        if (check.getBalance() > 0){
                            sum += check.getBalance();
                            }
                    }
                System.out.println(client.getName() + " has " + sum + TEXT2);
            }
            break;
            default: System.out.println("Unknown error!");
        }  
    }

    private static String checkingClientInfo(Scanner scanner){
        String clientName;
        int index = 1;
        while(true){
            clientName = scanner.nextLine();
            for(Client client: bank.getClientList()){
                if(clientName.equals(client.getName())){
                    System.out.println("This name is taken!");
                    index = 0;
                    break;
                }
                index = 1; 
            }
            if(index != 1) continue;
            return clientName;
        }   
    }

    private static String checkingCheckInfo(Scanner scanner){
        String checkName;
        int index = 1;
        while(true){
            checkName = scanner.nextLine();
            for(Check check: bank.getChecksList()){
                if(checkName.equals(check.getNumber())){
                    System.out.println("This check is taken!");
                    index = 0;
                    break;
                }
                index = 1;
            }
            if(index != 1) continue;
            return checkName; 
        }
    }

    private static void searchCheck(Scanner scanner){
        System.out.println("Entre a check name: ");
        String checkName = scanner.nextLine();

        for(Check check: bank.getChecksList()){
            if(check.getNumber().equals(checkName)){
                System.out.println("This check is belong to " + check.getOwner().getName() + " and have " + check.getBalance() + " on balance");
                return;
            }
        }
        System.out.println("Check with name wasn't found!");
    }


    private static int numberValidation( Scanner scanner){
        int temp;
        while(true){
            try{
                temp = Integer.parseInt(scanner.next());
                break;
            }
            catch(Exception ex){
                System.out.println("Entre a number! ");
            }
        }
        return temp;
    }
    static String TextForSum1 = "Summing all checks";
    static String TextForSum2 = " in all checks";
    static String TextForNeg1 = "Summing negative checks";
    static String TextForNeg2 = " in negative checks";
    static String TextForPos1 = "Summing positive checks";
    static String TextForPoS2 = " in positive checks ";
}