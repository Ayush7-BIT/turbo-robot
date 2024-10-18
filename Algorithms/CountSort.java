import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr ={-3,2,1,0,4,5,7};
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int[] freq = new int[max-min+1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]-min]++;
        }
        int k=0;
        for (int i = min; i <=max ; i++) {
            for (int j = 1; j <=freq[i-min] ; j++) {
                arr[k] = i;
                k++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}