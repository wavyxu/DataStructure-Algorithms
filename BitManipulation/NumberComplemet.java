package BitManipulation;
import java.util.*;
import java.math.*;

public class NumberComplemet {


    // mask = ~0 : 1111 1111
    // num = 5   : 0000 0101
    // num & mask: 0000 0101
    // ---------------------
    // mask << 1 : 1111 1110
    // num = 5   : 0000 0101
    // num & mask: 0000 0100
    // ---------------------
    // mask << 1 : 1111 1100
    // num = 5   : 0000 0101
    // num & mask: 0000 0110
    // ---------------------
    // mask << 1 : 1111 1000
    // num = 5   : 0000 0101
    // num & mask: 0000 0010


    //  0000 0101
    //& 1111 1000
    //= 0000 0010

    public int findComplement2(int num) {
        int mask = ~0;
        while ( (num & mask) != 0 ) {
            mask <<= 1; }
        return ~mask & ~num;
    }

    // test case
    // num = 5 : 0000 0101
    // highestOneBit(num) : 0000 0100
    // highestOneBit(num) << 1 : 0000 1000
    // (highestOneBit(num) << 1) - 1 : 0000 0111
    // ~num :                          1111 1010
    // ~num & ((Integer.highestOneBit(num) << 1) - 1) : 0000 0010

    public int findComplement3(int num) {

        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

//    public int findComplement4(int num) {
//
//        return num & ~((Integer.highestOneBit(num) << 1) - 1);
//    }

    public static void main(String[] args) {
        NumberComplemet test = new NumberComplemet();
        System.out.println(test.findComplement2(5));


        System.out.println(test.findComplement3(5));
//        System.out.println(test.findComplement4(5));        // return 0;
        System.out.println((Integer.highestOneBit(5) << 1) - 1);


        // 5: 0000 0101
        // 7: 0000 0111
        // ~5: 1111 1010
        // ~7: 1111 1000

        //   5: 0000 0101
        //& ~7: 1111 1000
        //   =: 0000 0000
        System.out.println(5 & (~7));   // 0

        //  ~5: 1111 1010
        // & 7: 0000 0111
        //   =: 0000 0010
        System.out.println((~5) & (7));  // 2

//        int k = Integer.highestOneBit(5);
//        System.out.println(k);
    }
}
