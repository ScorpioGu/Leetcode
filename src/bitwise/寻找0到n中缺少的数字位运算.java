package bitwise;


//寻找0,1,2，。。。n-1中缺少的数字，数组长度为n。丢失的那个数一定被替换成了n。
//抑或操作a^b^b=a。存在的数字和其坐标抑或=0。那么把所有的元素与坐标抑或，剩下的肯定时丢失的元素。（抑或满足交换律）
//res的初始值时n，是因为丢失的那个数被替换成了n，抑或可以抵消。
//举个例子 【0,1,3】
//3 ^ 0 ^ 0 ^ 1 ^ 1 ^ 2 ^ 3。剩下的2.
public class 寻找0到n中缺少的数字位运算 {
    int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length ; i++) {
            res = res ^ nums[i] ^ i;

        }
        return res;
    }
}
