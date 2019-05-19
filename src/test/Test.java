package test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Desc TODO
 * @Author gcc
 * @Date 19-5-19 下午4:26
 **/
public class Test {

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
                swap(nums, ++less, l++);
            } else if (nums[l] > ref) {
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

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    // 对数器

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            //quickSortUsingStack(arr1);
            quickSort(arr1, 0 ,arr1.length-1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        // 如果错了，下面就是错误样本
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
//        quickSortUsingStack(arr);
        quickSort(arr, 0 ,arr.length-1);
        printArray(arr);
    }
}
