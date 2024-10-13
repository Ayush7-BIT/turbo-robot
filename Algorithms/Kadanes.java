
public class Kadanes {
    public static void kadanesAlgo(int [] arr){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum=Math.max(maxSum, currSum);
        }
        System.out.println("Maximum sum of sub array is "+maxSum);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        kadanesAlgo(arr);
    }
}
