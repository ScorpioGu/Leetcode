package sort;

import java.util.*;


public class Sort {
/*******************冒泡排序**********************/
    /**
     * 冒泡排序 稳定 o(n^2)
     *
     * @param nums
     */
    public static void BubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

/*******************选择排序**********************/
    /**
     * 选择排序 不稳定 o(n^2)
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

/*******************快速排序**********************/
    /**
     * 快速排序优化，ref取三者中中间值  不稳定
     *
     * @param nums
     * @param head
     * @param tail
     */
    public static void quickSort(int[] nums, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int mid = getMiddle(nums, head, tail);
        quickSort(nums, head, mid - 1);
        quickSort(nums, mid + 1, tail);
    }

/*******************快速排序的非递归实现**********************/
    /**
     * 快速排序的非递归实现,递归可能会导致栈溢出
     *
     * @param nums
     */
    public static void quickSortUsingStack(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(nums.length - 1);
        while (!stack.isEmpty()) {
            int tail = stack.pop();
            int head = stack.pop();
            int mid = getMiddle(nums, head, tail);
            if (head < mid - 1) {
                stack.push(head);
                stack.push(mid - 1);
            }
            if (tail > mid + 1) {
                stack.push(mid + 1);
                stack.push(tail);
            }
        }
    }

    private static int getMiddle(int[] nums, int head, int tail) {
        //优化的地方
        selectRefValue(nums, head, tail);
        int ref = nums[head];
        while (head < tail) {
            while (head < tail && nums[tail] >= ref) {
                tail--;
            }
            nums[head] = nums[tail];
            while (head < tail && nums[head] <= ref) {
                head++;
            }
            nums[tail] = nums[head];
        }
        nums[head] = ref;
        return head;
    }

    /**
     * 使得nums[head],nums[tail],nums[mid]三者中间的数与nums[head]交换
     *
     * @param nums
     * @param head
     * @param tail
     * @return
     */
    private static void selectRefValue(int[] nums, int head, int tail) {
        int mid = head + (tail - head) / 2;
        int temp;
        if (nums[mid] > nums[tail]) {
            temp = nums[mid];
            nums[mid] = nums[tail];
            nums[tail] = temp;
        }
        if (nums[head] > nums[tail]) {
            temp = nums[tail];
            nums[tail] = nums[head];
            nums[head] = temp;
        }
        if (nums[head] > nums[mid]) {
            temp = nums[head];
            nums[head] = nums[mid];
            nums[mid] = temp;
        }
    }

/*******************插入排序**********************/
    /**
     * 插入排序 稳定
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int temp;
        int j;
        for (int i = 1; i < nums.length; i++) {
            j = i - 1;
            temp = nums[i];
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

/*******************希尔排序**********************/
    /**
     * 希尔排序 不稳定
     *
     * @param nums
     */
    public static void shellSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int temp;
        for (int increment = nums.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < nums.length; i++) {
                if (nums[i] < nums[i - increment]) {
                    int j = i - increment;
                    temp = nums[i];
                    while (j >= 0 && nums[j] > temp) {
                        nums[j + increment] = nums[j];
                        j -= increment;
                    }
                    nums[j + increment] = temp;
                }
            }
        }
    }

/*******************归并排序**********************/
    /**
     * 归并排序 稳定
     *
     * @param nums
     * @param head
     * @param tail
     */
    public static void mergerSort(int nums[], int head, int tail) {
        if (nums == null || nums.length <= 1)
            return;
        int mid = (head + tail) / 2;
        if (head < tail) {
            mergerSort(nums, head, mid);
            mergerSort(nums, mid + 1, tail);
            merge(nums, head, mid, tail);
        }
    }

    private static void merge(int[] nums, int head, int mid, int tail) {
        int[] newNums = new int[tail - head + 1];
        int i = head;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= tail) {
            if (nums[i] < nums[j]) {
                newNums[k++] = nums[i++];
            } else {
                newNums[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            newNums[k++] = nums[i++];
        }

        while (j <= tail) {
            newNums[k++] = nums[j++];
        }

        for (int k2 = 0; k2 < newNums.length; k2++) {
            nums[head + k2] = newNums[k2];
        }
    }

    /*******************归并排序的非递归实现**********************/
    public static void mergeSortUsingStack(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(nums.length - 1);
        while (!stack.isEmpty()) {
            int tail = stack.pop();
            int head = stack.pop();
            int mid = (head + tail) / 2;
        }
        //TODO
    }

/*******************堆排序**********************/
    /**
     * 堆排序
     *
     * @param nums
     */
    public static void HeapSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            buildMaxHeap(nums, len - i - 1);
            swap(nums, 0, len - i - 1);
        }
    }

    /**
     * 建堆，最大值在堆顶
     *
     * @param nums
     * @param lastIndex
     */
    private static void buildMaxHeap(int[] nums, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            //检测下标为k的节点是否有子节点
            while (k * 2 + 1 <= lastIndex) {
                int biggerIndex = k * 2 + 1;
                //判断是否有右子节点
                if (biggerIndex < lastIndex) {
                    if (nums[biggerIndex] < nums[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }
                if (nums[biggerIndex] > nums[k]) {
                    swap(nums, biggerIndex, k);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }

    }

    /**
     * 交换nums[i]与nums[j]
     *
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

/*******************计数排序**********************/
    /**
     * 计数排序，要求是数组里的元素是大于0的整数，因为这种排序是元素值作为数组的下标不能为负
     * 如果有负数的情况，将正负数分开，负数取绝对值排序，然后两组数合并
     *
     * @param nums
     */
    public static void countSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int max = getMax(nums);
        int k = 0;
        int[] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++] = i;
            }
        }
    }

    private static int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            max = i > max ? i : max;
        }
        return max;
    }

/*******************桶排序**********************/
    /**
     * 桶排序，假设nums中元素范围是[0-100]
     *
     * @param nums
     */
    public static void bucketSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        //定义桶的个数
        int bucketNums = 10;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>();
        //每个桶都定义成linkedlist类型
        for (int i = 0; i < bucketNums; i++) {
            buckets.add(new LinkedList<Integer>());
        }

        //将数组每个元素放入对应的桶中
        for (int i = 0; i < nums.length; i++) {
            buckets.get(f(nums[i])).add(nums[i]);
        }

        //对每个单独的桶中元素进行快速排序
        for (int i = 0; i < buckets.size(); i++) {
            if (!buckets.get(i).isEmpty()) {
                Collections.sort(buckets.get(i));
            }
        }

        int k = 0;
        for (int i = 0; i < buckets.size(); i++) {
            for (int e : buckets.get(i)) {
                nums[k++] = e;
            }
        }
    }

    private static int f(int x) {
        return x / 10;
    }

/*******************基数排序**********************/
    /**
     * 基数排序（LSD）
     *
     * @param nums
     */
    public static void radixSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        //找到数组中最大的数的位数，有多少位就要进行多次的分配与收集过程
        int maxBit = getMaxBit(nums);
        for (int i = 1; i <= maxBit; i++) {
            //将数组nums里的元素分配到buf中
            List<List<Integer>> buf = distribute(nums, i);
            //将buf中的元素收集到nums中
            collect(nums, buf);
        }
    }

    private static void collect(int[] nums, List<List<Integer>> buf) {
        int k = 0;
        for (int i = 0; i < buf.size(); i++) {
            for (int e : buf.get(i)) {
                nums[k++] = e;
            }
        }
    }

    private static List<List<Integer>> distribute(int[] nums, int iBit) {
        List<List<Integer>> buf = new ArrayList<List<Integer>>();
        for (int i = 0; i < 10; i++) {
            buf.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < nums.length; i++) {
            int bitValue = getNBit(nums[i], iBit);
            buf.get(bitValue).add(nums[i]);
        }
        return buf;
    }

    /**
     * 取整数x的第n位数，若没有第n位数返回0
     *
     * @param x
     * @param n
     * @return
     */
    private static int getNBit(int x, int n) {
        String s = x + "";
        if (s.length() < n)
            return 0;
        //如果char a = '4',想要得到整数类型4需要a-'0'。因为'4'的ascii码为'0'+4
        //如果不-'0'得到的结果是'4'这个字符的ascii码
        return s.charAt(s.length() - n) - '0';
    }

    /**
     * 取得一个整数数组中最大的位数
     *
     * @param nums
     * @return
     */
    private static int getMaxBit(int[] nums) {
        int maxbit = 0;
        for (int e : nums) {
            String s = e + "";
            maxbit = s.length() > maxbit ? s.length() : maxbit;
        }
        return maxbit;
    }
}
