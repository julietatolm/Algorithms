package org.hw_11_01;

public class MinArray {
    //Написать метод который находит 3 и 4 ый элемент в массиве
    public static void main(String[] args) {
        int[] array = {15, 3, 684, 6, 41, 32, 1, 5, 46, 86, 43, 12, 11};
//        int[] s = {99, 99, 99, 99, 99, 99};
//        int[] d = {1, 99, 99, 99, 99};
//        int[] a = {99, 99, 99, 99, 1};

        getThirdAndFourthMin(array);

//        getThirdAndFourthMin(a);

    }

    public static void getThirdAndFourthMin(int[] array) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min1) {
                min4 = min3;
                min3 = min2;
                min2 = min1;
                min1 = array[i];
            } else if (array[i] < min2) {
                min4 = min3;
                min3 = min2;
                min2 = array[i];
            } else if (array[i] < min3) {
                min4 = min3;
                min3 = array[i];
            } else if (array[i] < min4) {
                min4 = array[i];
            }
        }
        System.out.println("First Min: " + min1);
        System.out.println("Second Min: " + min2);
        System.out.println("Third Min: " + min3);
        System.out.println("Fourth Min: " + min4);
    }
}
