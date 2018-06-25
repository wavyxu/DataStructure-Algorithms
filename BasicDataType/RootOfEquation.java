package BasicDataType;

public class RootOfEquation {
    public double[] rootOfEquation(double a, double b, double c) {
        // write your code here
        if (b * b - 4 * a * c  < 0) {
            return new double[0];
        }

        if (b * b - 4 * a * c  == 0 ) {
            double[] root = new double[1];
            root[0] = -b / (2.0 * a);
            return root;
        }

        double[] root = new double[2];
        double delta = Math.sqrt(b * b - 4 * a * c);
        root[0] = (-b + delta) / (2.0 * a);
        root[1] = (-b - delta) / (2.0 * a);

        if (root[0] > root[1]) {
            double temp = root[1];
            root[1] = root[0];
            root[0] = temp;
        }
        return root;
    }


}
