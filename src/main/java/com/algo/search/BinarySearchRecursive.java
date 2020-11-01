package main.java.com.algo.search;

public class BinarySearchRecursive {

    public static void main(String[] args) {
        int [] array = new int [] {1 ,3, 6, 9, 13, 24, 55, 66, 78, 81, 88, 99};

        System.out.println(search(array, 0, array.length - 1, 99));
    }

    public static int search(int [] array, int low, int high, int key){

        if(low > high){
            return -1;
        }

        int mid = (low + high)/2;

        if(key == array[mid]) {
            return mid;
        }
        else{
            return key < array[mid] ? search(array, low, mid -1, key) : search(array, mid + 1, high, key);
        }

    }

}
