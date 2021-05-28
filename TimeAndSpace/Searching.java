import java.util.Arrays;

public class Searching {
    //Linear Search
    public static int linearSearch(int[] arr, int data){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == data){
                return i;
            }
        }

        return -1;
    }

    //Binary serach using recursion approach
    public static boolean binarySearchRec(int[] arr, int lo, int hi, int data) {
        if(lo > hi){
            System.out.println("Binary search: " + data + " not found in list");
            return false;
        }

        int mid = (lo+hi)/2;
        if(arr[mid] == data){
            System.out.println("Binary search: " + data + " found at index " + mid);
            return true;
        }else if(arr[mid] < data){
            return binarySearchRec(arr, mid+1, hi, data);
        }else{
            return binarySearchRec(arr, lo, mid-1, data);
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 5, 6, 7, 8, 9, 10, 15, 16};
        int data = 5;

        System.out.println(Arrays.toString(arr));

        /*//Linear search
        int index = linearSearch(arr, data);
        System.out.println("Linear search: " + data + " found at index " + index);*/

        //Binary search
        binarySearchRec(arr, 0, arr.length-1, data);
    }
}