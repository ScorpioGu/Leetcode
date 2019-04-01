package test;

import java.util.Random;

public class Penta {
	static int[] primes = {16, 20, 24, 28, 32, 36, 40, 48, 52};
	static int b = 28;
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
			System.out.println();
			System.out.println("a:" + primes[a]/w);
			int[] nums = getArray(primes[a], b, w);
			double bestAvg = getBestAvg(primes[a], w);
			int len = nums.length;
			for (int i = 0; i < nums.length; i++) {
				for (int j = i; j < nums.length; j++) {
					for (int k = j; k < nums.length; k++) {
						for (int l = k; l < nums.length; l++) {
							calu(nums, i, j, k, l, bestAvg);
						}
					}
				}
			}
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
		if (bestAvg == (avg/len)) {
			System.out.println(i + " " + j + " " + m + " " + l);
		}
		if (i == 0 && j == 0 && m == 0 && l == 0) {
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
		System.out.println("k:" + k);
		for (int i = 2; i < a; i++) {
			res[i] = (i * k) % a;
		}
		for (int i = 1; i < res.length; i++) {
			if (res[i] == 1) {
				System.out.println("d:" + i);
			}
		}
		return res;
	}

	public static double getBestAvg(int a, int w) {
		a /= w;
		int remain = a % circles;
		int sum = circles * (a/circles) * ((a/circles) + 1)/2 - (circles - remain) * (a/circles);
		return (double)sum/a;
	}
}
