package sort;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-4-10 下午3:38
 **/
public class 逆序对个数 {

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    private int mergeSort(int[] array, int head, int tail) {
        if (head == tail) {
            return 0;
        }
        int mid = (head + tail) >> 1;
        return mergeSort(array, head, mid)
        + mergeSort(array, mid + 1, tail)
        + merge(array, head, mid, tail);
    }

    private int merge(int[] array, int head, int mid, int tail) {
        int[] temp = new int[tail - head + 1];
        int i = head;
        int j = mid + 1;
        int k = 0;
        int res = 0;
        while (i <= mid && j <= tail) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                // 到这里array[i] > array[j],
                // 因为array[head]-array[mid]是排好序的,所以array[i]...array[mid]都>array[j]
                // 共mid-i+1个

                //下面两句应该意思是一样的,只是角度不同
                res += mid - i + 1;
                //res = j - mid;
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= tail) {
            temp[k++] = array[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            array[l + head] = temp[l];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new test().InversePairs(new int[]{6, 2, 5, 3, 4, 0}));
    }
}
