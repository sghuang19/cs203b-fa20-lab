package assignment_2;

/**
 * Given two Hex integer in String form num1 and num2.
 * <p>
 * Notice:
 * <p>
 * 1. num1 and num2 both contains only 0 - 9 and A - F, + and - signs are also
 * allowed (only consider in the first position).
 * <p>
 * 2. num1 and num2 both does not starts with 0, unless the number is 0 itself.
 * <p>
 * <p>
 * 3. Builtin BigInteger library is not allowed, transforming the input String
 * to integer for processing is also not allowed.
 * <p>
 * 4. Single input string is less then 200 digits.
 */
public class HexCompute {
    /**
     * Calculate the sum of num1 and num2, result also in String form. Inside this
     * method, if there is and only is one negative number, it calls the
     * subtractStrings method.
     *
     * @param num1
     * @param num2
     * @return the sum of num1 and num2 in String form
     */
    public static String addStrings(String num1, String num2) {
        boolean p1 = num1.charAt(0) == '+';
        boolean p2 = num2.charAt(0) == '+';
        if (p1)
            return addStrings(num1.substring(1), num2);
        if (p2)
            return addStrings(num1, num2.substring(1));

        boolean n1 = num1.charAt(0) == '-';
        boolean n2 = num2.charAt(0) == '-';
        if (n1 && n2)
            return '-' + addStrings(num1.substring(1), num2.substring(1));
        if (n1)
            return subtractStrings(num2, num1.substring(1));
        if (n2)
            return subtractStrings(num1, num2.substring(1));

        StringBuilder sum = new StringBuilder();
        String l;
        StringBuilder s;
        if (num1.length() >= num2.length()) {
            l = num1;
            s = new StringBuilder(num2);
        } else {
            s = new StringBuilder(num1);
            l = num2;
        }
        s.insert(0, "0".repeat(l.length() - s.length()));
        int i = l.length() - 1;
        boolean p = false;
        int temp;

        // this is the addition for both numbers to be positive
        while (i >= 0) {
            temp = 0;
            temp += Integer.parseInt("" + l.charAt(i), 16);
            temp += Integer.parseInt("" + s.charAt(i), 16);
            temp += (p) ? 1 : 0;
            p = temp >= 16;
            sum.append(Integer.toHexString(temp - ((p) ? 16 : 0)).toUpperCase());
            i--;
        }
        if (p)
            sum.append('1');

        // if (sum.length() != 1 && sum.charAt(sum.length() - 1) == '0')
        // sum.deleteCharAt(sum.length() - 1);

        return sum.reverse().toString();
    }

    /**
     * To calculate the difference between num1 and num2.
     * <p>
     * **Num1 and Num2 must all be without any signs.**
     *
     * @param num1 the Hex number to be subtracted from, in form of String
     * @param num2 the number to be subtracted, in form of String
     * @return the Hex difference num1 - num2, in form of String
     */
    public static String subtractStrings(String num1, String num2) {
        if (num1.equals(num2))
            return "0";

        StringBuilder diff = new StringBuilder();
        StringBuilder l = new StringBuilder(num1);
        StringBuilder s = new StringBuilder(num2);
        int m = Math.max(l.length(), s.length());
        s.insert(0, "0".repeat(m - s.length()));
        l.insert(0, "0".repeat(m - l.length()));

        int i = l.length() - 1;
        boolean p = false;
        int temp;

        // this is the subtraction for both numbers to be positive
        while (i >= 0) {
            temp = Integer.parseInt("" + l.charAt(i), 16);
            temp -= Integer.parseInt("" + s.charAt(i), 16);
            temp -= (p) ? 1 : 0;
            p = temp < 0;
            diff.append(Integer.toHexString(temp + ((p) ? 16 : 0)).toUpperCase());
            i--;
        }

        if (p) {
            String x = "1" + "0".repeat(diff.length());
            return "-" + subtractStrings(x, diff.reverse().toString());
        }

        while (diff.charAt(diff.length() - 1) == '0')
            diff.deleteCharAt(diff.length() - 1);

        return diff.reverse().toString();
    }

    /**
     * Calculate the product of num1 and num2, result also in String form.
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
            return "0";

        boolean p1 = num1.charAt(0) == '+';
        boolean p2 = num2.charAt(0) == '+';
        if (p1)
            return multiply(num1.substring(1), num2);
        if (p2)
            return multiply(num1, num2.substring(1));

        boolean n1 = num1.charAt(0) == '-';
        boolean n2 = num2.charAt(0) == '-';
        if (n1 && n2)
            return multiply(num1.substring(1), num2.substring(1));
        if (n1)
            return '-' + multiply(num1.substring(1), num2);
        if (n2)
            return '-' + multiply(num1, num2.substring(1));

        if (num1.length() < num2.length())
            return multiply(num2, num1);
        int p;
        int x;
        int y;
        int temp;

        // this is the multiplication for both numbers to be positive
        StringBuilder sum;
        StringBuilder prod = new StringBuilder("0");
        for (int i = num2.length() - 1; i >= 0; i--) {
            sum = new StringBuilder();
            x = Integer.parseInt("" + num2.charAt(i), 16);
            p = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                y = Integer.parseInt("" + num1.charAt(j), 16);
                temp = x * y;
                temp += p;
                temp -= 16 * (p = temp / 16);
                sum.append(Integer.toHexString(temp).toUpperCase());
            }
            if (p != 0)
                sum.append(Integer.toHexString(p));
            sum.insert(0, "0".repeat(num2.length() - 1 - i));

            prod.replace(0, prod.length(), addStrings(prod.toString(), sum.reverse().toString()));
        }

        if (prod.length() != 1 && prod.charAt(0) == '0')
            prod.deleteCharAt(0);

        return prod.toString();
    }
}
