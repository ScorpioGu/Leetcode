package array;

/**
 * @Desc https://www.cnblogs.com/grandyang/p/5310649.html
 * 名人满足的条件是，所有人认识他，但是他不认识所有其他人
 * 显然名人只能有1个，如果有两个就会冲突
 * @Author gcc
 * @Date 19-6-12 下午5:25
 **/
public class 寻找名人 {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            // 如果为true,candidate一定不是名人，如果为false,i一定不是名人
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        // 遍历一遍之后，要么名人就是candidate，要么就没有名人
        // 对于i从candidate到n，有knows(candidate, i)=false
        // 所以分两段
        for (int i = 0; i < candidate; i++) {
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        for (int i = candidate + 1; i < n; i++) {
            if (!knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }

    /**
     * 该方法的返回值表示i是否认识ｊ
     * @param i
     * @param j
     * @return
     */
    public boolean knows(int i, int j) {
        return true;
    }
}
