// Java implementation of iterative Binary Search

package DSA_JAVA;

public class binarySearchAlgo {
    public static void main(String[]args){
    int[]arr={23,45,67,89,94};
    int target=67;
    int ans=search(arr,target);
    System.out.print("index:"+ans);
}
static int search(int[]arr,int target){
       int start=0;
       int end=arr.length-1;
       while(start<=end){
           int mid=start+(end-start)/2;
       if(target<arr[mid]){
           end=mid-1;
       }
       else if(target>arr[mid]){
           start=mid+1;
       }
       else{
           return mid;
       }

       }
        return -1;
}
}
