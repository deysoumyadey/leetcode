package EducativeIO.MergeInterval;

public class InsertIntervalWithArray {
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        int x = intervals.length;
        if (intervals[0] == null) {
            return intervals;
        }
        int y = intervals[0].length;
        int[][] outputIntervals = new int[x][y];
        int outputCounter = 0;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int intervalCounter = 0;
        
        while(intervalCounter < x) {
            if (intervals[intervalCounter][1] < newStart) {
                outputIntervals[outputCounter][0] = intervals[intervalCounter][0];
                outputIntervals[outputCounter][1] = intervals[intervalCounter][1];
                outputCounter++;
                intervalCounter++;
            }
            else {
                break;
            }
        }
        
        for(int i=intervalCounter; i<x; i++) {
            if (intervals[i][1] >= newStart) {
                newEnd = Math.max(intervals[i][1], newEnd);
                newStart = Math.min(intervals[i][0], newStart);
            }
            else {

            }
        }
        return outputIntervals;
    }

    // [[1,3],[4,5],[7,8],[9,12],[13,14]]
    // [2, 10]
    // [1, 12] newStart, newEnd

    // [[1,2],[3,5],[6,7],[8,10],[12,16]]
    // [3,10]
}
