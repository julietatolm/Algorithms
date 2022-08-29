package org.hw08_23;


public class SpaceComplexity {
    public static void main(String[] args) {

        //Find the element that appears once in a sorted array - SC = O(n)
        // Given a sorted array in which all elements occur twice
        // (one after the other) and one element appears only once.

        int[] sortedArray = {1,1,2,2,3,3,4,4,5,6,6,7,7,8,8,9,9};                                //1
        if (sortedArray[0] != sortedArray[1]) {
            System.out.println("Element found - " + sortedArray[0]);
        }

        if (sortedArray[sortedArray.length-2] != sortedArray[sortedArray.length-1]) {
            System.out.println("Element found - " + sortedArray[sortedArray.length-1]);
        }

        for(int i = 1; i < sortedArray.length-1; i++) {                                     //n-2
        if (sortedArray[i] != sortedArray[i-1] && sortedArray[i] != sortedArray[i+1]) {
            System.out.println("Element found - " + sortedArray[i]);
        }
    }


    }
}
