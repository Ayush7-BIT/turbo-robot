/**
 * @file bubble.cpp
 * @author Ashish Kumar Sahoo (github.com/ashish5kmax)
 * @brief It's about bubble sort algorithm implementation.
 * @version 0.1
 * @date 2024-10-07
 * 
 * @copyright Copyright (c) 2024
 * 
 */

#include <iostream> // for input/output
#include <vector> // for std::vector

// Class is created for code reusability and can be secured by making the function private and accessing it using a public function.
class bubble_sort_soln
{
public:
    void buuble_sort(std::vector<int> &nums, int n)
    {
        // Outer loop that corresponds to the number of
        // elements to be sorted
        for (int i = 0; i < n - 1; i++)
        {
            // Last i elements are already
            // in place
            for (int j = 0; j < n - i - 1; j++)
            {
                // if prev element is greater than next element then we swap eg:- 5,4 here we swap
                if (nums[j] > nums[j + 1])
                {
                    std::swap(nums[j], nums[j + 1]);
                }
            }
        }
    }
};

int main()
{
    // creating of object
    bubble_sort_soln s;

    //vector initialization
    std::vector<int> nums = {5, 4, 3, 2, 1};

    // to get size of the vector
    int n = nums.size();

    // function call
    s.buuble_sort(nums, n);
    return 0;
}
