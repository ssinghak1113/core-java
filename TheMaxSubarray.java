package com.kkd.ds.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maxsubarray/problem
 *
 * Kadane's algorithm for max contiguous sum
 */
public class TheMaxSubarray {

	public static void main(String... args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt(); // test cases
			while (t != 0) {
				int maxSubArr = 0; // contiguous
				int maxSubSeq = 0;
				int nCount = sc.nextInt();
				int highestNegative = 0;

				int maxSoFar = 0;
				int maxEndingHere = 0;
				boolean allNegative = true;

				while (nCount != 0) {
					int n = sc.nextInt();
					if (n > 0) {
						maxSubSeq += n;
						allNegative = false;
					}

					if (allNegative) {
						// keep a track of highest negative number here in case
						// of all element being negative
						if(highestNegative == 0){
							highestNegative = n;
						}
						if(highestNegative < n){
							highestNegative = n;
						}
					}

					maxEndingHere += n;
					if (maxSoFar < maxEndingHere) {
						maxSoFar = maxEndingHere;
					}
					if (maxEndingHere < 0) {
						maxEndingHere = 0;
					}
					nCount--;
				}
				
				if(allNegative){
					maxSubSeq = maxSubArr = highestNegative;
				}else{
					maxSubArr = maxSoFar;
				}
				System.out.println(maxSubArr + " " + maxSubSeq);
				t--;
			}
		}
	}
}
