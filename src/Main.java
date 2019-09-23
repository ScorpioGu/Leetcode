import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        Set<String> set = new HashSet<>();
        // 去重
        for (String s1 : s) {
            set.add(s1);
        }

        // 计数
        Map<String, Node> map = new HashMap<>();
        for (String s1 : set) {
            String city = s1.split("-")[1];
            if (map.containsKey(city)) {
                map.get(city).count++;
            } else {
                map.put(city, new Node(city));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->{
            if (a.count == b.count) {
                return a.city.compareTo(b.city);
            } else {
                return b.count - a.count;
            }
        });

        for (Node node : map.values()) {
            pq.add(node);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(pq.poll());
        }

    }

    static class Node {
        String city;
        int count;

        public Node(String city) {
            this.city = city;
            this.count = 1;
        }

        @Override
        public String toString() {
            return this.city + " " + this.count;
        }
    }
}

