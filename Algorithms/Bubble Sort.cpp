

// Aprroach is that comparing the adjacent elements and then doing adjacent swapping to push the bigger number at the last 



#include <bits/stdc++.h>
using namespace std;

int sort(int arr[], int n)
{
    
    for(int i=0; i<n-2; i++){
        for(int j = i+1; j<n-1; j++){
            if(arr[i]>arr[j]){
                swap(arr[j],arr[i]);
            }
        }
    }
}