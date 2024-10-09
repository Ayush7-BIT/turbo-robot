import java.util.*;
public class Insertionsort{
  public static void main(String[] args){
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter the length of arr");
     int n=sc.nextInt();
     int[]arr=new int[n]; 
    for(int i=0;i<n;i++){
       System.out.println("Enter the element at: "+i);
       arr[i]=sc.nextInt();
     }
    System.out.println("Array without sorting"+Arrays.toString(arr));
    insertion(arr);
    System.out.println("Arrays after sorting"+Arrays.toString(arr));
  }
  public static void insertion(int[]arr){
    for(int i=1;i<arr.length;i++){
       int x=arr[i];
       int j=i-1;
       while(j>=0 &&arr[j]>x){
          arr[j+1]=arr[j];
          j--;
       }
       arr[j+1]=x;
    }
  
  }
}
