/*
This program uses an unordered set to identify duplicates in an array.
After initializing the array, the findDuplicates() function is invoked, which loops through the array.
If the current element is already present in the set, it is recognized as a duplicate and is printed.
If the current element is not found in the set, it is added in the set, indicating its first occurrence.
*/


#include <iostream>
#include <unordered_set>
using namespace std;

class arr_dupl {
private:
    int arr[100];
    int size;

public:
    
    void setArray(int inputArr[], int n) {
        size = n;
        for (int i = 0; i < size; ++i) {
            arr[i] = inputArr[i];
        }
    }

    
    void findDuplicates() {
        unordered_set<int> seen;
        bool hasDuplicates = false;
        
        cout << "Duplicates found: ";
        for (int i = 0; i < size; ++i) {
            if (seen.find(arr[i]) != seen.end()) {
                cout << arr[i] << " ";
                hasDuplicates = true;
            } else {
                seen.insert(arr[i]);
            }
        }

        if (!hasDuplicates) {
            cout << "None";
        }
        cout << endl;
    }
};

int main() {
    arr_dupl obj;

    
    int arr[] = {1, 2, 3, 4, 2, 5, 6, 3, 7};
    int size = sizeof(arr) / sizeof(arr[0]);

    obj.setArray(arr, size); 
    obj.findDuplicates();   

    return 0;
}
