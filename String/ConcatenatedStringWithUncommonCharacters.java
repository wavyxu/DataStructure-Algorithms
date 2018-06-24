package String;
import java.util.*;

/**
 * Description
 * Two strings are given and you have to modify 1st string such that all the common characters of the 2nd strings have to be removed and the uncommon characters of the 2nd string have to be concatenated with uncommon characters of the 1st string.
 *
 * Have you met this question in a real interview?
 * Example
 * Given s1 = aacdb, s2 = gafd
 * return cbgf
 *
 * Given s1 = abcs, s2 = cxzca;
 * return bsxz
 */

public class ConcatenatedStringWithUncommonCharacters {
    public String concatenetedString(String s1, String s2) {
        Set<Character> setOfS2 = new HashSet<>();
        Set<Character> commSet = new HashSet<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s2.length(); i++) {
            setOfS2.add(s2.charAt(i));
        }

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!setOfS2.contains(c)) {
                res.append(c);
            } else {
                commSet.add(c);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!commSet.contains(c)) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ConcatenatedStringWithUncommonCharacters test = new ConcatenatedStringWithUncommonCharacters();
        System.out.print(test.concatenetedString("abcs","cxzca"));
    }
}
