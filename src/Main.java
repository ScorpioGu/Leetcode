import java.util.Scanner;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-9-1 下午3:02
 **/
public class Main {
    static int m;
    static int n;
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int res = BinarySearch(a, n, m);
        System.out.println(res);
    }

    static int BinarySearch(int A[], int n, int k) {
        int lo = getMax(A, n);
        int hi = getSum(A, n);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int requiredPainters = getRequiredPainters(A, n, mid);
            if (requiredPainters <= k)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    static int getMax(int A[], int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] > max){ max = A[i];}

        }
        return max;
    }

    static int getSum(int A[], int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += A[i];
        }

        return total;
    }

    static int getRequiredPainters(int A[], int n, int maxLengthPerPainter) {
        int total = 0, numPainters = 1;
        for (int i = 0; i < n; i++) {
            total += A[i];
            if (total > maxLengthPerPainter) {
                total = A[i];
                numPainters++;
            }
        }
        return numPainters;
    }

}
