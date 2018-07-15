package HashMap;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 *
 * Example
 * given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total
 * and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each
 * and the remaining two with no more than 3 citations each, his h-index is 3.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] nums = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n ) {
                nums[n] ++;
            } else {
                nums[citations[i]]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += nums[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        HIndex mytest = new HIndex();
        int[] src = new int[] {0, 1,  5, 6};
        System.out.println(mytest.hIndex(src));
    }
}
