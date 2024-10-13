import java.util.*;
/* --------------Insertion Sort--------------
 * Time Complexity- O(n^2)
 * How it Works?
 * Here unsorted array is virtually splited into sorted part and unsorted part.
 * Values from unsorted part are picked and placed at correct position in sorted part.
 *   arr = <--Sorted--><-------------unsorted------------->
 *                 ↑←←←←←←←←←↓
 * This process is done continuesly until the length of unsorted array becomes 0. means, all the elements\
 * in array are now sorted.
 * We start with second element of the array as first element in the array is assumed to be sorted.
 * Compare second element with the first element and check if the second element is smaller then swap them.
 * Move to the third element and compare it with the second element, then the first element and swap as necessary to put it in the correct position among the first three elements.
 * Continue this process, comparing each element with the ones before it and swapping as needed to place it in the correct position among the sorted elements.
 * Repeat until the entire array is sorted.
 * 
 * Real-life Use:
 * Insertion sort is like sorting playing cards in your hands.
 * You split the cards into two groups: the sorted cards and the unsorted cards.
 * Then, you pick a card from the unsorted group and put it in the right place in the sorted group.
 * 
 * Why it is called Insertion Sort?
 * Bcz, each time you pick an element from unsorted array and insert them to their correct position in sorted array
 * 
*/

public class InsertionSort {

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int j = i - 1; // start from one element earlier
            int temp = arr[i]; // store elemet to be compared so it not gets lost

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Now place the temp element at correct position
            arr[j + 1] = temp;
        }

        // sorted array
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        System.out.print("Enter the unsorted array: ");
        int[] userArr = new int[n];

        for (int i = 0; i < n; i++) {
            userArr[i] = sc.nextInt();
        }
        sc.close();

        userArr = insertionSort(userArr);

        System.out.println("Sorted Array by Insertion sort: " + Arrays.toString(userArr));

    }
}
