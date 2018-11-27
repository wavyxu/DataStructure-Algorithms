package backtrack;
import java.util.*;
/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 */
public class AddAndSearchWord {
    private Set<String> dic;
    public AddAndSearchWord () {
        dic = new HashSet<>();
    }

    public void addWord(String word) {
        dic.add(word);
    }

    public boolean search(String word) {
        boolean res = false;

        return false;
    }
}
