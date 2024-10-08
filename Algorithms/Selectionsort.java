import java.util.Scanner;   
public class SelectionSort  
{  
   public static void main(String args[])  
   {  
       int size, i, j, temp;  
       int arr[] = new int[50];  
       Scanner scan = new Scanner(System.in);  
       System.out.print("Enter Array Size : ");  
       size = scan.nextInt();  
       //Taking input from the user
       System.out.print("Enter Array Elements : ");  
       for(i=0; i<size; i++)  
       {  
           arr[i] = scan.nextInt();  
       } 
       System.out.print("Sorting Array using Selection Sort Technique \n");  
       //selction sort algorithm
       for(i=0; i<size; i++)  
       {  
           for(j=i+1; j<size; j++)  
           {  
               if(arr[i] > arr[j])  
               {  
                   temp = arr[i];  
                   arr[i] = arr[j];  
                   arr[j] = temp;  
               }  
           }  
       }  
     //printing the sorted array
       System.out.print("Array after Sorting is :\n");  
       for(i=0; i<size; i++)  
       {  
           System.out.print(arr[i]+ "  ");  
       }  
   }  
} 
  
