package Array;
import java.util.*;
/**
 *Description
 * Given an interval list which are flying and landing time of the flight.
 * How many airplanes are on the sky at most?
 *
 * If landing and flying happens at the same time, we consider landing should happen at first.
 *
 * Example
 * For interval list
 *
 * [
 *   (1,10),
 *   (2,3),
 *   (5,8),
 *   (4,7)
 * ]
 * Return 3
 */

class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
class Point {
    int time;
    int position;
    public Point(int time, int position) {
        this.time = time;
        this.position = position;
    }
}
public class NumOfAirplanesInTheSky {
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        // write your code here
        int len = airplanes.size();
        Queue<Point> pq = new PriorityQueue<Point>(len * 2, new Comparator<Point>(){
            @Override
            public int compare(Point A, Point B) {
                if (A.time == B.time) {
                    if (A.position < B.position) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                if (A.time < B.time) {
                    return -1;
                }
                return 1;
            }
        });

        for (Interval curr : airplanes) {
            Point newPointUp = new Point(curr.start, 1);
            Point newPointDown = new Point(curr.end, -1);
            pq.offer(newPointUp);
            pq.offer(newPointDown);
        }
        int count = 0;
        int max = 0;
        while(!pq.isEmpty()) {
            Point curr = pq.poll();
            count = count + curr.position;
            max = Math.max(max, count);
        }

        return max;
    }
}
