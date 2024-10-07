//Add code for Bubble Sort
import java.util.Scanner;
class bubbleDemo
{
    public static void main(String args[])
    {
    int n,i,j,temp;
    int a[] = new int [20];
    Scanner s = new Scanner(System.in);
    System.out.println("Enter total number of elements : ");
    n = s.nextInt();
    System.out.println("Enter elements in sorted order : ");
    for(i=0;i<n;i++)
    a[i] = s.nextInt();
    for(i=0;i<n;i++)
    {
        for(j=0;j<n-1;j++)
        {
            if(a[j]>a[j+1])
            {
                temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
        }
    }
    System.out.println("The sorted elements are : ");
    for(i=0;i<n;i++)
    System.out.println("/t"+a[i]);
    }
}
