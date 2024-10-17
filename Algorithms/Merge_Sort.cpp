************************************************************** Merge Sort Using C++ **************************************************************

===> Approach
-------------
  
If the list has only one element or is empty, it is already sorted.

Divide the list into two halves.

Recursively apply MergeSort to both halves.

Merge the two sorted halves to produce a single sorted list.

===> Pseudo Code
----------------

merge(arr, left, mid, right){
    i = left
    j = mid + 1
    k = 0
    n = right - left + 1
    new_arr[n]
    
    while(i <= mid && j <= right){
        if(arr[i] < arr[j]){
            new_arr[k] = arr[i]
            i++
            k++
        }
        else{
            new_arr[k] = arr[j]
            j++
            k++
        }
    }
    while(i <= mid){
        new_arr[k] = arr[i]
        i++
        k++
    }
    while(j <= right){
        new_arr[k] = arr[j]
        j++
        k++
    }
    for c from 0 to n-1 {
        arr[left+c] = new_arr[c]
    }
}
mergeSort(arr, left, right)
{
    if( left == right) //base case
        return 
    mid = (left + right) / 2 //calculate mid
    mergeSort(arr, left, mid) //left
    mergeSort(arr, mid + 1, right) //right
    merge(arr, left, mid, right) // combine two arrays
}


===> Explanation of the above pseudo code
-----------------------------------------

The mergeSort Function:

* Base case: 

   > If the left index is equal to the right index, the array has only one element and is therefore considered sorted.

   > The function returns immediately in this case.

* Dividing the array: 

   > The array is split into two halves by calculating the middle index (mid).

   > This is done by averaging the left and right indices.

* Recursive calls:

   > The mergeSort function is then called recursively first on the left half (arr[left...mid]) and then on the right half (arr[mid+1...right]).

   > These calls continue to break down the array into smaller and smaller parts until each part is a single element.

* Merging:

   > After sorting both halves, the merge function is called to sort and combine these halves back into a single sorted array.
  
The merge Function:

* Creating a temporary array: 

   > A temporary array (new_arr) is created to store the merged and sorted elements.

   > Its size is exactly enough to hold all elements from left to right.

* Comparing and merging:

   > The function iterates through the left and right halves of the original array, comparing elements.

   > The smaller element from each comparison is copied into new_arr.

   > This process continues until all elements from both halves are in new_arr.

   > If an element in the left half is smaller, it's added to new_arr and we move to the next element in the left half.

   > If an element in the right half is smaller or if there are no more elements in the left half, the element from the right half is added to new_arr.

* Copying back: 

   > Once all elements are merged into new_arr, they are copied back into their original positions in the input array (arr).

   > This step ensures that the portion of the array being merged is now sorted.


  
===> Code Implementation
------------------------

#include<bits/stdc++.h>
using namespace std;

void merge(int arr[], int left, int mid, int right)
{
    int i=left;
    int j = mid+1;
    int k=0;
    int n = right-left+1;
    int new_arr[n];
    
    while(i<=mid and j<=right)
    {
        if(arr[i]<arr[j])
        {
            new_arr[k]=arr[i];
            i++;
            k++;
        }
        else
        {
            new_arr[k]=arr[j];
            j++;
            k++;
        }
    }
    while(i<=mid)
    {
        new_arr[k]=arr[i];
        i++;
        k++;
    }
    while(j<=right)
    {
        new_arr[k]=arr[j];
        j++;
        k++;
    }
    for(int c=0;c<=n-1;c++)
    {
        arr[left+c]=new_arr[c];
    }
}
void merge_sort(int arr[], int left, int right)
{
    if(left==right)
    {
        return;
    }
    int mid = (left+right)/2;
    merge_sort(arr, left, mid);
    merge_sort(arr, mid+1,right);
    
    merge(arr,left,mid,right);
}

int main()
{
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }
    merge_sort(arr,0,n-1);
    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<" ";
    }
    return 0;
}


===> Time Complexity & Space Complexity
---------------------------------------

Time Complexity: O(n log n)

Space Complexity for Additional Space: O(n)
Stack space: O(log(n)) where log is  of base 2




