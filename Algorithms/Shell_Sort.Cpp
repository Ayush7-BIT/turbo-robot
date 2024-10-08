#include<iostream>
using namespace std;

// Method to sort the list using shell sort

void shellsort(int sort[], int size){
    for(int gap = size/2; gap>0; gap/=2){
        for(int i = gap; i<size; i++){
            int temp = sort[i];
            int j;
            for(j=i; j>=gap && sort[j-gap]>temp; j-=gap){
                sort[j] = sort[j-gap];
            }
            sort[j] = temp;
    }
}
}

//main
int main(){
    int size;
    cout<<"Enter the size of the array: ";
    cin>>size;
    int sort[size];

    cout<<"Enter array Elements:\n";
    for(int i=0;i<size;i++){
        cin>>sort[i];
    }
    shellsort(sort,size);
    cout<<"Array after sorting is: ";
    for(int i=0;i<size;i++){
        cout<<sort[i]<<" ";
    }
    cout<<endl;
    return 0;
}
