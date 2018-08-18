package array;
import java.util.*;
/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 */


public class MeetingRooms {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static Comparator<Interval> comparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    };
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, comparator);
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}
