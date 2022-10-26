package org.class_10_11_outSearcher;

public class OutSearcher {
    public static void main(String[] args) {
        System.out.println(getPath(10,10));
    }

    public static int getPath(int n, int m) {
        if (n < 1 || m < 1) return 0;
        if (n == 1 && m == 1) return 1;
        return getPath(n-1, m) + getPath(n, m-1);
    }
}
