package assignment_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringOperationJUnitTest extends StringOperation {

    public static void main(String[] args) {
        String num1, num2, result;
        num1 = "10000";
        num2 = "F";
        result = subtractStrings(num1, num2);
        System.out.println(result);
    }

    @Test
    public void addStringTest() {
        String num1, num2, result;
        num1 = "2";
        num2 = "3";
        result = addStrings(num1, num2);
        System.out.println(result);
        assertEquals("5", result);

        num1 = "123";
        num2 = "456";
        result = addStrings(num1, num2);
        System.out.println(result);
        assertEquals("579", result);

        num1 = "AAA123";
        num2 = "12BAC";
        result = addStrings(num1, num2);
        System.out.println(result);
        assertEquals("ABCCCF", result);

        num1 = "+AAA123";
        num2 = "+12BAC";
        result = addStrings(num1, num2);
        System.out.println(result);
        assertEquals("ABCCCF", result);
    }

    @Test
    public void multiplyTest() {
        String num1, num2, result;
        num1 = "2";
        num2 = "3";
        result = multiply(num1, num2);
        System.out.println(result);
        assertEquals("6", result);

        num1 = "123";
        num2 = "456";
        result = multiply(num1, num2);
        System.out.println(result);
        assertEquals("4EDC2", result);

        num1 = "AA";
        num2 = "AA";
        result = multiply(num1, num2);
        System.out.println(result);
        assertEquals("70E4", result);

        num1 = "+123AAA";
        num2 = "-4A5B6CD";
        result = multiply(num1, num2);
        System.out.println(result);
        assertEquals("-54B77BDFD622", result);
    }

    @Test
    public void subtractStringTest() {
        String num1, num2, result;
        num1 = "2";
        num2 = "3";
        result = subtractStrings(num1, num2);
        System.out.println(result);
        assertEquals("-1", result);

        num1 = "123";
        num2 = "456";
        result = subtractStrings(num1, num2);
        System.out.println(result);
        assertEquals("-333", result);

        num1 = "AAA123";
        num2 = "12BAC";
        result = subtractStrings(num1, num2);
        System.out.println(result);
        assertEquals("A97577", result);
    }
}
