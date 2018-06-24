package String;

public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        // Write your code here
        if (moves == null || moves.length() == 0) {
            return false;
        }
        int countL = 0, countR = 0, countU = 0, countD = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                countL++;
            }
            if (c == 'R') {
                countR++;
            }
            if (c == 'U') {
                countU++;
            }
            if (c == 'D') {
                countD++;
            }
        }

        return countD == countU && countR == countL;
    }
    public static void main(String[] args) {

    }
}
