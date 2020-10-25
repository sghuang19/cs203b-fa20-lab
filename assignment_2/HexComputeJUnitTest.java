package assignment_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HexComputeJUnitTest extends HexCompute {

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

        num1 = "-AAAAA";
        num2 = "AA";
        result = addStrings(num1, num2);
        System.out.println(result);
        assertEquals("-AAA00", result);

        num1 = "-15BD9EA1B2103E57013EA50C4169F7F15A11A11B9BAC68E0BB4C72E5881F6F5D2A3FA8DEE516603E3A7A241ADCE9D9858549767602EE2A398D7F4BF36F8520C43C049EE8DC5E4681F88E5199DB2813F195EE27AE1AE4C81E3A649B98F83DFEAAC0E8326053485BFC3A2058E52BD412E5D89BE1F2A4C9E6D558E102497D5C5814DEBCA3F175DE690C9A7C8C5D99222BA1B46035A983978DB5D4D5DA07F9486AA866B20A68BE247015543E2C4E09C77C7E44C8E3C1CE3F483B0776FF5FFF6A084F937C3726298778E51FA98";
        num2 = "ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C";
        assertEquals(
                "-ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C",
                HexCompute.addStrings(num1, num2));
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

        num1 = "A";
        num2 = "AA";
        result = subtractStrings(num1, num2);
        System.out.println(result);
        assertEquals("-A0", result);

        num1 = "AAA";
        num2 = "AAA";
        result = subtractStrings(num1, num2);
        System.out.println(result);
        assertEquals("0", result);

        num1 = "AAA";
        num2 = "9AA";
        result = subtractStrings(num1, num2);
        System.out.println(result);
        assertEquals("100", result);
    }
}
