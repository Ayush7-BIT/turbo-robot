def dynamic_bubble_sort(arr):
    n = len(arr)
    swapped = True
    passes = 0
    
    while swapped:
        swapped = False
        passes += 1
        
        # Forward pass
        for i in range(n - passes):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                swapped = True
        
        if not swapped:
            break
        
        swapped = False
        
        # Backward pass
        for i in range(n - passes - 1, passes - 1, -1):
            if arr[i] < arr[i - 1]:
                arr[i], arr[i - 1] = arr[i - 1], arr[i]
                swapped = True
    
    return arr

# Test function
def test_sort(arr, name):
    print(f"\nTesting {name}:")
    print("Original:", arr)
    sorted_arr = dynamic_bubble_sort(arr.copy())
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
import time
import random

def performance_test(size):
    arr = [random.randint(1, 1000) for _ in range(size)]
    start_time = time.time()
    dynamic_bubble_sort(arr)
    end_time = time.time()
    print(f"\nTime taken to sort {size} elements: {end_time - start_time:.6f} seconds")

performance_test(100)
performance_test(1000)