package String;

/**
 Description
 Write a function that takes a string as input and reverse only the vowels of a string.

 The vowels does not include the letter "y".

 Example
 Example 1:
 Given s = "hello", return "holle".

 */

public class ReverseVowels {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public String reverseVowels(String s) {
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end){

            while (start < end && !vowels.contains(chars[start] + "")){
                start++;
            }

            while (start < end && !vowels.contains(chars[end] + "")){
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        ReverseVowels rev = new ReverseVowels();
        String ans = rev.reverseVowels("Hello Word! I'm Wei Xu");
        System.out.println(ans);
    }
}
