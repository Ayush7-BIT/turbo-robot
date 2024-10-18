void sortColors(vector<int>& arr) {
    int low = 0, mid = 0, high = arr.size() - 1;

    while (mid <= high) {
        if (arr[mid] == 0) {
            swap(arr[low], arr[mid]);
            low++;
            mid++;
        } 
        else if (arr[mid] == 1) {
            mid++;  // 1 is already in its correct place
        } 
        else {  // arr[mid] == 2
            swap(arr[mid], arr[high]);
            high--;  // Decrement high to place the 2 at the end
        }
    }
}
