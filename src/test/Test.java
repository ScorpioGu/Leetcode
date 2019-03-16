package test;

import java.util.*;

public class Test {
	static int[] primes = {964, 524, 356, 268, 212, 172, 148, 124, 116, 104};
	static int a = 56, b = 268;
	static int w = 4;
	/**
	 * 平均延迟的平均值
	 */
	static double avgavg = 0.0;
	/**
	 * 最大延迟的平均值
	 */
	static double avgmax = 0.0;
	/**
	 * 最大延迟的最小值
	 */
	private static Random rand = new Random();

	static double minMax = Integer.MAX_VALUE;
	public static void main(String[] args) {

		int[] nums = getArray(a, b, w);
		//shuffle(nums, rand);

		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		//return;
/*		int len = nums.length;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				calu(nums, i, j);
			}
		}
		System.out.println();
		System.out.println("minMax " + minMax);
		System.out.println("avgmax " + avgmax/(len * len - 1) + " avgavg" + avgavg/(len * len -1));
		getBestAvg(a, w);*/
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
		minMax = Math.min(minMax, max);
		System.out.println(i + " " + j + "   max: " + max + " avg: " + avg/len);
		if (i == 0 && j == 0) {
			return;
		}

		avgavg += (avg/len);
		avgmax += max;

	}

	private static int[] getArray(int a, int b, int w) {
		a = a/w;
		b = b/w;
		int k = 0;
		for (int i = 0; i < a; i++) {
			if ((b * i) % a == a - 1) {
				k = i;
			}
		}
		int[] res = new int[a];
		res[1] = k;
		for (int i = 2; i < a; i++) {
			res[i] = (i * k) % a;
		}
		return res;
	}

	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static  void  shuffle(int[] array, Random random){

		for(int i = array.length; i >= 1; i--){

			swap(array,i-1,random.nextInt(i));
		}
	}

	public static void getBestAvg(int a, int w) {
		a /= w;
		int remain = a % 3;
		int sum = 3 * (a/3) * ((a/3) + 1)/2 - (3 - remain) * (a/3);
		System.out.println((double)sum/a);
	}


}
