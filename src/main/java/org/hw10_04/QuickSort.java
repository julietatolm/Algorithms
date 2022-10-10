package org.hw10_04;

import java.util.Arrays;

public class QuickSort {
//    First level: 1. Написать свою реализацию QuickSort
    public static void main(String[] args) {
//        int[] array = {0, 12,1,25,6,7,40, 45, 70, 55, 1000, 12,1,25,6,7,40, 0};
        int[] array = {0, 12,1,25,6,7,40};

        System.out.println(Arrays.toString(array));
        quicksort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public static void quicksort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        int pivot = array[(left+right) / 2];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index-1);
        quicksort(array, index, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while(left <= right) {
            while(array[left] < pivot) {
                left++;
            }
            while(array[right] > pivot) {
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

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] =  temp;
        System.out.println(Arrays.toString(array));
    }




}
