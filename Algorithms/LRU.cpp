#include <iostream>
#include <list>
#include <unordered_map>

using namespace std;

class LRUCache {
    int capacity;
    list<int> lruList; // Stores the keys in order of usage, most recent at the front
    unordered_map<int, pair<int, list<int>::iterator>> cache; // key -> (value, iterator in lruList)
    
public:
    LRUCache(int cap) : capacity(cap) {}
    
    int get(int key) {
        // If key is found in cache
        if (cache.find(key) != cache.end()) {
            // Move the accessed key to the front of the list (most recently used)
            lruList.erase(cache[key].second);
            lruList.push_front(key);
            cache[key].second = lruList.begin();
            
            return cache[key].first; // Return the value
        }
        return -1; // Key not found
    }
    
    void put(int key, int value) {
        // If the key is already in cache, update the value and move it to the front
        if (cache.find(key) != cache.end()) {
            lruList.erase(cache[key].second);
            lruList.push_front(key);
            cache[key] = {value, lruList.begin()};
        } else {
            // If the cache is full, remove the least recently used element (last of the list)
            if (lruList.size() == capacity) {
                int lruKey = lruList.back();
                lruList.pop_back();
                cache.erase(lruKey);
            }
            
            // Insert the new key-value pair
            lruList.push_front(key);
            cache[key] = {value, lruList.begin()};
        }
    }
};

int main() {
    LRUCache lruCache(3); // Cache capacity of 3

    lruCache.put(1, 10);
    lruCache.put(2, 20);
    lruCache.put(3, 30);

    cout << "Get 1: " << lruCache.get(1) << endl; // Should return 10
    cout << "Get 4: " << lruCache.get(4) << endl; // Should return -1 (not found)

    lruCache.put(4, 40); // Cache is full, should evict key 2

    cout << "Get 2: " << lruCache.get(2) << endl; // Should return -1 (evicted)
    cout << "Get 3: " << lruCache.get(3) << endl; // Should return 30
    cout << "Get 4: " << lruCache.get(4) << endl; // Should return 40
    
    return 0;
}
