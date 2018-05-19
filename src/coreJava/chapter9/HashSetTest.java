package coreJava.chapter9;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        Iterator<String> iterator = hashSet.iterator();
        hashSet.add("Eason");
        hashSet.add("Jason");
        hashSet.add("Michael");
        for(String s : hashSet){
            System.out.println(s);
        }

    }
}
