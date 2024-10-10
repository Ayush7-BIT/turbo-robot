#include <iostream>
#include <vector>
#include <algorithm>

void bucketSort(std::vector<int>& arr) {
    if (arr.empty()) return;

    // Step 1: Create buckets
    int maxVal = *std::max_element(arr.begin(), arr.end());
    int bucketCount = maxVal / 10 + 1; // Adjust bucket count as needed
    std::vector<std::vector<int>> buckets(bucketCount);

    // Step 2: Distribute elements into buckets
    for (int num : arr) {
        buckets[num / 10].push_back(num);
    }

    // Step 3: Sort each bucket
    for (auto& bucket : buckets) {
        std::sort(bucket.begin(), bucket.end());
    }

    // Step 4: Combine sorted buckets
    arr.clear();
    for (const auto& bucket : buckets) {
        arr.insert(arr.end(), bucket.begin(), bucket.end());
    }
}

int main() {
    std::vector<int> arr = {34, 23, 54, 2, 45, 78, 33, 23};
    
    std::cout << "Original array: ";
    for (int num : arr) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    bucketSort(arr);

    std::cout << "Sorted array: ";
    for (int num : arr) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}

