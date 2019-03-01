package math;

/**
 * @Desc
 * 链接：https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
 * 来源：牛客网
 *
 * /*
 * 设N = abcde ,其中abcde分别为十进制中各位上的数字。
 * 如果要计算百位上1出现的次数，它要受到3方面的影响：百位上的数字，百位以下（低位）的数字，百位以上（高位）的数字。
 * ① 如果百位上数字为0，百位上可能出现1的次数由更高位决定。比如：12013，则可以知道百位出现1的情况可能是：100~199，1100~1199,2100~2199，，...，11100~11199，一共1200个。可以看出是由更高位数字（12）决定，并且等于更高位数字（12）乘以 当前位数（100）。
 * ② 如果百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响。比如：12113，则可以知道百位受高位影响出现的情况是：100~199，1100~1199,2100~2199，，....，11100~11199，一共1200个。和上面情况一样，并且等于更高位数字（12）乘以 当前位数（100）。但同时它还受低位影响，百位出现1的情况是：12100~12113,一共114个，等于低位数字（113）+1。
 * ③ 如果百位上数字大于1（2~9），则百位上出现1的情况仅由更高位决定，比如12213，则百位出现1的情况是：100~199,1100~1199，2100~2199，...，11100~11199,12100~12199,一共有1300个，并且等于更高位数字+1（12+1）乘以当前位数（100）。
 *
 * 注意11算两次，类似
 * @Author gcc
 * @Date 19-3-1 上午11:44
 **/
public class 区间内所有数中１出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i=1; i<=n; i*=10) {
            int high = n / (i * 10);
            int cur = (n / i) % 10;
            int low = n % i;
            if (cur == 0) {
                count += high * i;
            } else if (cur == 1) {
                count += high * i + low + 1;
            } else {
                count += (high + 1) * i;
            }
        }
        return count;
    }
}
