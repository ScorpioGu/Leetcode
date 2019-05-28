package sort;

import java.util.*;


public class Sort {
/*******************冒泡排序**********************/
    /**
     * 冒泡排序 稳定 o(n^2)
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
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
                    swap(nums, i, j);
                }
            }
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
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

/*******************快速排序**********************/
    /**
     * 快速排序优化，ref取三者中中间值  不稳定
     * 空间复杂度lgN
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        swap(nums, l + (int) (Math.random() * (r - l + 1)), r);
        int[] p = partition(nums, l, r);
        quickSort(nums, l, p[0] - 1);
        quickSort(nums, p[1] + 1, r);
    }

    public static int[] partition(int[] nums, int l, int r) {
        int less = l - 1;
        int more = r + 1;
        int ref = nums[r];
        // ref选为nums[r]
        while (l < more) {
            if (nums[l] < ref) {
                //因为l是大于less的，less+1处肯定已经被访问过了，并且等于ref
                //交换过来之后，没有必要对这个换过来的元素再进行判断了，所以可以l++
                swap(nums, ++less, l++);
            } else if (nums[l] > ref) {
                //这种情况下交换过来的元素还没有被访问过，所以交换过来还要比较一次，所以不能l++
                swap(nums, --more, l);
            } else {
                l++;
            }
        }
        return new int[] {less + 1, more - 1};
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
            int right = stack.pop();
            int left = stack.pop();
            int[] p = partition(nums, left, right);
            if (left < p[0] - 1) {
                stack.push(left);
                stack.push(p[0] - 1);
            }
            if (right > p[1] + 1) {
                stack.push(p[1] + 1);
                stack.push(right);
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
        if (head == tail) {
            return;
        }
        int mid = (head + tail) / 2;
        mergerSort(nums, head, mid);
        mergerSort(nums, mid + 1, tail);
        merge(nums, head, mid, tail);
    }

    private static void merge(int[] nums, int head, int mid, int tail) {
        // 传进来的nums,从head到mid是排好序的,从mid+1到tail是排好序的
        // 但是整体从head到tail并没有排好序, newNums是暂时用来保存整体的排序结果的
        // 等完全排好序之后,将newNums复制到nums中
        int[] newNums = new int[tail - head + 1];
        // 前半段的开始索引
        int i = head;
        // 后半段的开始索引
        int j = mid + 1;
        // 新数组的当前索引

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
    public static void mergeSortIter(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // i为跨度
        for (int i = 1; i <= nums.length; i *= 2) {
            // j为merge区间的起始位置
            for (int j = 0; j + i <= nums.length; j += i * 2) {
                //Math.min 的目的是处理 整个待排序数组为奇数的情况
                merge(nums, j, j + i - 1, Math.min(j + 2 * i - 1, nums.length - 1));
            }
        }
    }

/*******************堆排序**********************/
    /**
     * 堆排序
     * 初始建堆的时间复杂度为o(n)
     * 调整堆结构的时间复杂度为o(nlgn)
     *
     * @param nums
     */
    public static void heapSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            heapInsert(nums, i);
        }

        swap(nums, 0, --len);
        while (len > 0) {
            heapify(nums, len);
            swap(nums, 0, --len);
        }
    }

    private static void heapInsert(int[] nums, int i) {
        while (nums[i] > nums[(i - 1) / 2]) {
            swap(nums, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private static void heapify(int[] nums, int heapSize) {
        int parent = 0;
        int left = 2 * parent + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && nums[left] < nums[left + 1]
                    ? left + 1
                    : left;
            if (nums[parent] >= nums[largest]) {
                break;
            }
            swap(nums, parent, largest);
            parent = largest;
            left = 2 * parent + 1;
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
     * 计数排序，要求是数组里的元素是大于等于0的整数，因为这种排序是元素值作为数组的下标不能为负
     * 如果有负数的情况，将正负数分开，负数取绝对值排序，然后两组数合并.
     * 适用于类似分数等一系列元素为整数,且处于在一定范围内的元素排序,腾讯二面问道了
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
        for (int i = 0; i <= max; i++) {
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
     * 桶排序和计数排序类似,计数排序在元素值较为分散的时候,空间利用率不高,
     * count数组中会有很多位置存的都是0.桶排序可以解决这个问题.将同一段范围的元素放在
     * 同一个桶内.
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
        List<List<Integer>> buf = new ArrayList<List<Integer>>();
        for (int i = 0; i < 10; i++) {
            buf.add(new LinkedList<Integer>());
        }
        //找到数组中最大的数的位数，有多少位就要进行多次的分配与收集过程
        int maxBit = getMaxBit(nums);
        for (int i = 0; i < maxBit; i++) {
            //将数组nums里的元素分配到buf中
            distribute(nums, i, buf);
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

    private static List<List<Integer>> distribute(int[] nums, int iBit, List<List<Integer>> buf) {
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
        if (s.length()-1 < n) {
            return 0;
        }
        //如果char a = '4',想要得到整数类型4需要a-'0'。因为'4'的ascii码为'0'+4
        //如果不-'0'得到的结果是'4'这个字符的ascii码
        return s.charAt(s.length() - 1 - n) - '0';
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
}
