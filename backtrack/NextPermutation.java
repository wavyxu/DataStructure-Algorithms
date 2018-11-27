package backtrack;

/**
 * @author: Vivian Xu
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        int index = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(num, 0, num.length - 1);
            return;
        }
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[index] < num[i]) {
                swapItem(num, index, i);
                break;
            }
        }
        reverse(num, index + 1, num.length-1);
    }

    private void swapItem(int[] num, int left, int right) {
        int temp = num[right];
        num[right] = num[left];
        num[left] = temp;
    }
    private void reverse(int[] num, int start, int end) {
        while (start < end) {
            int tmp = num[start];
            num[start] = num[end];
            num[end] = tmp;
            start++;
            end--;
        }
    }
}
