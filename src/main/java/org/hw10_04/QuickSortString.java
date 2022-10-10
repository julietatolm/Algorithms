package org.hw10_04;

import java.util.Arrays;

public class QuickSortString {
    //    Second level: 2. Отсортировать стрингу use QuickSort
    public static void main(String[] args) {
        String[] array = {"i","a", "z", "m", "w", "f", "o", "d", "b", "h", "n", "q"};

        System.out.println(Arrays.toString(array));
        quicksort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

        String str = "Hello. How are you?";
        System.out.println(str);
        str = quicksortString(str);
        System.out.println(str);

    }

// Quicksort for String

    public static String quicksortString(String str) {
        char[] charArr = str.toCharArray();
        quicksort(charArr, 0, charArr.length-1);
        return new String(charArr);
    }

    public static void quicksort(char[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        char pivot = array[(left+right) / 2];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index-1);
        quicksort(array, index, right);
    }

    private static int partition(char[] array, int left, int right, char pivot) {

        while(left <= right) {
            while((int)array[left] < (int) pivot) {
                left++;
            }
            while((int)array[right] > (int)pivot) {
                right--;
            }
            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] =  temp;
//        System.out.println(Arrays.toString(array));
    }


// Quicksort for String array

    public static void quicksort(String[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        String pivot = array[(left+right) / 2];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index-1);
        quicksort(array, index, right);
    }

    private static int partition(String[] array, int left, int right, String pivot) {

        while(left <= right) {
            char[] arrLeft = array[left].toCharArray();
            char[] arrRight = array[right].toCharArray();
            char[] arrPivot = pivot.toCharArray();


            while(((int) arrLeft[0]) < ((int) arrPivot[0])) {
                left++;
                arrLeft = array[left].toCharArray();
            }
            while(((int) arrRight[0]) > ((int) arrPivot[0])) {
                right--;
                arrRight = array[right].toCharArray();
            }
            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(String[] array, int left, int right) {
        String temp = array[left];
        array[left] = array[right];
        array[right] =  temp;
//        System.out.println(Arrays.toString(array));
    }
}
