public class CountSort {


    public static void countSort(int arr[]){
        int largest= Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest= Math.max(largest, arr[i]);
        }

        int count[]= new int[largest+1];
        
        // here we calaculate the frequency
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Sorting
        int j=0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j]= i;
                j++;
                count[i]--;
            }
        }

    }
    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    public static void main(String[] args) {
        int arr[]={5,3,2,4,1};
        countSort(arr);
        print(arr);
    }
    
}
