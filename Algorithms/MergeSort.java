import java.io.*;
import java.utils.*;

class mergeSort {
    public void main(String[] args) {
        int[] arr = {8,7,4,1,6};
        System.out.println(Arrays.toString(Sort(arr)));
    }

    public int[] Sort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = Sort(Arrays.copyOfRange(arr,0, mid));
        int[] right = Sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left,right);
    }
    public int[] merge(int[] first, int[] second){
        int[] max = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                max[k] = first[i];
                i++;
            }else{
                max[k] = second[j];
                j++;
            }
            k++;
        }

        while(i < first.length){
            max[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            max[k] = second[j];
            j++;
            k++;
        }
        return max;
    }
}
