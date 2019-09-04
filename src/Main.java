import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-9-1 下午3:02
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                Queue<Character> q = new LinkedList<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    q.offer(stack.pop());
                }
                stack.pop();
                while (!q.isEmpty()) {
                    stack.push(q.poll());
                }
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(' || c == ')') {
                System.out.println("");
                return;
            }
            sb.append(c);
        }
        System.out.println(sb.reverse().toString());
    }
}
