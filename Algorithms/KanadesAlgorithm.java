import java.util.Scanner;

public class KanadesAlgorithm{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("no of elements?");
        int a=sc.nextInt();
        int[] arr=new int[a];
        for (int i = 0; i < a; i++) {
        arr[i]=sc.nextInt();  
        }
        check(arr);
        sc.close();
    }
    static void check(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        int currsum=0;
        for(int i=0;i<arr.length;i++){
            currsum+=arr[i];
            maxSum=Math.max(maxSum,currsum);
            if(currsum<0){
                currsum=0;
            }
        }
        System.out.println(maxSum);
    }
}
