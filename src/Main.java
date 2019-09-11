import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 2, 7, 6}));
    }

    public static int solution(int[] arr) {
        int[] z = Arrays.copyOf(arr, arr.length);
        Arrays.sort(z);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < z.length; i++) {
            map.put(z[i], i);
        }
        int loops = 0;//循环节个数
        boolean[] flag = new boolean[arr.length];
        //找出循环节的个数
        for (int i = 0; i < arr.length; i++){
            if (!flag[i]) {//已经访问过的位置不再访问
                int j = i;
                while (!flag[j]) {
                    flag[j] = true;
                    j = map.get(arr[j]);
                }
                loops++;
            }
        }
        return arr.length - loops;

    }
}

