package BinarySearch;

public class Pow {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        boolean isNegative = false;

        if (n < 0) {
            isNegative = true;
            n = - (n + 1);  // avoid overflow when n == MIN_VALUE
            x = 1 / x;
        }

        double res = 1, temp = x;
        while (n > 0) {
            if (n % 2 != 0 ){
                res *= temp;
            }

            temp = temp * temp;      // x^n == (x^2)^(n/2)
            n >>= 1;
        }

        if (isNegative) {
            res *= x;
        }
        return res;
    }
}
