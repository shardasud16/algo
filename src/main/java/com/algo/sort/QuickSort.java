package main.java.com.algo.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int [] numbers = new int [] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        quickSort(numbers);

        Arrays.stream(numbers).forEach(System.out::println);

        System.out.println("-----New Array ---");
        int [] numbers2 = new int [] {-3, 44, 999, 2, 1, -5, 2, 87, 41, 4, 55};
        quickSort(numbers2);

        Arrays.stream(numbers2).forEach(System.out::println);
    }

    /**
     * Basic implementation of QuickSort in memory.
     * No external memory used. Pivot value is selected
     * as last value
     * @param array
     * @return
     */

    public static int [] quickSort(int [] array){

        return sort(array, 0, array.length -1);
    }

    private static int [] sort(int [] arr, int start, int end){

        int pivot = end;
        int leftIndex = start;

        while(leftIndex < pivot){

            if(arr[leftIndex] > arr[pivot]){

                int tempValue = arr[leftIndex];
                arr[leftIndex] = arr[pivot - 1];
                arr[pivot -1] = arr[pivot];
                arr[pivot] = tempValue;
                pivot--;

            }else{
                leftIndex++;
            }
        }

        if(start < pivot-1)
            sort(arr, start, pivot -1 );
        if(end > pivot + 1)
            sort(arr, pivot + 1, end);

        return arr;
    }


}
