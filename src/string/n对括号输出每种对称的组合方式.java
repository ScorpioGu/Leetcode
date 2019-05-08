package string;

import java.util.ArrayList;

public class n对括号输出每种对称的组合方式 {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList();
		dfs(res, new StringBuilder(), 0, 0, n);
		return res;
	}

	private void dfs(ArrayList<String> res, StringBuilder sb, int open, int close, int n) {
		// 如果open < close就没用了
		// 如果open > close 可以添加open,可以添加close
		// 如果open = close，只能添加open
		// 如果任意一个大于n，就没用了

		// 始终保持open >= close
		// 如果open = close = n，就成了
		if (open == n && close == n) {
			res.add(sb.toString());
			return;
		}
		if (open > n || close > n || close > open) {
			return;
		}

		sb.append("(");
		dfs(res, sb, open + 1, close, n);
		sb.deleteCharAt(sb.length()-1);

		sb.append(")");
		dfs(res, sb, open, close+1, n);
		sb.deleteCharAt(sb.length()-1);
	}
}
