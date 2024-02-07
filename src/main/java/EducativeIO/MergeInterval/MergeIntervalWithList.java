package EducativeIO.MergeInterval;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class MergeIntervalWithList {
    public static List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> outputInterval = new ArrayList<>();
        ListIterator<Interval> intervalListIterator = intervals.listIterator();
        Interval interval = intervalListIterator.next();
        int start = interval.start;
        int end = interval.end;

        while(intervalListIterator.hasNext()) {
            interval = intervalListIterator.next();
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            }
            else {
                outputInterval.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        outputInterval.add(new Interval(start, end));

        return outputInterval;
    }

    @Test
    public void testMergeInterval() {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(1, 3));
        intervalList.add(new Interval(2, 6));
        intervalList.add(new Interval(8, 10));
        intervalList.add(new Interval(15, 18));

        List<Interval> outputIntervalList = new ArrayList<>();
        outputIntervalList.add(new Interval(1, 6));
        outputIntervalList.add(new Interval(8, 10));
        outputIntervalList.add(new Interval(15, 18));

        Assert.assertArrayEquals(outputIntervalList.toArray(), merge(intervalList).toArray());
    }
}
