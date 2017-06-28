package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UnqSubarr {

	private static int T, N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		String[] arr = null;
		int intArr[];
		int n = 2 * T;
		List<String> list = new ArrayList<>();
		while (n != 0) {
			N = Integer.parseInt(br.readLine().trim());
			intArr = new int[N];
			arr = br.readLine().trim().split(" ");
			Arrays.asList(arr).stream().mapToInt(e -> Integer.parseInt(e));
			n = n - 2;
		}
	}

}
