package String;

public class ValidWordAbbreviation {
//    private int stringToInt(String s) {
//        int res = 0;
//        int i = 0;
//        while (s.charAt(i) == '0') {
//            i++;
//        }
//        for(; i < s.length(); i++) {
//            res = res * 10 + s.charAt(i) - '0';
//        }
//        return res;
//    }
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        if (word == null || abbr == null) {
            return false;
        }
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            while (i < word.length() &&
                    j < abbr.length() &&
                    word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            }
            if (j < abbr.length() && (abbr.charAt(j) > '0') && (abbr.charAt(j) <= '9')) {
                int start = j;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                i += Integer.valueOf(abbr.substring(start, j));

            } else {
                return i == word.length() && j == abbr.length();
            }

        }
        return i == word.length() && j == abbr.length();
    }

    // jiuzhang  better
    public boolean validWordAbbreviation1(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else if ((abbr.charAt(j) > '0') && (abbr.charAt(j) <= '9')) {     //notice that 0 cannot be included
                int start = j;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                i += Integer.valueOf(abbr.substring(start, j));
            } else {
                return false;
            }
        }
        return (i == word.length()) && (j == abbr.length());
    }

    public static void main(String[] args) {
        ValidWordAbbreviation test = new ValidWordAbbreviation();
        System.out.println(test.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(test.validWordAbbreviation("a", "01"));
        System.out.println(test.validWordAbbreviation1("a", "01"));
    }
}
