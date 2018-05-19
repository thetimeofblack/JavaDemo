package coreJava.chapter9;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        String context = "I love China, I love China, I love China";
        String[] array = context.split(" |,");
        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i],hashMap.getOrDefault(array[i],0) + 1);
        }
        //keys
        for(String s : hashMap.keySet()){

            System.out.print(s + " ");
        }
        System.out.println();
        //values
        for(int i : hashMap.values()){
            System.out.println(i + " ");
        }
        //Entry
        for (Map.Entry<String,Integer> entry : hashMap.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }

        System.out.println();
        hashMap.forEach((k,v)->
                System.out.println("word = " + k + " ,frequency = " + v));
        }
}
