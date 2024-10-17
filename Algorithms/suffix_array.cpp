#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// Structure to store suffixes and their index positions
struct Suffix {
    int index;        // Store original index
    string suff;      // Store suffix starting at index
};

// A comparison function used by sort() to compare two suffixes
bool cmp(Suffix a, Suffix b) {
    return a.suff < b.suff;
}

// Function to build the suffix array for a given text
vector<int> buildSuffixArray(string text) {
    int n = text.length();
    vector<Suffix> suffixes(n);

    // Store suffixes and their indexes in the suffixes array
    for (int i = 0; i < n; i++) {
        suffixes[i].index = i;
        suffixes[i].suff = text.substr(i); // Store suffix at position i
    }

    // Sort the suffixes using the comparison function
    sort(suffixes.begin(), suffixes.end(), cmp);

    // Store indexes of the sorted suffixes in suffix array
    vector<int> suffixArray(n);
    for (int i = 0; i < n; i++)
        suffixArray[i] = suffixes[i].index;

    return suffixArray;
}

// Function to print the suffix array
void printSuffixArray(vector<int> suffixArray) {
    cout << "Suffix Array: ";
    for (int i : suffixArray) {
        cout << i << " ";
    }
    cout << endl;
}

int main() {
    string text = "banana";
    vector<int> suffixArray = buildSuffixArray(text);
    printSuffixArray(suffixArray);
    return 0;
}
