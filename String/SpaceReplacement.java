package String;

/**
 * Description
 * Write a method to replace all spaces in a string with %20.
 * The string is given in a characters array, you can assume it has enough space for replacement and you are given the true length of the string.
 *
 * You code should also return the new length of the string after replacement.
 *
 * If you are using Java or Python，please use characters array instead of string.
 *
 *
 * Example
 * Given "Mr John Smith", length = 13.
 *
 * The string after replacement should be "Mr%20John%20Smith",
 * you need to change the string in-place and return the new length 17.
 *
 * Challenge
 * Do it in-place.
 */
public class SpaceReplacement {
    public int replaceBlank1(char[] string, int length) {
        // write your code here
        if(0==length) return 0;
        int num = 0;
        for(int i=0;i<length;i++){
            if(string[i] == ' ') num++;
        }

        int newLen = length + num*2;
        //string[newLen] = 0;
        int j = 1;
        for(int i=length-1;i>=0;i--){
            if(string[i] != ' '){
                string[newLen - j] = string[i];
                j++;
            }
            else{
                string[newLen - j] = '0';
                j++;
                string[newLen - j] = '2';
                j++;
                string[newLen - j] = '%';
                j++;
            }
        }
        return newLen;
    }

    public int replaceBlank(char[] string, int length) {
        // write your code here
        if (string == null || string.length == 0) {
            return 0;
        }
        int count = 0;
        // for (int i = 0; i < length; i++) {
        //     if (string[i] == ' ') {
        //         count++;
        //     }
        // }

        for (char c : string) {
            if (c == ' ') {
                count += 2;
            }
        }

        int len = length + count - 1;
        string[len + 1] = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[len--] = '0';
                string[len--] = '2';
                string[len--] = '%';
            } else {
                string[len--] = string[i];
            }

        }

        return length + count;
    }

    public static void main(String[] args) {
        SpaceReplacement mytest = new SpaceReplacement();
        String s = "hello world! ";
        char[] res = new char[s.length() * 3];
        int i = 0;
        for (char c : s.toCharArray()) {
            res[i++] = c;
        }

        System.out.println(mytest.replaceBlank(res, s.length()));
        System.out.println(new String(res).trim());
    }
}
