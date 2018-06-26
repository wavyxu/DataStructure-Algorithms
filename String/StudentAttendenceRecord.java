package String;

/**
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendenceRecord {
    public boolean checkRecord(String s) {
        // Write your code here

        int countA = 0;
        int countL = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countL = 0;
                if (++countA > 1 ) {
                    return false;
                }
            } else if (s.charAt(i) == 'L') {
                if (++countL > 2 ) {
                    return false;
                }
            } else {
                countL = 0;
            }

        }
        return true;
    }
    public boolean checkRecord2(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }
    public boolean checkRecord3(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }

}
