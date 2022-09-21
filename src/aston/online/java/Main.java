package aston.online.java;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        MyArrayList<Integer> arr = new MyArrayList<>();

        for (int i = 0; i < 14; i++) {
            arr.add(i);
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println(arr.indexOf(1));

        System.out.println("");
        arr.remove(3);
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("");
        arr.add(3, 8);
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }

        System.out.print("");
        arr.clear();
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}
