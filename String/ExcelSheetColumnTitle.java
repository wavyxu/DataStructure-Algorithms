package String;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"   // 26 * 26 + 25 = 701
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }
        String res = new String("");

        while (n > 0) {
            res = (char)('A' + (n - 1) % 26) + res;
            n = (n - 1) / 26;
        }
        return res.toString();
    }


    public String convertToTitle1(int n) {
        if (n < 1) {
            return "";
        }
        StringBuilder res = new StringBuilder();

        while (n > 0) {
            res.insert(0,(char)('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return res.toString();
    }
}
