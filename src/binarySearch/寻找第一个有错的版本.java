package binarySearch;

/**
 * @Desc https://leetcode.com/problems/first-bad-version/
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 * @Author gcc
 * @Date 18-12-4 下午3:36
 **/
public class 寻找第一个有错的版本 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            //注意不要写成(left + right)/2,可能会出现两个int之和大于int上界的问题
            int mid = left + (right - left)/2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 这个是没用的,为了防止编译器报错,随便写了个放这里
     * @param version
     * @return
     */
    boolean isBadVersion(int version) {
        return false;
    }
}
