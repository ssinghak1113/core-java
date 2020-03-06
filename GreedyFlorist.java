package com.kkd.ds;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/greedy-florist/problem
 * @author intel
 *
 */
public class GreedyFlorist {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			
			int flowerNum = sc.nextInt();
			int peopleNum = sc.nextInt();
			
			int flowerPriceArr[] = new int[flowerNum];
			int index = 0;
			while(flowerNum != 0){
				flowerPriceArr[index] = sc.nextInt();
				flowerNum--;
				index++;
			}
			
			// sort the array
			int temp = 0;
			for(int i = 0; i<flowerPriceArr.length; i++){
				for(int j = i+1; j<flowerPriceArr.length; j++){
					if(flowerPriceArr[i]<flowerPriceArr[j]){
						temp = flowerPriceArr[i];
						flowerPriceArr[i] = flowerPriceArr[j];
						flowerPriceArr[j] = temp;
					}
				}
			}
			
			int price = 0;
			int k = 1;
			int peopleNumCount = peopleNum;
			for(int i=0; i< flowerPriceArr.length; i++){
				price = price + flowerPriceArr[i]*(k);
				peopleNumCount --;
				if(peopleNumCount == 0){
					peopleNumCount = peopleNum;
					k++;
				}
			}
			System.out.println(price);
		}
	}

}
