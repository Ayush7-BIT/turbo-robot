
def merge(left, right):
    result = []
    i = j = 0

  
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

   
    result.extend(left[i:])
    result.extend(right[j:])
    
    return result


def merge_sort(arr):
   
    if len(arr) <= 1:
        return arr

   
    mid = len(arr) // 2
    left_half = merge_sort(arr[:mid])
    right_half = merge_sort(arr[mid:])

 
    return merge(left_half, right_half)


if __name__ == "__main__":
    arr = [18, 27, 40, 8, 9, 88, 10]
    print("Original array:", arr)
    sorted_arr = merge_sort(arr)
    print("Sorted array:", sorted_arr)
