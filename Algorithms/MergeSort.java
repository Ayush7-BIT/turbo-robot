public class MergeSort {


    public static void mergeSort(int arr[], int si, int ei){
        //Base case
        if (si >= ei) {
            return;
        }
        //mid
        int mid= si + (ei-si)/2;

        mergeSort(arr, si, mid); // Left
        mergeSort(arr, mid+1, ei); // right
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[], int si, int mid, int ei){

        int temp[]= new int[ei-si+1];

        int i=si; // left
        int j= mid+1; // right
        int k=0; // temp iterator

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k]=arr[i];
                i++;
                k++;
            }else{
                temp[k]= arr[j];
                j++;
                k++;
            }
        }
        //left part
        while (i <= mid) {
            temp[k++]=arr[i++];
        }

        // Right part
        while (j <= ei) {
            temp[k++]=arr[j++];

        }
        // to copty temp array in original array
        for(k=0, i=si; k < temp.length; k++, i++){
            arr[i]= temp[k];
        }
    }


    public static void printArr(int arr[]){

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    public static void main(String[] args) {
        
        int arr[]={3,6,2,4,1,5};
        mergeSort(arr, 0, arr.length-1);
        
        printArr(arr);
    }
    
}
