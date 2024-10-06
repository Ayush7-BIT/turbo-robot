public class BubbleSort {

    public static void bubbleSort(int arr[]){
        int swap;
        for (int i = 0; i < arr.length-1; i++) {
            swap=0;
            for (int j = 0; j < arr.length-1-i; j++) {
                
                if (arr[j] > arr[j+1]) {
                    
                    int temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;

                    swap++;
                }
            }    
        }
        
        

    }
    public static void print(int arr[]){
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]+ " ");
    }
    }
    
    public static void main(String[] args) {
        int arr[]={1,2,3,6,5};
        bubbleSort(arr);
        print(arr);
    }
    
}
