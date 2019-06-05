package test;

import java.math.BigInteger;

public class unknownb {
    static int[] bs = {964, 524, 356, 268, 212, 172, 148, 124, 116, 104};
    static int a = 104;
    static int w = 4;
    public static void main(String[] args) {
        int[] opt = {0, 4, 15};
        int[] maxDelay = getDelay(a, bs, w, opt);
        double[] avgDelay = getAvgDelay(a, bs, w, opt);
        for (int i : maxDelay) {
            System.out.println(i);
        }
        for (double v : avgDelay) {
            System.out.println(v);
        }
    }

    public static int[] getDelay(int a, int[] bs, int w, int[] opt) {
        int[] res = new int[bs.length ];
        int len = a/w;
        for (int i = 0; i < bs.length; i++) {
            int max = Integer.MIN_VALUE;
            double avg = 0.0;
            int b = bs[i];
            int[] nums = getArray(a, b, w);
            int[] c1 = new int[len];
            int[] c2 = new int[len];
            for (int k = 0; k < len; k++) {
                c1[k] = nums[(k + opt[1])%len];
                c2[k] = nums[(k + opt[2])%len];
                int min = Math.min(nums[k], Math.min(c1[k], c2[k]));
                max = Math.max(max, min);
                avg += min;
            }
            res[i] = max * b;
        }
        return res;
    }

    public static double[] getAvgDelay(int a, int[] bs, int w, int[] opt) {
        double[] res = new double[bs.length];
        int len = a/w;
        for (int i = 0; i < bs.length; i++) {
            double avg = 0.0;
            int b = bs[i];
            int[] nums = getArray(a, b, w);
            int[] c1 = new int[len];
            int[] c2 = new int[len];
            for (int k = 0; k < len; k++) {
                c1[k] = nums[(k + opt[1])%len];
                c2[k] = nums[(k + opt[2])%len];
                int min = Math.min(nums[k], Math.min(c1[k], c2[k]));
                avg += min;
            }
            res[i] = (avg/len) * b;
        }
        return res;
    }

    private static int[] getArray(int a, int b, int w) {
        a = a/w;
        b = b/w;
        int k = 0;
        int d = 0;
        for (int i = 0; i < a; i++) {
            if (((b * i) % a) == (a - 1)) {
                k = i;
            }
        }
        int[] res = new int[a];
        res[1] = k;
        for (int i = 2; i < a; i++) {
            res[i] = (i * k) % a;
        }
        return res;
    }
}
