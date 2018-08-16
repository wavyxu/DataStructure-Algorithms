package queue;
import java.util.*;
/**
 *Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
    class MovingAverage {
        private Queue<Integer> queue;
        private int maxSize;
        private double sum = 0.0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            maxSize = size;
            queue = new LinkedList<>();
        }

        public double next(int val) {
            sum += val;
            if(queue.size() == maxSize) {
                sum -= queue.poll();
            }
            queue.offer(val);
            return sum / queue.size();
        }
    }
}
