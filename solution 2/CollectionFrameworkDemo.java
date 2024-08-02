package org.com.storage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionFrameworkDemo {

    // Function to convert an array of objects to a List
    public static List<String> arrayToList(String[] array) {
        List<String> list = new ArrayList<>();
        for (String element : array) {
            list.add(element);
        }
        return list;
    }

    public static void main(String[] args) {
        // Demonstrate ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("arrayList 1");
        arrayList.add("arrayList 2");
        arrayList.add("arrayList 3");

        System.out.println("ArrayList elements:");
        for (String element : arrayList) {
            System.out.println(element);
        }

        // Demonstrate Vector
        Vector<String> vector = new Vector<>();
        vector.add("vector A");
        vector.add("vector B");
        vector.add("vector C");

        System.out.println("\nVector elements:");
        for (String element : vector) {
            System.out.println(element);
        }

        // Demonstrate LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("linkedList 1");
        linkedList.add("linkedList 2");
        linkedList.add("linkedList 3");

        System.out.println("\nLinkedList elements:");
        for (String element : linkedList) {
            System.out.println(element);
        }

        // Convert array to List
        String[] array = {"convert 1", "convert 2", "convert 3"};
        List<String> listFromArray = arrayToList(array);

        System.out.println("\nList from array elements:");
        for (String element : listFromArray) {
            System.out.println(element);
        }
    }
}
