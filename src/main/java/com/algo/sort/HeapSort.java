package main.java.com.algo.sort;

public class HeapSort {

    public static int [] heapSort(int [] arr){

        arr = heapify(arr, arr.length - 1);


        return arr;

    }

    public static int [] sort(int [] arr){

        int length = arr.length - 1;

      /*  for( int i = 0; i < length; i++){
            int top = arr[i];
            arr[i] = arr[length];
            arr[length] = top;
            length--;
            int firstChild = getFirstChildIndex(i);
            while(firstChild < length){

            }



            if(arr[firstChild] > arr[firstChild + 1]){

            }
        }*/

        return arr;
    }

    public static int [] heapify(int [] arr, int index){

        if(index < 0) {
            return arr;
        }

        int child = getChildIndex(index, arr.length - 1);

        if(child != -1){
            int temp = arr[index];
            if(arr[child] > arr[child + 1] && arr[index] < arr[child]){
                arr[index] = arr[child];
                arr[child] = temp;
                heapify(arr, child);
            }else if(arr[index] < arr[child + 1])
            {
                arr[index] = arr[child + 1];
                arr[child + 1] = temp;
                heapify(arr, child + 1);
            }else{
                return heapify(arr, index - 1);
            }

        }




        return arr;
    }

    private static int getChildIndex(int index, int length){

       return  (index * 2) + 1 > length ? -1 :  (index * 2) + 1;
    }



    /*public static int [] heap(int [] arr){

        for(int i = 0; i < arr.length; i++ ){

            int parent = getPatentIndex(i);

            int index = i;
            while(parent >= 0){

                if(arr[parent] < arr[index]){
                    int temp = arr[index];
                    arr[index] = arr[parent];
                    arr[parent] = temp;
                    index = parent;
                    parent = getPatentIndex(parent);

                }else{
                    break;
                }
            }
        }
        return arr;
    }*/

    private static int getPatentIndex(int i){
        if(i == 0)
            return -1;
        return i % 2 == 0 ? (i - 1)/2 : i/2;
     }

     private static int getFirstChildIndex(int i){

        if(i == 0)
            return 1;
        return i * 2;
     }





    public static void main(String[] args) {
        int [] numbers = new int [] {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        heapSort(numbers);
    }
}
