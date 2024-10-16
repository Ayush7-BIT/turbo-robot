import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,25,2,5,98,76,3};
        mergesort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergesort(int[] arr, int s, int e) {
        if(e-s!=1) {
            int mid = (s+e)/2;
            mergesort(arr,0,mid);
            mergesort(arr,mid,e);
            
            merge(arr,s,mid,e);
        }
    }
    private static void merge(int[] arr, int s, int mid, int e) {
            int i = s;
            int j = mid;
            int k =  0;
            int[] mix = new int[e-s];
            while(i<mid && j<e){
                if(arr[i]<arr[j]){
                    mix[k] = arr[i];
                    i++;
                }
                else{
                    mix[k] = arr[j];
                    j++;
                }
                k++;
            }
            while(i<mid){
                mix[k] = arr[i];
                i++;
                k++;
            }
            while(j<e){
                mix[k] = arr[j];
                j++;
                k++;
            }
            for(int l=0;l<mix.length;l++){
                arr[s+l] = mix[l];
            }
    }

}
