#include <unordered_map>
#include <list>
#include <iostream>
using namespace std;

class LFUCache {
private:
    // Node structure for storing key-value pair and frequency.
    struct Node {
        int key, value, freq;
        Node(int k, int v) : key(k), value(v), freq(1) {}
    };

    int capacity, minFreq;
    unordered_map<int, list<Node>::iterator> keyNode;   // Maps key to node in the freqList
    unordered_map<int, list<Node>> freqList;            // Maps frequency to a list of nodes

public:
    LFUCache(int capacity) {
        this->capacity = capacity;
        this->minFreq = 0;
    }

    int get(int key) {
        if (keyNode.find(key) == keyNode.end()) {
            return -1;  // Key not found
        }

        // Get node from keyNode map
        auto node = keyNode[key];
        int val = node->value, freq = node->freq;

        // Remove the node from the current frequency list
        freqList[freq].erase(node);
        if (freqList[freq].empty()) {
            freqList.erase(freq);
            if (minFreq == freq) minFreq++;
        }

        // Increase the frequency and move the node to the next frequency list
        freq++;
        freqList[freq].push_front({key, val});
        keyNode[key] = freqList[freq].begin();
        keyNode[key]->freq = freq;

        return val;
    }

    void put(int key, int value) {
        if (capacity == 0) return;

        if (keyNode.find(key) != keyNode.end()) {
            // If the key already exists, update the value and frequency
            auto node = keyNode[key];
            node->value = value;
            get(key);  // Update frequency
            return;
        }

        // If the cache is at full capacity, remove the least frequently used element
        if (keyNode.size() == capacity) {
            auto nodeToRemove = freqList[minFreq].back();
            keyNode.erase(nodeToRemove.key);
            freqList[minFreq].pop_back();
            if (freqList[minFreq].empty()) freqList.erase(minFreq);
        }

        // Insert the new node with frequency 1
        minFreq = 1;
        freqList[1].push_front({key, value});
        keyNode[key] = freqList[1].begin();
    }
};

// Example usage:
int main() {
    LFUCache cache(2);  // Cache capacity is 2

    cache.put(1, 1);
    cache.put(2, 2);
    cout << cache.get(1) << endl;   // returns 1
    cache.put(3, 3);                // removes key 2 and inserts key 3
    cout << cache.get(2) << endl;   // returns -1 (not found)
    cout << cache.get(3) << endl;   // returns 3
    cache.put(4, 4);                // removes key 1 and inserts key 4
    cout << cache.get(1) << endl;   // returns -1 (not found)
    cout << cache.get(3) << endl;   // returns 3
    cout << cache.get(4) << endl;   // returns 4
    return 0;
}
