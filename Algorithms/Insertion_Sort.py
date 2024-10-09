import random
import time
def dynamic_insertion_sort(arr):
    n = len(arr)
    passes = 0
    
    for i in range(1, n):
        current = arr[i]
        j = i - 1
        passes += 1
        
        # Move elements of arr[0..i-1], that are greater than current, to one position ahead of their current position
        while j >= 0 and arr[j] > current:
            arr[j + 1] = arr[j]
            j -= 1
        
        arr[j + 1] = current
        print(f"Pass {passes}: {arr}")  # Display array after each pass to track progress
    
    return arr

# Test function
def test_sort(arr, name):
    print(f"\nTesting {name}:")
    print("Original:", arr)
    sorted_arr = dynamic_insertion_sort(arr.copy())
    print("Sorted:  ", sorted_arr)
    print("Correct: ", sorted_arr == sorted(arr))

# Test cases
test_sort([64, 34, 25, 12, 22, 11, 90], "Random array")
test_sort([1, 2, 3, 4, 5], "Already sorted array")
test_sort([5, 4, 3, 2, 1], "Reverse sorted array")
test_sort([1, 1, 1, 1, 1], "Array with all equal elements")
test_sort([1], "Single element array")
test_sort([], "Empty array")
test_sort([3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5], "Array with repeated elements")
test_sort([10, -1, 3, 9, -13, 5, 7], "Array with negative numbers")
test_sort([10**9, 10**5, 10**2, 10**7], "Array with large numbers")
test_sort([1.5, 2.3, 0.7, 1.9, 1.1], "Array with floating-point numbers")

# Performance test
def performance_test(size):
    arr = [random.randint(1, 1000) for _ in range(size)]
    start_time = time.time()
    dynamic_insertion_sort(arr)
    end_time = time.time()
    print(f"\nTime taken to sort {size} elements: {end_time - start_time:.6f} seconds")

performance_test(100)
performance_test(1000)
