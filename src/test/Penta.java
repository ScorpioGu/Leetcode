package test;

import java.util.Random;

public class Penta {
	static int[] primes = {964, 524, 356, 268, 212, 172, 148, 124, 116, 104};
	static int a = 116, b = 268;
	static int w = 4;
	static int circles = 5;
	static boolean bestGot = false;
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
		for (int a = 0; a<primes.length; a++) {
			int[] nums = getArray(primes[a], b, w);
			double bestAvg = getBestAvg(primes[a], w);
			int len = nums.length;
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < nums.length; j++) {
					for (int k = 0; k < nums.length; k++) {
						for (int l = 0; l < nums.length; l++) {
							calu(nums, i, j, k, l, bestAvg);
						}
					}
				}
				if (bestGot) {
					System.out.println(primes[a] + " true");
					break;
				}
			}
			System.out.println();
			System.out.println("minMax " + minMax);
			System.out.println("avgmax " + avgmax / (len * len - 1) + " avgavg" + avgavg / (len * len - 1));
		}
	}

	private static void calu(int[] nums, int i, int j, int m, int l, double bestAvg) {
		int max = Integer.MIN_VALUE;
		double avg = 0.0;
		int len = nums.length;
		int[] c1 = new int[len];
		int[] c2 = new int[len];
		int[] c3 = new int[len];
		int[] c4 = new int[len];
		for (int k = 0; k < len; k++) {
			c1[k] = nums[(k + i)%len];
			c2[k] = nums[(k + j)%len];
			c3[k] = nums[(k + m)%len];
			c4[k] = nums[(k + l)%len];
			int min = Math.min(Math.min(nums[k], c3[k]), Math.min(Math.min(c1[k], c2[k]), c4[k]));
			max = Math.max(max, min);
			avg += min;
		}
		minMax = Math.min(minMax, max);
		//System.out.println(i + " " + j + "   max: " + max + " avg: " + avg/len);
		if (bestAvg == (avg/len)) {
			bestGot = true;
		}
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

	public static double getBestAvg(int a, int w) {
		a /= w;
		int remain = a % circles;
		int sum = circles * (a/circles) * ((a/circles) + 1)/2 - (circles - remain) * (a/circles);
		System.out.println((double)sum/a);
		return (double)sum/a;
	}
}
