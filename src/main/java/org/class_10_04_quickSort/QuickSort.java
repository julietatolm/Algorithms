package org.class_10_04_quickSort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {12,1,25,6,7,40, 45, 70, 55, 1000, 12,1,25,6,7,40};

        System.out.println(Arrays.toString(array));

        quickSort(array, 0, array.length-1);

        System.out.println(Arrays.toString(array));

    }

    private static int partition(int[] array, int begin, int end) {
        int counter = begin;

        for (int i = begin; i < end; i++) {
            if (array[i] < array[end]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[end];
        array[end] = array[counter];
        array[counter] = temp;

        return counter;
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }

        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);


    }
}
