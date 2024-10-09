public static int select(int s[], int e[]) {
    // The 's' array represents the start times of the activities.
    // The 'e' array represents the end times of the activities.
    // It is assumed that the 'e' array is already sorted in non-decreasing order.
    
    // Initialize a variable to count the number of activities that can be selected
    int count = 0;

    // Create an ArrayList 'al' to keep track of the indices of the selected activities
    ArrayList<Integer> al = new ArrayList<>();
    
    // The first activity (index 0) is always selected because the end times are sorted,
    // so it will finish the earliest among all activities.
    count = 1;  // We select the first activity by default.
    al.add(0);  // Add the index of the first activity (0) to the list.
    
    // Keep track of the end time of the last selected activity
    int lastele = e[0];  // The end time of the first selected activity is 'e[0]'.
    
    // Iterate over the remaining activities starting from index 1 (second activity)
    for (int i = 1; i < e.length; i++) {
        // If the start time of the current activity is greater than or equal to
        // the end time of the last selected activity, it means the current activity
        // can be selected because there is no overlap.
        if (s[i] >= lastele) {
            // Increment the count since we are selecting this activity
            count++;
            
            // Add the index of this activity to the list of selected activities
            al.add(i);
            
            // Update the end time of the last selected activity to the current activity's end time
            lastele = e[i];
        }
    }

    // The 'count' now contains the maximum number of activities that can be selected.
    return count;
}
