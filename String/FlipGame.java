package String;
import java.util.*;

/**
 * Description
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * Example
 * Given s = "++++", after one move, it may become one of the following states:
 *
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 * If there is no valid move, return an empty list [].
 */
public class FlipGame {
    private String replace(String s, int start) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == start || i == start + 1) {
                res.append('-');
                continue;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> res = new ArrayList<>();

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != '+') {
                continue;
            }
            int j = i + 1;
            if (j < s.length() && s.charAt(j) == '+') {
                String temp = replace(s, i);
                res.add(temp);
            }
        }
        return res;
    }
}
