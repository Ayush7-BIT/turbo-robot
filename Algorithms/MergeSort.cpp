// This is helper function for merge sort function.
void merge(int a[], int si, int ei) {
  int mid = (si + ei)/2 ;
  int *temp = new int[ei - si + 1];
  int i = si;
  int j = mid + 1;
  int k = 0;

  // This while loop will run till elements are left in both subarrays.
 while(i <= mid && j <= ei) {
   if(a[i] <= a[j]) {
      temp[k] = a[i];
      i++;
      k++;
   }
  else {
     temp[k] = a[j];
     k++;
     j++;
  }
 }
  // this loop will run when elements are remaining in first array but no elements in second array.
 while(i <= mid) {
  temp[k] = a[i];
  i++;
  k++;
  }
  // when no elements remaining in first array but still left in second array
 while(j <= ei) {
    temp[k] = a[j];
    k++;
    j++;
 }

  // merging both sub arryas.
int m = 0;
 while(m < k) {
  a[si + m] = temp[m];
  m++;
 }
}

// This is merge sort function
void merge_sort(int a[], int si, int ei) {
  if(si >= ei){
    return ;
  }
  int midindex = (si + ei)/2;
  merge_sort(a, si, midindex+1);
  merge_sort(a,midindex+1,ei);
  merge(a, si, ei);
}
