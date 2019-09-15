
import java.util.*;

public class Main {
    static int el = 500;
    static int er = -500;
    static int eu = -500;
    static int ed = 500;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        Point end = new Point(x, y);
        Set<Point> stones = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int curx = sc.nextInt();
            int cury = sc.nextInt();
            stones.add(new Point(curx, cury));
            el = Math.min(el, curx);
            er = Math.max(er, curx);
            eu = Math.max(eu, cury);
            ed = Math.min(ed, cury);
        }
        Set<Point> his = new HashSet<>();
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        int path = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Point p = queue.poll();
                if (p.equals(end)) {
                    System.out.println(path);
                    return;
                }
                size--;
                Point left = new Point(p.x - 1, p.y);
                if (!stones.contains(left) && !his.contains(left) && inArea(left.x, left.y)) {
                    queue.offer(left);
                }
                Point right = new Point(p.x + 1, p.y);
                if (!stones.contains(right) && !his.contains(right) && inArea(right.x, right.y)) {
                    queue.offer(right);
                }
                Point down = new Point(p.x, p.y - 1);
                if (!stones.contains(down) && !his.contains(down) && inArea(down.x, down.y)) {
                    queue.offer(down);
                }
                Point up = new Point(p.x, p.y + 1);
                if (!stones.contains(up) && !his.contains(up) && inArea(up.x, up.y)) {
                    queue.offer(up);
                }
                his.add(p);
            }
            path++;
        }
    }

    private static boolean inArea(int x, int y) {
        if (x < el - 1 || x > er + 1 || y < ed - 1 || y > eu + 1) {
            return false;
        }
        return true;
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
