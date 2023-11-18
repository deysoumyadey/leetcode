package MergeInterval;

import org.junit.Test;

import java.util.Arrays;

public class MergeIntervalWithArray {
    public static int[][] mergeIntervals(int[][] intervals) {
        int x = intervals.length;
        if (intervals[0] == null) {
            return intervals;
        }
        int y = intervals[0].length;
        int[][] outputIntervals = new int[x][y];
        int outputCounter = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            }
            else {
                outputIntervals[outputCounter][0] = start;
                outputIntervals[outputCounter][1] = end;
                outputCounter++;
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        outputIntervals[outputCounter][0] = start;
        outputIntervals[outputCounter][1] = end;
        return  outputIntervals;
    }

    @Test
    public void testMergeWithArray() {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] outputIntervals = {{1,6}, {8,10}, {15,18}};
        int[][] actualOutputIntervals = mergeIntervals(intervals);
        /*for (int i = 0; i < outputIntervals.length; i++) {
            Assert.assertArrayEquals(outputIntervals[i], actualOutputIntervals[i]);
        }*/
        boolean arraysEqual = Arrays.deepEquals(outputIntervals, actualOutputIntervals);

        assert arraysEqual : "The 2D arrays are not equal.";
    }
}
