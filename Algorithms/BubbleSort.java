import java.util.*;
import java.io.*;

class BubbleSort {
    public static void bubbleSort(int[] numbers) {
        int n = numbers.length;
        boolean exchange;

        
        for (int i = 0; i < n - 1; i++) {
            exchange = false;
          
            for (int j = 0; j < n - i - 1; j++) {
                // exchange if the element found is larger than the next element
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    exchange = true;
                }
            }

            // If two elements are not exchanged by inner loop, then break the loop
            if (!exchange){
              break;
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] numbers) {
        for (int value : numbers) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test the bubble sort
    public static void main(String[] args) {
        int[] numbers = {98, 15, 36, 96, 56, 26, 198};
        
        System.out.println("Original array:");
        printArray(numbers);

        bubbleSort(numbers);
        
        System.out.println("BubbleSorted array:");
        printArray(numbers);
    }
}
