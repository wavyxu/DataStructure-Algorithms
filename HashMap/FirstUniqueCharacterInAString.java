package HashMap;
import java.util.*;
/**
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> dup = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!dup.contains(c) && !map.containsKey(c)) {
                map.put(c, i);
            } else if (map.containsKey(c)) {
                dup.add(c);
                map.remove(c);
            }
        }
        if (map.size() == 0) {
            return -1;
        }
        return Collections.min(map.values());
    }
}
