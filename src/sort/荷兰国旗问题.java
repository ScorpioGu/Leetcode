package sort;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-5-19 下午7:32
 **/
public class 荷兰国旗问题 {
    /**
     * 小于p的元素放左边，等于的放中间，大于的放右边
     * @param arr
     * @param l
     * @param r
     * @param p
     * @return
     */
    public static int[] partition(int[] arr, int l, int r, int p) {
        // less,more是小于，大于区域的边界
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < p) {
                // 这种情况，交换过来的一定是等于p的元素，所以l可以++
                swap(arr, ++less, l++);
            } else if (arr[l] > p) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[] { less + 1, more - 1 };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
