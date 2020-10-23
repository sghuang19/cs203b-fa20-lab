package assignment_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringOperationJUnitTest extends StringOperation {

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
        assertEquals("56088", result);
    }
}
