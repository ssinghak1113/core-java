package com.kkd.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SudokuInput {

	public static void main(String[] args) {

		boolean isRightInput = true;

		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();

			int[][] ip = new int[9][9];
			Map<Integer, List<Integer>> mapRowVal = new HashMap<>();
			Map<Integer, List<Integer>> mapColVal = new HashMap<>();

			while (n != 0) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				int val = sc.nextInt();

				ip[row - 1][col - 1] = val;

				if (mapRowVal.containsKey(row)) {
					if (mapRowVal.get(row).contains(val)) {
						System.out.println("WRONG INPUT");
						isRightInput = false;
						break;
					}
					
					mapRowVal.get(row).add(val);
				} else {
					List<Integer> listVal = new ArrayList<>();
					listVal.add(val);
					mapRowVal.put(row, listVal);
				}

				if (mapColVal.containsKey(col)) {
					if (mapColVal.get(col).contains(val)) {
						System.out.println("WRONG INPUT");
						isRightInput = false;
						break;
					}
					
					mapColVal.get(col).add(val);
				} else {
					List<Integer> listVal = new ArrayList<>();
					listVal.add(val);
					mapColVal.put(col, listVal);
				}

				n--;
			}

			// check for duplicate in sub grids

			if (isRightInput) {
				n = 1;
				Set<Integer> subGridElem = new HashSet<>();
				int rl = 1;
				int ru = 3;
				isRightInput = testSubgrids(isRightInput, ip, subGridElem, rl, ru);

				if(isRightInput){
					rl = 4;
					ru = 6;
					isRightInput = testSubgrids(isRightInput, ip, subGridElem, rl, ru);
					
					if(isRightInput){
						rl = 7;
						ru = 9;
						isRightInput = testSubgrids(isRightInput, ip, subGridElem, rl, ru);
					}
				}
			}

			if (isRightInput) {
				System.out.println("OK");
			}
		}
	}

	private static boolean testSubgrids(boolean isRightInput, int[][] ip, Set<Integer> subGridElem, int rl, int ru) {
		int cl = 1;
		int cu = 3;
		int r = rl;
		int c = cl;
		int counter = 0, subgridCount = 0;
		for (; r <= ru;) {
			for (; c <= cu; c++) {
				if (ip[r - 1][c - 1] == 0) {
					continue;
				}
				if (!subGridElem.add(ip[r - 1][c - 1])) {
					System.out.println("WRONG INPUT");
					isRightInput = false;
					break;
				}
			}

			counter++;
			if (counter == 3) {
				counter = 0;
				subgridCount++;
				subGridElem.clear();
				if (subgridCount == 3) {
					break;
				}
				r = rl;
				cl = cl + 3;
				cu = cu + 3;
				c = cl;
				continue;
			} else {
				c = cl;
				r++;
			}
		}
		return isRightInput;
	}
}
