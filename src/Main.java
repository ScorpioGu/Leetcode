import java.util.Scanner;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-9-1 下午3:02
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] ss = new String[n];

        for (int i = 0; i < n; i++) {
            ss[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String s = ss[i];
            if (s.length() < 8) {
                System.out.println("NO");
                continue;
            }
            if (Character.isDigit(s.charAt(0))) {
                System.out.println("NO");
                continue;
            }
            boolean hasA = false, hasa = false, has1 = false;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    has1 = true;
                    continue;
                }
                if (c >= 'a' && c <= 'z') {
                    hasa = true;
                    continue;
                }
                if (c >= 'A' && c <= 'Z') {
                    hasA = true;
                }
            }

            int count = 0;
            if (hasA) {
                count++;
            }
            if (hasa) {
                count++;
            }
            if (has1) {
                count++;
            }
            if (count < 2) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }

    }
}
