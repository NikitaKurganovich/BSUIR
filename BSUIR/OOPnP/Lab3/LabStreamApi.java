package BSUIR.OOPnP.Lab3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class LabStreamApi{


    public static void main(String[] args){
        int a = 8;
        int size = 15;
        //b возраснание
        //c  положительные числа
        //2.1
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int temp = 0; temp < a ; temp++){
            array.add((int)(Math.random()*30-15));
        }
        System.out.println("Generated array:");
        for(Integer num: array) System.out.format("%s, ", num);
        System.out.println("");

        Stream<Integer> streamList = array.stream();
        System.out.println("Sorted via stream array:");
    
        streamList.sorted().forEach(num -> System.out.format("%s, ", num));

        ArrayList<Integer> tempArray = new ArrayList<Integer>(array);
    
        tempArray.removeIf(num->(num>0));
        System.out.println("");
        System.out.println("Array with removed positive numbers:");
        for(Integer num: tempArray) System.out.format("%s, ", num);

        String[] strings = array.stream().map(num -> num.toString()).toArray(String[]::new );

        System.out.println("");
        System.out.println("Int array that converted to string:");
        for(String temp: strings) System.out.format("%s, ", temp);

        Scanner scanner = new Scanner(System.in);
        int option = 1;

        while(option != 0){
            System.out.println("\n1 - random list \n2 - manual input");
            try{
                option = scanner.nextInt();
                scanner.nextLine();
                switch(option){
                                case 1: 
                                System.out.println("");
                                System.out.println("List for task 2.1:");
                                ArrayList<Integer> listFor21 = new ArrayList<Integer>();
                                for(int temp = 0; temp < size ; temp++){
                                    listFor21.add((int)(Math.random()*60-30));
                                }
                                for(Integer num: listFor21) System.out.format("%s, ", num);
                        
                                System.out.println("");
                                System.out.println("Random number for task 2.1:");
                                int random4ick =(int)(Math.random()*30-15);
                        
                                System.out.println(random4ick);
                                for(int i = 0 ; i<size ;i++){
                                    for(int j = 0; j< size-1;j++){
                                        if(listFor21.get(i) <= random4ick && listFor21.get(j) > random4ick){
                                            int temp = listFor21.get(i);
                                            listFor21.set(i, listFor21.get(j));
                                            listFor21.set(j, temp);
                                        }
                                    }
                                }
                                System.out.println("Sorted array:");
                                for(int temp: listFor21) System.out.format("%s, ", temp);
                                scanner.close();
                                return;


                                case 2:  System.out.println("");
                                ArrayList<Integer> manualListFor21 = new ArrayList<Integer>();
                                System.out.println("Entre size of list:");
                                size = scanner.nextInt();
                                System.out.println("Entre values:");

                                for(int temp = 0; temp < size ; temp++){
                                    manualListFor21.add(scanner.nextInt());
                                }
                                System.out.println("Entre parametr for list:");
                                int par = scanner.nextInt();
                                    for(int i = 0 ; i<size ;i++){
                                    for(int j = 0; j< size-1;j++){
                                        if(manualListFor21.get(i) <= par && manualListFor21.get(j) > par){
                                            int temp = manualListFor21.get(i);
                                            manualListFor21.set(i, manualListFor21.get(j));
                                            manualListFor21.set(j, temp);
                                        }
                                    }
                                }
                            System.out.println("Sorted array:");
                            for(int temp: manualListFor21) System.out.format("%s, ", temp); 
                            scanner.close();
                            return;

                 
                }
            }
            catch(Exception ex){
                System.out.println("Please, entre a value between 1 or 2 ");
                scanner.nextLine();
            }
        }
        

       

    }

    


}