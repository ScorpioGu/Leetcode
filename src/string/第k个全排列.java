package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc https://leetcode.com/problems/permutation-sequence/description/
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * @Author gcc
 * @Date 18-10-24 下午4:00
 **/
public class 第k个全排列 {
    public String getPermutation(int n, int k) {
        if (n < 1) {
            return null;
        }
        //保存每个阶乘的结果，否则每次都调用阶乘方法，时间复杂度会增加
        int[] factorial = new int[n+1];
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        k--;
        for (int i = 1; i <= n ; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(list.get(index)));
            //remove有根据下标移除以及根据所要移除对象引用移除两个方法
            //当泛型对象恰好为Integer时，会出现remove(3)到底时移除坐标为3还是值为3的Integer对象的问题
            //实际上，remove(3)根据坐标移除，remove（Integer（3））是根据对象引用删除
            list.remove(index);
            k -= index * factorial[n - i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new 第k个全排列().getPermutation(3,3));
    }
}
