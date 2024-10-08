#include <iostream>
using namespace std;

void PrintArray(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << '\t';
    }
    return;
}

int main()
{
    int arr[100];
    int size;
    cin >> size;

    for (int i = 0; i < size; i++)
    {
        cout << "Value of element " << i << " : ";      
        cin >> arr[i];
    }
    int left = 0, right = size - 1; 

    while (left <= right)
    {
        for (int i = 0; i <= right; i++)
        {
            if (arr[i] == 0)
            {
                swap(arr[i], arr[left]);
                left++;
            }
            if (arr[i] == 2)
            {
                swap(arr[i], arr[right]);
                right--;
            }
        }
    }
    PrintArray(arr, size);
}
