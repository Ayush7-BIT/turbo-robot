public class SelectionSort {

    public static void selectionSort(int arr[]){

        for (int i = 0; i < arr.length-1; i++) {
            int minipos= i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minipos] > arr[j]) {
                    minipos = j;
                }
            }

            int temp= arr[minipos];
            arr[minipos]= arr[i];
            arr[i]= temp;

        }

    }
    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        }

    public static void main(String[] args) {
        
        int arr[]={3,5,6,2,1};

        selectionSort(arr);
        print(arr);
    }
    
}
