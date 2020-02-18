package com.kkd.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class SparseArrays {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			int n = sc.nextInt();
			String strArr[] = new String[n];
			Map<String, Integer> countMap = new HashMap<>();
			while (n > 0) {
				String str = sc.next();
				if (countMap.containsKey(str)) {
					countMap.put(str, countMap.get(str) + 1);
				} else {
					countMap.put(str, 1);
				}
				strArr[n - 1] = str;
				n--;
			}
			int q = sc.nextInt();
			String qryArr[] = new String[q];
			int i = 0;
			while (q > 0) {
				qryArr[i] = sc.next();
				q--;
				i++;
			}
			Stream.of(qryArr).forEach(qry -> {
				if(countMap.containsKey(qry)){
					System.out.println(countMap.get(qry));	
				}else{
					System.out.println(0);
				}
			});
		}

	}
}
