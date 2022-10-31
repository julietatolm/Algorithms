package org.class_10_25;

import java.util.ArrayList;
import java.util.Arrays;

public class Search {
    public static void main(String[] args) {

        int[] arr = {-2, -1, 0, 2, 3, 4, 5, 6, 10};
        System.out.println(Arrays.toString(directSearch(arr, 7)));

        twoFocus(arr, 7);
        System.out.println("************");
        twoFocusReverse(arr, 7);



    }

    public static int[] directSearch(int[] num, int k) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] == k) {
                    return new int[] {num[i], num[j]};
                }
                if (num[i] + num[j] > k) {
                    j = num.length;
                }
            }
        }
        return new int[0];
    }

    public static ArrayList<int[]> twoFocus(int[] num, int k) {
        ArrayList<int[]> arr = new ArrayList<>();
        int i = 0;
        int j = num.length - 1;

        while (j > i) {
            if (num[i] + num[j] == k) {
                arr.add(new int[] {num[i], num[j]});
                System.out.println(num[i] + " " + num[j]);
                i++;
                j--;
            } else if (num[i] + num[j] > k) {
                j--;
            } else
                i++;
        }

        return new ArrayList<>();
    }

    public static ArrayList<int[]> twoFocusReverse(int[] num, int k) {
        ArrayList<int[]> arr = new ArrayList<>();
        int l = 0;
        int r = num.length - 1;

        while (r > l) {
        int res = k - num[r];
            if (res == num[l]) {
                arr.add(new int[] {num[l], num[r]});
                System.out.println(num[l] + " " + num[r]);
                l++;
                r--;
            } else if (res < num[l] ) {
                r--;
            } else
                while (num[l] < res) {
                    l++;
                }
        }

        return new ArrayList<>();
    }
}
