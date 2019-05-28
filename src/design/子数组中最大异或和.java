package design;

/**
 * @Desc
 * @Author gcc
 * @Date 19-5-28 下午5:05
 **/
public class 子数组中最大异或和 {
    public static class Node {
        public Node[] nexts = new Node[2];
    }


    public static class NumTrie {
        public Node head = new Node();

        /**
         * 将num添加进前缀树
         * @param num
         */
        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                // 从高到低依次取出每一位
                int path = ((num >> move) & 1);
                if (cur.nexts[path] == null) {
                    cur.nexts[path] = new Node();
                }
                // 向下一个节点移动
                cur = cur.nexts[path];
            }
        }

        /**
         * 传入的num就是一段前缀异或和，从前缀树中找到一个已有的前缀异或和，使其异或和最大
         * 返回这个最大的异或和
         * @param num
         * @return
         */
        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                // path只能是0或者1
                int path = (num >> move) & 1;
                // 所期望的最优路径，对于符号位来说，我们希望是0，而n^n=0，所以期望的符号为就是path
                // 对于非符号位来说，因为相异为1，所以期望的位是path^1
                int best = move == 31 ? path : (path ^ 1);
                // 但是实际期望的路径可能不存在，不存在就选best^1就行了，因为best非0即1.
                best = cur.nexts[best] != null ? best : (best ^ 1);
                // 对应位异或后移动到对应位置
                res |= (path ^ best) << move;
                // 下一个节点，对应更低一位
                cur = cur.nexts[best];
            }
            return res;
        }

    }

    /**
     * 对maxXorSubarray2的改进，在那个方法里
     * 对于dp[i]需要遍历的方式找到一个最好的dp[k]，使得dp[k]^dp[i]最大，
     * 这个方法里，则是o(1)的复杂度可以找到
     * 总体的时间复杂度是o(n)
     *
     * 所有已经出现的前缀异或和，以二进制形式存储到 TrieNode中，第一个路径代表符号位，剩余路径为每一位由高到底
     * 如果已经直到0到i的异和的二进制形式，比如0101，那么从TrieNode中找到一个最好的路径代表的二进制，使得它们两异活和最大
     * 显然这个最好的路径是0010（如果存在的话），异或结果是0111，如果不存在，尽量满足高位异或结果为1.
     * @param arr
     * @return
     */
    public static int maxXorSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        NumTrie numTrie = new NumTrie();
        // 这一行，0异或任何数不变，先添加进去。不然没有路径的话，maxXor会出错
        // 如果对应某一个前缀异或和eor,它选择的是0这条路径，那么最优的就是它本身
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            max = Math.max(max, numTrie.maxXor(eor));
            numTrie.add(eor);
        }
        return max;
    }

    public static int maxXorSubarray2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        // 最大异或和来自于任意i，j，arr[i]异或到arr[j]
        // 而任意i，arr[0]异或到arr[i]是很容易求到的，我们将这些存储到dp[]中
        // 如果知道了dp[i],dp[j-1]，那么arr[j]到arr[i]的异或和可以通过dp[i]^dp[j-1]得到

        // dp[i]表示arr[0]到arr[i]的异或和，那么任意k，大于0小于i，arr[k]到arr[i]的异或和为dpr[i] ^ dp[k-1],这是异或的性质n^n=0,o^n=n
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            dp[i] = eor;
            max = Math.max(max, dp[i]);
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, dp[i] ^ dp[j-1]);
            }
        }
        return max;
    }


    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int eor = 0;
            for (int j = i; j < arr.length; j++) {
                eor ^= arr[j];
                max = Math.max(max, eor);
            }
        }
        return max;
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
        int maxSize = 30;
        int maxValue = 50;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = maxXorSubarray(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
