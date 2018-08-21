package heap;
import java.util.*;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {
    public int trap2(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int highFromL = height[0];
        int highFromR = height[n - 1];

        int l = 0;
        int r = n - 1;

        int res = 0;
        while (l <= r) {
            if (highFromL < highFromR) {
                res += Math.max(0, highFromL - height[l]);
                highFromL = Math.max(highFromL, height[l]);
                l++;
            } else {
                res += Math.max(0, highFromR - height[r]);
                highFromR = Math.max(highFromR, height[r]);
                r--;
            }
        }

        return res;
    }
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int[] highFromL = new int[n];
        int[] highFromR = new int[n];

        highFromL[0] = height[0];
        highFromR[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            highFromL[i] = Math.max(highFromL[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            highFromR[i] = Math.max(highFromR[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += Math.max (0, Math.min(highFromL[i - 1], highFromR[i + 1]) - height[i]);
        }

        return res;
    }
    public static void main(String[] args) {
        int[] src = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater mytest = new TrappingRainWater();
        System.out.println(mytest.trap2(src));
    }
}
