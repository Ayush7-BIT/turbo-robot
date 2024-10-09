"""
Heap Sort :- Sorting algorithm , used to sort any list either in ascending or descending order,depending on whether we choose to use a MIN heap or a MAX heap
Heap is a Binary tree
Max heap:- A binary tree such that every parent node is greater than both of its children node.
Min heap :- Every parent node is less than or equal to its children node
👉In the following code we will use Max heap
#note :- the very first element in a max heap is always going to be the largest out of any of the elements in the heap.

code👇
"""
def swap(lst , i,j):
  lst[i] , lst[j] = lst[j] , lst[i]

def siftdown(lst , i, upper):
  while (True):
    l , r = i*2+1 , i*2+2
    if max(l,r)<upper:
        if lst[i] >= max(lst[l], lst[r]):
          break
        elif lst[l] > lst[r]:
          swap(lst , i ,l)
          i=l
        else:
          swap(lst , i,r)
          i=r
    elif l< upper:
          if lst[l] >lst[i]:
            swap(lst , i,l)
            i=l
          else:
            break
    elif r<upper:
          if lst[r] > lst[i]:
            swap(lst ,i ,r)
            i=r
          else:
            break
    else:
      break

def heap_sort(lst):
  for j in range((len(lst) -2)//2 , -1 ,-1):
      siftdown(lst,j,len(lst))
  for end in range(len(lst)-1,0,-1):
      swap(lst , 0, end)
      siftdown(lst,0,end)

#now run this program
lst = [5,16,8,14,20,1,26]
heap_sort(lst)
print(lst)

# output:- [1, 5, 8, 14, 16, 20, 26]
