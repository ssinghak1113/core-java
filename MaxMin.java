package com.kkd.ds;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-children/problem?h_r=next-
 * challenge&h_v=legacy
 * 
 * @author intel
 *
 */
public class MaxMin {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int arrLt = sc.nextInt();
			Integer[] arr = new Integer[arrLt];
			int subArrLt = sc.nextInt();
			int index = 0;
			while (arrLt != 0) {
				arr[index] = sc.nextInt();
				arrLt--;
				index++;
			}

			// sort the array
			Arrays.sort(arr);
			int min = Integer.MAX_VALUE;
			int unfairness = min;
			for (int i = 0; i < arr.length; i++) {
				if (i + subArrLt - 1 >= arr.length) {
					break;
				}
				min = arr[i + subArrLt - 1] - arr[i];
				if (unfairness > min) {
					unfairness = min;
				}

			}
			System.out.println(unfairness);
		}
	}

}
