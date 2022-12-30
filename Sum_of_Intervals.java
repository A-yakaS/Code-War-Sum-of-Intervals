package cw;
import java.util.Arrays;
public class Interval {

    public static int sumIntervals(int[][] intervals) {
    // Return 0 if the intervals array is empty
    if (intervals.length == 0) {
        return 0;
    }

    // Sort the intervals by start time
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    // Initialize the sum to be 0
    int totalLength = 0;

    // Initialize the start and end times of the current interval
    // to be the start and end times of the first interval
    int currentStart = intervals[0][0];
    int currentEnd = intervals[0][1];

    // Iterate through the rest of the intervals
    for (int i = 1; i < intervals.length; i++) {
        // If the current interval starts after the current interval ends,
        // then add the length of the current interval to the total and
        // update the current interval to be the current one
        if (intervals[i][0] > currentEnd) {
            totalLength += currentEnd - currentStart;
            currentStart = intervals[i][0];
            currentEnd = intervals[i][1];
        }
        // If the current interval starts before or at the same time as the current interval ends,
        // then update the current interval end time to be the later of the two end times
        else {
            currentEnd = Math.max(currentEnd, intervals[i][1]);
        }
    }

    // Add the length of the final interval to the total
    totalLength += currentEnd - currentStart;

    return totalLength;
    }
}
