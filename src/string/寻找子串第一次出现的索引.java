package string;

//https://leetcode.com/problems/implement-strstr/description/
//当needle为“”时，返回0
public class 寻找子串第一次出现的索引 {

    //寻找匹配的字符串，可能第一个出现的想法就是，用两个指针在两个字符串上跑
    //如果两个指针都相等，那么两指针都往前走一步。如果不相等，字串则回到0。
    //但是这样做要保护主串寻找的位置

    //举个例子 “mississippi” 与 “issip”。它们从第二个字符开始有部分匹配，但是没匹配上。此时
    //主串上的指针，应该到回到第三个字符处。也就是说，主串上就要维护两个指针，一个是指向开始匹配的
    //位置，另外一个负责匹配过程中指向待匹配字符。

    //但是下面的这种 方法，就很优雅，它使用i指向开始匹配的位置，j是字串的索引，那么i+j就指向了主串
    //中匹配过程中的待匹配字符
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()-1) {
                    return i;
                }
                if (i+j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i+j)) {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new 寻找子串第一次出现的索引().strStr("hello", "ll"));
    }
}
