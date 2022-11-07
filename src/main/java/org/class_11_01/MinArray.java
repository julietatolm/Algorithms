package org.class_11_01;

public class MinArray {
    public static void main(String[] args) {
        int[] array = {15,3,684,6,41,32,1,5,46,86,43,12,11};
        int[] s = {99, 99, 99, 99, 99, 99};
        int[] d = {1, 99, 99, 99, 99};

        getMin(array);

        getSecondMin(array);

        getSecondMin(s);
        getSecondMin(d);
    }

    public static void getMin(int[] array) {
        int min = array[0];
        int index = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        System.out.println("getMin: " + min);
    }

    public static void getSecondMin(int[] array) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min2 = min;
                min = array[i];
            } else if (array[i] < min2) {
                min2 = array[i];
            }
        }
        System.out.println("getMin: " + min);
        System.out.println("getSecondMin: " + min2);
    }
}
