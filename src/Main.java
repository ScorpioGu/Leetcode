import java.util.*;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-9-1 下午3:02
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String[] input = sc.nextLine().split(";");
//        String[] nums = input[0].split(",");
//        int n = Integer.parseInt(input[1]);
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if ((o1 % 2 == 1) && (o2 % 2 == 1)) {
//                    return o2 - o1;
//                }
//                if ((o1 % 2 == 0) && (o2 % 2 == 0)) {
//                    return o2 - o1;
//                }
//                if (o1 % 2 == 0) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        });
//        for (String num : nums) {
//            pq.offer(Integer.parseInt(num));
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            sb.append(pq.poll()).append(",");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        System.out.println(sb.toString());

        int n = Integer.parseInt(sc.nextLine());
        List<List<List<Character>>> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();


            // DFS
            List<List<Character>> res = new ArrayList<>();
            dfs(res, new ArrayList<Character>(), s1, "", s2);
            lists.add(res);
        }
        for (List<List<Character>> list : lists) {
            System.out.println("{");
            Collections.sort(list, new Comparator<List<Character>>() {
                @Override
                public int compare(List<Character> o1, List<Character> o2) {
                    String s1 = "";
                    for (Character c : o1) {
                        s1 += c;
                    }
                    String s2 = "";
                    for (Character c : o2) {
                        s2 += c;
                    }
                    return s1.compareTo(s2);
                }
            });
            for (List<Character> characters : list) {
                StringBuilder sb = new StringBuilder();
                for (Character character : characters) {
                    sb.append(character).append(" ");
                }
                System.out.println(sb.toString());
            }
            System.out.println("}");
        }
    }

    private static void dfs(List<List<Character>> res, List<Character> cur, String old, String nu, String s2) {
        if (nu.equals(s2)) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (nu.length() > s2.length()) {
            return;
        }
        if (old.length() < 1) {
            return;
        }
        String tempOld = old.substring(1);
        cur.add('d');
        dfs(res, cur, tempOld, nu, s2);
        cur.remove(cur.size()-1);

        char c = old.charAt(0);
        tempOld = old.substring(1);
        String tempNew = c + nu;
        cur.add('l');
        dfs(res, cur, tempOld, tempNew, s2);
        cur.remove(cur.size()-1);

        c = old.charAt(0);
        tempOld = old.substring(1);
        tempNew = nu + c;
        cur.add('r');
        dfs(res, cur, tempOld, tempNew, s2);
        cur.remove(cur.size()-1);
    }
}
