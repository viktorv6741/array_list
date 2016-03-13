package com;

import java.util.Arrays;

public class MyNewArray <T> implements Comparable<MyNewArray>  {

    private static final int CAPACITY = 1;
    private T [] array;
    private int currentPosition;

//////////////////////////////////////////////////////////////////////

    public MyNewArray(T [] array) {
        this.array = array;
        this.currentPosition = array.length;
    }

    public MyNewArray() {

        array = (T[])new Object [CAPACITY];
        this.currentPosition = 0;
    }

//////////////////////////////////////////////////////////////////////

    public T[] getArray() {
        return array;
    }

//////////////////////////////////////////////////////////////////////

    public void add(T newElement) {
        if (currentPosition >= array.length) {
            array = Arrays.copyOf(array, array.length + CAPACITY);
        }
        array[currentPosition++] = newElement;
    }

    public void remove(int index) {
        try {
            int copyLength = array.length - index - 1;
            System.arraycopy(array, index + 1, array, index, copyLength);
            array[array.length - 1] = null;
            currentPosition--;

            array = Arrays.copyOf(array, currentPosition); // trim to size
        } catch (RuntimeException e) {
            System.out.println("Not appropriate action\n" +
                    "Out of array's bound");
        }
    }

    public void addCollection(MyNewArray myNewArray) {
        int newLength = array.length + myNewArray.getArray().length;
        array = Arrays.copyOf(array, newLength);

        System.arraycopy(myNewArray.getArray(), 0, array, currentPosition, currentPosition);
    }

///////////////////////////////////////////////////////////////////

    public  <T extends Comparable> T  getMin(){
        T min = (T) array[0];
        for (int i = 0; i < array.length; i++){
              if (min.compareTo(array[i]) > 0){
                  min = (T) array[i];
              }
        }
        return min;
    }

    public  <T extends Comparable> T  getMax(){
        T max = (T) array[0];
        for (int i = 0; i < array.length; i++){
            if (max.compareTo(array[i]) < 0){
                max = (T) array[i];
            }
        }
        return max;
    }

///////////////////////////////////////////////////////////////////

    public <T extends Comparable> int binarySearch(T x){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int mid = low + (high - 1) / 2;

            if(x == array[mid]){
                return mid;
            }else if(x.compareTo(array[mid]) > 0){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return 888;
    }

//////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public int compareTo(MyNewArray o) {
        return 0;
    }
}
