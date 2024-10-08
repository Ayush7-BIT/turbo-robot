#include <iostream> 
using namespace std;

bool binarySearch(int *arr,int n,int target){
    int s=0;
    int e=n-1;
    int m=e+(s-e)/2;
    while(s<=e){
        if(arr[m]==target){
            return true;
        }
        else if(arr[m]<target){
            s=m+1;
        }
        else{
            e=m-1;
        }
        m=e+(s-e)/2;
    }
    return false;
}

int main(){
    int arr[6]={1,3,5,7,9,11};
    int size=sizeof(arr)/sizeof(int);
    int target=5;
    if(binarySearch(arr,size,target)){
        cout<<target<<" is present in the array"<<endl;
    }
    else{
        cout<<target<<" is not present in the array "<<endl;
    }
    return 0;
}
