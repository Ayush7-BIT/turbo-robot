#include<iostream>
#include<vector>
using namespace std;
void bubbleSort(vector<int>&a)//This function is used to sort the array in Ascending Order using Bubble Sort Technique
{
    int n=a.size();
    bool swap;
    for(int i=0;i<n-1;i++)
    {
        swap=false;
        for(int j=0;j<n-i-1;j++)
        {
            if(a[j]>a[j+1])
            {
                int temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                swap=true;
            }

        }
        if(!swap)
        break;
    }
}
void print(vector<int>&a)//This is used to print the array element
{
    for(int num:a)
    cout<<num<<" ";
}
int main()
{
    vector<int> a={9,8,11,7,67,5};
    bubbleSort(a);
    cout<<"Sorted Array\n";
    print(a);
}