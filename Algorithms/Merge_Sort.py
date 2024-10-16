# We will use typing library which specify that certain inputs or outputs are expected to be lists
from typing import List

# Now we creat main fuction to carry out the merge sort algorithm
def merge_sort(arr: List[int]) -> List[int]:
    """
    Perform Merge Sort on the input list and return the sorted list.
    
    Example:
    >>> merge_sort([47, 17, 33, 2, 55, 5, 99])
    [2, 5, 17, 33, 47, 55, 99]
    
    :param arr: List of integers to be sorted.
    :return: A new list containing the sorted elements.
    """
    if len(arr) <= 1: #Check the size of the array that is more then 1 or not
        return arr

    # Divide the array in 2 parts
    mid = len(arr) // 2
    #Sort the array
    left_half = merge_sort(arr[:mid])
    right_half = merge_sort(arr[mid:])

    # Merge the sorted parts of array
    return merge(left_half, right_half)

# Function to merge both sorted array into one
def merge(left: List[int], right: List[int]) -> List[int]:
    """
    :param left: First sorted list.
    :param right: Second sorted list.
    :return: Merged sorted list.
    """
    sorted_list = [] #to store the array
    i = j = 0 #Set the position to 0 (start of the array)

    # Compare each element one by one and merge
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            sorted_list.append(left[i]) #store the element into arrray
            i += 1 #increament the value of i
        else:
            sorted_list.append(right[j]) #store the element into arrray
            j += 1 #increament the value of j

    # Collect remaining elements from both lists
    sorted_list.extend(left[i:])
    sorted_list.extend(right[j:])

    return sorted_list

if __name__ == "__main__":
    # Example test cases
    print(merge_sort([88, 99, 44, 66, 7, 77]))      # Output: [7, 44, 66, 77, 88, 99]
    print(merge_sort([4, 3, 5, 5, 9]))              # Output: [3, 4, 5, 5, 9]
    print(merge_sort([5]))                          # Output: [5]
    print(merge_sort([]))                           # Output: []
