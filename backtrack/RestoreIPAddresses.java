package backtrack;
import java.util.List;
import java.util.ArrayList;
/**
 * @author: Vivian Xu
 */

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();

        if(s.length() <4 || s.length() > 12)
            return result;

        helper(s, 0, new ArrayList<String>(), result);
        return result;
    }
    public void helper(String s, int start, List<String> prefix, List<String> result){
        if(prefix.size() == 4){
            if(start != s.length())
                return;

            StringBuffer sb = new StringBuffer();
            for(String tmp: prefix){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }

        for(int i=start; i<s.length() && i < start+3; i++){
            String tmp = s.substring(start, i+1);
            if(isvalid(tmp)){
                prefix.add(tmp);
                helper(s, i + 1, prefix, result);
                prefix.remove(prefix.size()-1);
            }
        }
    }
    private boolean isvalid(String s){
        if(s.charAt(0) == '0') {
            return s.equals("0"); // to eliminate cases like "00", "10"
        }
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}
