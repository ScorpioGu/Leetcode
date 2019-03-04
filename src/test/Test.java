package test;
public class Test {

	int a, b;
	int w = 4;
	static double avgavg = 0.0;
	static double avgmax = 0.0;
	public static void main(String[] args) {
		//int[] nums = new int[]{0, 3, 6, 1, 4, 7, 2, 5};
		int[] nums = {0, 4, 1, 5, 2, 6, 3};
		int len = nums.length;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				calu(nums, i, j);
			}
		}
		System.out.println();
		System.out.println("total " + avgmax/(len * len - 1) + " " + avgavg/(len * len -1));

	}

	private static void calu(int[] nums, int i, int j) {
		int max = Integer.MIN_VALUE;
		double avg = 0.0;
		int len = nums.length;
		int[] c1 = new int[len];
		int[] c2 = new int[len];
		for (int k = 0; k < len; k++) {
			c1[k] = nums[(k + i)%len];
			c2[k] = nums[(k + j)%len];
			int min = Math.min(nums[k], Math.min(c1[k], c2[k]));
			max = Math.max(max, min);
			avg += min;
		}
		System.out.println(i + " " + j + " " + max + " " + avg/len);
		if (i == 0 && j == 0) {
			return;
		}

		avgavg += (avg/len);
		avgmax += max;

	}

}
