//Python code for binary search algorithm
def binary_search(arr, target):
    # Set initial left and right pointers
    left, right = 0, len(arr) - 1

    while left <= right:
        # Find the middle index
        mid = left + (right - left) // 2
        
        # Check if the target is at the middle
        if arr[mid] == target:
            return mid
        # If target is greater, ignore the left half
        elif arr[mid] < target:
            left = mid + 1
        # If target is smaller, ignore the right half
        else:
            right = mid - 1

    # Target not found in the array
    return -1

# Example usage
arr = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
target = 7
result = binary_search(arr, target)

if result != -1:
    print(f"Target found at index: {result}")
else:
    print("Target not found")
