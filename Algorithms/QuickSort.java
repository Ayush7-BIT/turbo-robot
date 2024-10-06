public class QuickSort {

    public static void quickSort(int arr[], int si, int ei){

        //base condition
        if (si >= ei) {
            return;
        }

        int pviot= partition(arr, si, ei);
        quickSort(arr, si, pviot-1);
        quickSort(arr, pviot+1, ei);

    }
    public static int partition(int arr[], int si, int ei){

        int pviot= arr[ei];
        int j=si-1;

        for (int i = si; i < ei; i++) {
            if ( arr[i] <= pviot) {
                j++;

                //swap 
                int temp=arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
            }
        }
        j++;
        int temp= pviot;
        arr[ei]= arr[j];
        arr[j]=temp;
        return j;
        
        
    }
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[]={4,3,6,2,1,5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
    
}
