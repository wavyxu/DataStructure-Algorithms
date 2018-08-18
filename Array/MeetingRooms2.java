package array;
import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRooms2 {
     class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

  class Point {
         public int time;
         public int flag;
         public Point(int time, int flag) {
             this.flag = flag;
             this.time = time;
         }

  }

  public static Comparator<Point> comparator = new Comparator<Point>(){
      @Override
      public int compare(Point A, Point B) {
          if (A.time == B.time) {
              return A.flag - B.flag;
          }
          return A.time - B.time;
      }
  };
    public int minMeetingRooms(Interval[] intervals) {
        List<Point> points = new ArrayList<>();
        for(Interval interval : intervals) {
            points.add(new Point(interval.start, 1));
            points.add(new Point(interval.end,-1));
        }
        Collections.sort(points, comparator);
        int res = 0;
        int count = 0;
        for(int i = 0; i < points.size(); i++) {
            count += points.get(i).flag;
            res = Math.max(res, count);
        }
        return res;
    }
}
