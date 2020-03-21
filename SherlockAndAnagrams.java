package com.kkd.ds;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 * 
 * @author Shubhangi Singh
 *
 */
public class SherlockAndAnagrams {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            int num = sc.nextInt();
            int[] opArr = new int[num];
            int i = 0;
            while (num != 0) {
                opArr[i] = calculateAnagrams(sc.next());
                i++;
                num--;
            }
            for (int j = 0; j < opArr.length; j++) {
                System.out.println(opArr[j]);
            }
        }
    }

    public static int calculateAnagrams(String ip) {
        int anagramPair = 0;
        int wordSize = 1;
        String word1 = null;
        String word2 = null;
    
        for (int i = 0; i < ip.length(); i++) {
            if (wordSize == ip.length())
                break;
            if (i + wordSize <= ip.length()) {
                word1 = ip.substring(i, i + wordSize);
                char[] wordArr1 = word1.toCharArray();
                Arrays.sort(wordArr1);
                word1= String.valueOf(wordArr1);
            }

            for (int j = i + 1; j < ip.length(); j++) {
                if (j + wordSize <= ip.length()) {
                    word2 = ip.substring(j, j + wordSize);
                    char[] wordArr2 = word2.toCharArray();
                    Arrays.sort(wordArr2);
                    word2= String.valueOf(wordArr2);
                    //System.out.println(word1 + "-" + word2);
                    
                    if (word1.equals(word2)) {
                        anagramPair++;
                        //System.out.println("equal*******************");
                    }
                }
            }

            if (i == ip.length() - 1) {
                i = -1;
                wordSize++;
            }
        }
        return anagramPair;
    }

}
