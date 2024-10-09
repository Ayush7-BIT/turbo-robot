public class BubbleSort {
    public static void sort(int[] elements) {
      for (int max = elements.length - 1; max > 0; max--) {
        boolean swapped = false;
        for (int i = 0; i < max; i++) {
          int left = elements[i];
          int right = elements[i + 1];
          if (left > right) {
            elements[i + 1] = left;
            elements[i] = right;
            swapped = true;
          }
        }
        if (!swapped) break;
      }
    }
  
  
    // Prints the array 
    public static void printArray(int[] elements) {
      for (int element : elements) {
          System.out.print(element + " ");
      }
      System.out.println();
  }
  
    // main method to test above 
    public static void main(String[] args) {
      int[] elements = {64, 34, 25, 12, 22, 11, 90};  // Sample array to sort

      System.out.println("Array before sorting:");
      printArray(elements);

      // Calling the bubble sort function
      BubbleSort.sort(elements);

      System.out.println("Array after sorting:");
      printArray(elements);
  }
}
