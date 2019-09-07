import java.util.Scanner;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-9-1 下午3:02
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lin1 = sc.nextLine().split(",");
        String[] lin2 = sc.nextLine().split(",");
        int[] days = new int[lin1.length];
        int[] costs = new int[lin2.length];
        for (int i = 0; i < lin1.length; i++) {
            days[i] = Integer.parseInt(lin1[i]);
        }
        for (int i = 0; i < lin2.length; i++) {
            costs[i] = Integer.parseInt(lin2[i]);
        }
        // [0]为expire,[1]为expense
        int[][] dp = new int[costs.length][2];
        dp[0][0]=days[0];
        dp[1][0]=days[0]+6;
        dp[2][0]=days[0]+29;
        for (int i = 0; i < 3; i++) {
            dp[i][1]=costs[i];
        }
        for (int i = 1; i < days.length; i++) {
            int[] old0 = dp[0];
            int[] old1 = dp[1];
            int[] old2 = dp[2];
            if (old0[0] < days[i]) {
                dp[0][0] = days[i];
                dp[0][1] = Math.min(old0[1], Math.min(old1[1], old2[1])) + costs[0];
            }
            if (old1[1] < days[i]) {
                dp[1][0] = days[i] + 6;
                dp[1][1] = Math.min(old0[1], Math.min(old1[1], old2[1])) + costs[1]
            }
            if (old2[1] < days[i]) {
                dp[2][0] = days[i] + 29;
                dp[2][1] = Math.min(old0[1], Math.min(old1[1], old2[1])) + costs[2];
            }
//            StringBuilder sb = new StringBuilder();
//            sb.append(old0[0] + ":"+ old0[1] + " " + old1[0] + ":"+ old1[1] + " " + old2[0] + ":"+ old2[1]);
//            System.out.println(sb.toString());
        }
        System.out.println(Math.min(dp[0][1], Math.min(dp[1][1], dp[2][1])));
    }
}


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        String[] ss = new String[n];
//
//        for (int i = 0; i < n; i++) {
//            ss[i] = sc.nextLine();
//        }
//        for (int i = 0; i < n; i++) {
//            String s = ss[i];
//            if (s.length() < 8) {
//                System.out.println("NO");
//                continue;
//            }
//            if (Character.isDigit(s.charAt(0))) {
//                System.out.println("NO");
//                continue;
//            }
//            boolean hasA = false, hasa = false, has1 = false;
//            for (char c : s.toCharArray()) {
//                if (c >= '0' && c <= '9') {
//                    has1 = true;
//                    continue;
//                }
//                if (c >= 'a' && c <= 'z') {
//                    hasa = true;
//                    continue;
//                }
//                if (c >= 'A' && c <= 'Z') {
//                    hasA = true;
//                }
//            }
//
//            int count = 0;
//            if (hasA) {
//                count++;
//            }
//            if (hasa) {
//                count++;
//            }
//            if (has1) {
//                count++;
//            }
//            if (count < 2) {
//                System.out.println("NO");
//                continue;
//            }
//            System.out.println("YES");
//        }
//    }

