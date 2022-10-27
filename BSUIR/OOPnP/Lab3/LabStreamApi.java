package BSUIR.OOPnP.Lab3;

import java.util.ArrayList;
import java.util.stream.Stream;

public class LabStreamApi{

    public static void main(String[] args){
        int a = 8;
        //b возраснание
        //c  положительные числа
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int temp = 0; temp < a ; temp++){
            array.add((int)(Math.random()*30-15));
        }
        for(Integer num: array) System.out.println(num);

        Stream<Integer> streamList = array.stream();
        streamList.sorted();

        for(int num: streamList) System.out.println(num);
    }

}