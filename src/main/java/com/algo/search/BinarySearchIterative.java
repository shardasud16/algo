package main.java.com.algo.search;

public class BinarySearchIterative {

    public static void main(String[] args) {


        int [] array = new int [] {1 ,3, 6, 9, 13, 24, 55, 66, 78, 81, 88, 99};

        System.out.println(search(array, -1));

    }


    // O(n) = O(log n) Worst case i.e. height of Tree
    public static int search(int [] array, int key){

        int low = 0;
        int high = array.length - 1;

        while(low <= high){
            int mid = (high + low)/2;

            if(key == array[mid]){
                return mid;
            }
            else if(array[mid] > key){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
