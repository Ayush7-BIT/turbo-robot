// To find Maximum Subarray Sum
public class KadanesAlgorithm {
    public static int maxSumArray(int arr[]){
        int s=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            s=s+arr[i];
            if(s>max){
                max=s;
            }
            if(s<0){
                s=0;
            }
        }
        return max;
    }
    public static void main(String args[]){
      int arr[]={-2, 1, -3, 4, -1, 2, 1, -5, 4};
      int ans=maxSumArray(arr);
      System.out.println("Maximum Subarray Sum :"+ans);
    }
}
