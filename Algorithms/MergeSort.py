def merge_sort(arr):
    if len(arr) > 1:
        # Finding the middle of the array
        mid = len(arr) // 2

        # Dividing the array elements into 2 halves
        left_half = arr[:mid]
        right_half = arr[mid:]

        # Recursively sort both halves
        merge_sort(left_half)
        merge_sort(right_half)

        # Initial indexes for left, right and merged arrays
        i = j = k = 0

        # Merge the sorted halves
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

        # Checking for any remaining elements
        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

        while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1

# Function to print the array
def print_array(arr):
    for i in arr:
        print(i, end=" ")
    print()

# Test the merge sort
if __name__ == "__main__":
    arr = [12, 11, 13, 5, 6, 7]
    print("Original Array:")
    print_array(arr)

    merge_sort(arr)

    print("Sorted Array:")
    print_array(arr)
