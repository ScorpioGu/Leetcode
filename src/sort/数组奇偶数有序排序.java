package sort;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-4-16 上午9:47
 **/
public class 数组奇偶数有序排序 {
    /**
     * 奇数在前,偶数在后,保证相对位置不变,即稳定性.考虑插入排序
     *
     * 也可以使用归并排序,但是归并排序在merge的时候需要额外的空间,所以并不好
     * @param array
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        //记录最后一个奇数的位置
        int k = -1;
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            if ((temp & 1) == 1) {
                int j = i - 1;
                while (j > k) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
                k++;
            }
            // 偶数则不用动
        }
    }
}
