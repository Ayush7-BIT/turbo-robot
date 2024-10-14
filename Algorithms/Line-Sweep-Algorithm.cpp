class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        map<int, int> pointToCount;

        // Mark the starting and ending points in the map
        for (vector<int> interval : intervals) {
            pointToCount[interval[0]]++;
            pointToCount[interval[1] + 1]--;
        }

        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;
        // Iterate over the numbers in ascending order
        for (pair<int, int> p : pointToCount) {
            // Add the currently active intervals
            concurrentIntervals += p.second;

            // Update the maximum active intervals at any time
            maxConcurrentIntervals =
                max(maxConcurrentIntervals, concurrentIntervals);
        }

        return maxConcurrentIntervals;
    }
};
