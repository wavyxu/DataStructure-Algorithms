package twopointers;

/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer)
 * of a researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 *
 * Example:
 *
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 *              received 0, 1, 3, 5, 6 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note:
 *
 * If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int h = 0;
        int l = 0;
        int r = citations.length - 1;
        int n = citations.length;

        while (l < r - 1) {
            int mid = l + (r - l) / 2;

            if (citations[mid] == n - mid) {
                h = n - mid;
                return h;
            } else if (citations[mid] > n - mid){
                r = mid;
            } else {
                l = mid ;
            }
        }

        if (citations[l] >= n - l) { h = n - l;}
        else if (citations[r] >= n - r) {h = n - r;}
        return h;
    }

    // solution 2
    // The idea is to search for the first index from the sorted array so that :
    //
    //citations[index] >= length(citations) - index.
    //
    //And return (length - index) as the result.
    public int hIndex2(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int med = (hi + lo) / 2;
            if (citations[med] == len - med) {
                return len - med;
            } else if (citations[med] < len - med) {
                lo = med + 1;
            } else {
                //(citations[med] > len-med), med qualified as a hIndex,
                // but we have to continue to search for a higher one.
                hi = med - 1;
            }
        }
        return len - lo;
    }
}
