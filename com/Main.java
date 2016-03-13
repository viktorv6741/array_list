package com;

import com.MyArray;

public class Main {
    public static void main(String[] args) {

        MyArray <Integer> myArray1 = new MyArray<Integer>();

        initArray(myArray1);
        System.out.println(myArray1);
        System.out.println();

////////////////////////////////////////////////////////////////////////////////////////////////////////

        MyNewArray<Integer> myNewArray = new MyNewArray<Integer>();

        myNewArray.add(5);
        myNewArray.add(34);
        myNewArray.add(1);
        myNewArray.add(8);

        System.out.println(myNewArray);

        System.out.println();
        System.out.println(myNewArray.binarySearch(8));

        myNewArray.addCollection(myNewArray);

        System.out.println(myNewArray);

    }

    public static void initArray(MyArray myArray) {
        for (int i = 0; i < 10; i++) {
            int randomNumber = (int) (Math.random() * 100);
            myArray.add(randomNumber);
        }
    }
}
