package main.java.com.algo.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int [] numbers = new int [] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int [] numbers1 = mergeSort(numbers);

        Arrays.stream(numbers1).forEach(System.out::println);
    }

    public static int [] mergeSort(int [] array){
        return merge(Arrays.copyOfRange(array, 0, ((array.length +1)/2)) , Arrays.copyOfRange(array, ((array.length +1)/2), array.length));
    }

    public static int [] merge(int [] left, int [] right){


        if(left.length > 1)
            left = merge(Arrays.copyOfRange(left, 0, (left.length + 1)/2) , Arrays.copyOfRange(left, (left.length +1)/2, left.length))  ;
        if(right.length > 1)
            right = merge(Arrays.copyOfRange(right, 0, (right.length +1)/2) , Arrays.copyOfRange(right, (right.length + 1)/2, right.length));

        int leftLength = left.length;
        int rightLength = right.length;

        int i = 0; int j = 0;
        int [] combinedSortedArray = new int [leftLength + rightLength];
        while( i < leftLength || j < rightLength){

            if(i < leftLength && j < rightLength  && left[i] < right[j]){
                combinedSortedArray[i+j] = left[i];
                i++;
            }else if (j < rightLength){
                combinedSortedArray[i+j] = right[j];
                j++;
            }else if( i < leftLength){
                combinedSortedArray[i+j] = left[i];
                i++;
            }
        }

        return combinedSortedArray;

    }

}
