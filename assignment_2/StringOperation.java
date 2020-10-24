package assignment_2;

/**
 * Given two Hex integer in String form num1 and num2.
 * 
 * Notice:
 * 
 * 1. num1 and num2 both contains only 0 - 9 and A - F, + and - signs are also
 * allowed (only consider in the first position).
 * 
 * 2. num1 and num2 both does not starts with 0, unless the number is 0 itself.
 * 
 * 
 * 3. Builtin BigInteger library is not allowed, transforming the input String
 * to integer for processing is also not allowed.
 *
 * 4. Single input string is less then 200 digits.
 */
public class StringOperation {
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
        boolean n1 = num1.charAt(0) == '-';
        boolean n2 = num2.charAt(0) == '-';

        if (n1 && n2)
            return "-" + addStrings(num1.substring(1), num2.substring(1));
        if (n1)
            return subtractStrings(num2.substring(1), num1);
        if (n2)
            return subtractStrings(num1.substring(1), num2);

        StringBuilder sum = new StringBuilder("");
        String l;
        String s;
        if (num1.length() >= num2.length()) {
            l = num1;
            s = num2;
        } else {
            s = num1;
            l = num2;
        }
        for (int i = 0; i < l.length() - s.length(); i++)
            s = "0" + s;
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
            sum.append(Integer.toHexString(temp -= (p) ? 16 : 0).toUpperCase());
            i--;
        }
        if (p)
            sum.append('1');

        return sum.reverse().toString();
    }

    /**
     * To calculate the difference between num1 and num2.
     * 
     * @param num1 the Hex number to be subtracted from, in form of String
     * @param num2 the number to be subtracted, in form of String
     * @return the Hex difference num1 - num2, in form of String
     */
    public static String subtractStrings(String num1, String num2) {
        StringBuilder diff = new StringBuilder("");
        String l = num1;
        String s = num2;
        if (num1.length() > num2.length())
            for (int i = 0; i < l.length() - s.length(); i++)
                s = "0" + s;
        else if (num1.length() < num2.length())
            for (int i = 0; i < s.length() - l.length(); i++)
                l = "0" + l;

        int i = l.length() - 1;
        boolean p = false;
        int temp;

        // this is the subtraction for both numbers to be positive
        while (i >= 0) {
            temp = 0;
            temp -= Integer.parseInt("" + l.charAt(i), 16);
            temp -= Integer.parseInt("" + s.charAt(i), 16);
            temp -= (p) ? 1 : 0;
            p = temp < 0;
            diff.append(Integer.toHexString(temp -= (p) ? 16 : 0).toUpperCase());
            i--;
        }
        if (p)
            diff.append('1');

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
        return num2;
        /*
         * TODO: YOUR CODE HERE
         */
    }

}
