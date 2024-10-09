import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    // Function to find the maximum number of activities that can be performed by a single person
    public static int maxActivities(int n, int[] start, int[] end) {
        // Create an array of activities
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], end[i]);
        }

        // Sort activities based on their end times
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

        // The first activity always gets selected
        int count = 1;
        int lastEndTime = activities.end;

        // Iterate through the remaining activities
        for (int i = 1; i < n; i++) {
            if (activities[i].start >= lastEndTime) {
                count++;
                lastEndTime = activities[i].end;
            }
        }

        return count;
    }

    // Activity class to store start and end times
    static class Activity {
        int start, end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Example usage
    public static void main(String[] args) {
        int n = 6;
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println(maxActivities(n, start, end));  // Output: 4
    }
}
