import java.util.ArrayList;
import java.util.Collections;

/**
 * BucketSort class implements the bucket sort algorithm.
 * 
 * Bucket sort is a sorting algorithm that distributes elements into several buckets.
 * Each bucket is then sorted individually, either using a different sorting algorithm
 * or by recursively applying the bucket sorting algorithm.
 */
public class BucketSort {

    /**
     * Prints the contents of each bucket.
     * 
     * @param buckets Array of buckets to be printed.
     */
    private static void printBuckets(ArrayList<Integer>[] buckets){
        for (int i=0; i<buckets.length; i++){
            System.out.println("Bucket no. : "+(i+1));
            for (int j=0; j<buckets[i].size(); j++){
                System.out.print(buckets[i].get(j)+"  ");
            }
            System.out.println();
        }
    }

    /**
     * Sorts the given array using bucket sort algorithm.
     * 
     * @param arr Array to be sorted.
     */
    public static void bucketSort(int [] arr){
        // Define number of buckets
        // The number of buckets is determined by taking the square root of the array length
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));

        // Calculate the current max value in the given array
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(max_value < arr[i]){
                max_value = arr[i];                
            }
        }

        // Create Buckets, and initialize them empty for now
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new ArrayList<Integer>();
        }

        // Put the values into the buckets
        for(int value: arr){
            // The bucket number is the index of the bucket to put the values
            // It is calculated by multiplying the value by the number of buckets, 
            // dividing by the max value, and then taking the ceiling of the result
            int bucketNumber = (int) Math.ceil(((float) value * numberOfBuckets)/ (float) max_value);
            buckets[bucketNumber-1].add(value);
        }

        System.out.println("Printing Buckets before sorting :");
        printBuckets(buckets);

        // Sort each bucket
        for(ArrayList <Integer> buck: buckets){
            Collections.sort(buck);
        }

        System.out.println("Printing Buckets after sorting :");
        printBuckets(buckets);

        // Merge the buckets back into the original array
        int index = 0;
        for(ArrayList<Integer> buck : buckets){
            for(int value: buck){
                arr[index] = value;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        // This is for testing purposes
        int[] arr = {
            25, 48, 73, 150, 92, 33, 67, 120, 180, 55,
            140, 200, 85, 60, 110, 45, 170, 30, 190, 75,
            135, 50, 160, 100, 40, 130, 95, 70, 155, 20
        };

        // Making Method calls
        bucketSort(arr);
        System.out.println("\n\n");

        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]+" -> ");
        }
    }
}
