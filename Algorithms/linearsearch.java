public class LinearSearch {
    public static void main(String[] args) {
        // Array of numbers to search from
        int[] numbers = {12, 45, 67, 23, 89, 14, 56};

        // The target number we are searching for
        int target = 23;

        // Call the findNumber function and store the result (index of the target)
        int result = findNumber(numbers, target);

        // Check if the number was found and display the result
        if (result != -1) {
            System.out.println("Number " + target + " found at index: " + result);
        } else {
            System.out.println("Number " + target + " not found in the list.");
        }
    }

    // Function to perform a linear search in the array
    public static int findNumber(int[] list, int valueToFind) {
        // Loop through the array to search for the value
        for (int index = 0; index < list.length; index++) {
            // Check if the current element matches the value we're looking for
            if (list[index] == valueToFind) {
                return index; // Return the index if found
            }
        }
        return -1; // Return -1 if the value is not found in the array
    }
}
