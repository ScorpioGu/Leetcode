package array;
//https://leetcode.com/problems/palindrome-number/description/
//如果把x翻转的话，可能会出现溢出的情况。
//但是判断回文的话，只需要翻转一半就可以了，这样的话也不用考虑溢出。
public class 判断数字是否回文 {
    public boolean isPalindrome(int x) {
        //负的肯定不是回文拉，末尾带0的也不行
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;

        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        //考虑到x的长度为奇为偶
        return (x==rev || x==rev/10);
    }
}
