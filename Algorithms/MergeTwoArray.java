import java.util.*;
public class MergeTwoArray {


    public static void main(String[] args) {
        int array1[]={1,2,3,4};
        int array2[]={5,2,7,8};


        int length1=array1.length;
        int length2=array2.length;

        int mergearray[]= new int[length1+ length2];

        for (int i = 0; i < length1; i++) {
            mergearray[i]=array1[i];
        }
        for (int i = 0; i < length2; i++) {
            mergearray[length1+i]= array2[i];

        }
        System.out.println("MeargeArray is: " + Arrays.toString(mergearray));
    }
    
}
