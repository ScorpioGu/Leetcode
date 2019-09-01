import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-9-1 下午3:02
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(";");
        String[] nums = input[0].split(",");
        int n = Integer.parseInt(input[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if ((o1 % 2 == 1) && (o2 % 2 == 1)) {
                    return o2 - o1;
                }
                if ((o1 % 2 == 0) && (o2 % 2 == 0)) {
                    return o2 - o1;
                }
                if (o1 % 2 == 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (String num : nums) {
            pq.offer(Integer.parseInt(num));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(pq.poll()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
