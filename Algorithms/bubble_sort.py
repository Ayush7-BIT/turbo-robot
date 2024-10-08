#algorithm for bubble sorting in python
def dynamic_bubble_sort(arr):
    n = len(arr)
    swapped = True
    passes = 0
    
    while swapped:
        swapped = False
