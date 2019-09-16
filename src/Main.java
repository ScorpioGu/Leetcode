import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(",");
        int[] xs = new int[ss.length];
        int[] ys = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            String[] cur = ss[i].split(" ");
            xs[i] = Integer.parseInt(cur[0]);
            ys[i] = Integer.parseInt(cur[1]);
        }
        int l = 231, r = -231, d = 231, u = -231;
        for (int i = 0; i < ss.length; i++) {
            l = Math.min(l, xs[i]);
            r = Math.max(r, xs[i]);
            d = Math.min(d, ys[i]);
            u = Math.max(u, ys[i]);
        }
        System.out.println(l + " " + d + "," + l + " " + u + "," + r + " " + u + "," + r + " " + d);
    }
}

