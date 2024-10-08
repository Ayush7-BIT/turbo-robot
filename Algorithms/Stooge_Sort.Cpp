#include<iostream>
using namespace std;

// Creating a Function for implementing stooge sort.

void StoogeSort(int a[], int start, int end){
    int temp;
    //Now Further breaking the array if the subpart's length is more than 2.

    if(end-start+1>2){
        temp = (end-start+1)/3;
        StoogeSort(a,start,end-temp);
        StoogeSort(a,start+temp,end);
        StoogeSort(a,start,end-temp);
    }

    // Now Swapping the element at start and end.
    if(a[end]<a[start]){
        temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
}

// main function

main(){
    int n,i;
    cout<<"Enter the number of data elements to be sorted: ";
    cin>>n;
    int arr[n];
    cout<<"Enter the Elements:\n";
    for(i=0;i<n;i++){
        cin>>arr[i];
    }
    StoogeSort(arr,0,n-1);

    //printing the sorted data.
    cout<<"\nSorted Data ";
    for(i=0;i<n;i++){
        cout<<"-> "<<arr[i];
    }
    return 0;
}
