def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = left + (right - left) // 2
        
        if arr[mid] == target:
            return mid  # Target found
        elif arr[mid] < target:
            left = mid + 1  # Search in the right half
        else:
            right = mid - 1  # Search in the left half
    
    return -1  # Target not found

# Main function to take user input and call the binary search
if __name__ == "__main__":
    n = int(input("Enter the number of elements in the array: "))
    arr = []

    print("Enter the sorted elements of the array:")
    for _ in range(n):
        arr.append(int(input()))

    target = int(input("Enter the element to search for: "))

    result = binary_search(arr, target)

    if result != -1:
        print(f"Element {target} found at index {result}.")
    else:
        print(f"Element {target} not found in the array.")
