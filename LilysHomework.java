package com.kkd.hackerrank;

import java.util.*;

public class LilysHomework {

    public static void main(String... args) {
        try (Scanner sc = new Scanner(System.in)) {
            int nArr = sc.nextInt();
            int arr[] = new int[nArr];
            for (int i = 0; i < nArr; i++) {
                int num = sc.nextInt();
                arr[i] = num;
            }

            int[] arrAsc = Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder()).mapToInt(i -> i).toArray();
            int[] arrDesc = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();

            int swapAsc = compareArrays(Arrays.copyOf(arr, nArr), arrAsc, true);
            int swapDesc = compareArrays(arr, arrDesc, false);

            if (swapAsc < swapDesc)
                System.out.println(swapAsc);
            else
                System.out.println(swapDesc);

        }
    }

    private static int compareArrays(int[] arr, int[] arrSorted, boolean asc) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrSorted.length; i++) {
            map.put(arrSorted[i], i);
        }
        int swap = 0;
        for (int i = 0; i < arr.length; i++) {
            int sortedIdx = map.get(arr[i]);
            if (i != sortedIdx) {
                int temp = arr[i];
                arr[i] = arr[sortedIdx];
                arr[sortedIdx] = temp;
                swap++;
            }
        }
        if (!isSorted(arr, asc)) {
            swap = swap + compareArrays(arr, arrSorted, asc);
        }
        return swap;
    }

    private static boolean isSorted(int[] arr, boolean acsSorted) {
        for (int i = 0; i < arr.length-1; i++) {
            if (acsSorted && arr[i] > arr[i + 1]) {
                return false;
            } else if (!acsSorted && arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
