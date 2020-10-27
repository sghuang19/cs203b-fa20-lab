package assignment_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HexComputeTest {
    @Test
    public void test0() {

        String s1 = "-EFFFF";
        String s2 = "2";
        System.out.println("(" + s1 + ")+(" + s2 + ")=" + HexCompute.addStrings(s1, s2));
        System.out.println("(" + s1 + ")*(" + s2 + ")=" + HexCompute.multiply(s1, s2));
        // System.out.print(s1.substring(s1.length()-1,s1.length()));
    }

    @Test
    public void test1() {

        String s1 = "-EFFFF";
        String s2 = "2";
        assertEquals("-EFFFD", HexCompute.addStrings(s1, s2));
        assertEquals(Long.parseLong("-EFFFD", 16), Long.parseLong(s1, 16) + Long.parseLong(s2, 16));
        assertEquals("-1DFFFE", HexCompute.multiply(s1, s2));
        assertEquals(Long.parseLong("-1DFFFE", 16), Long.parseLong(s1, 16) * Long.parseLong(s2, 16));

    }

    @Test
    public void test2() {

        String s1 = "-FFFFF";
        String s2 = "-2";
        assertEquals("-100001", HexCompute.addStrings(s1, s2));
        assertEquals(Long.parseLong("-100001", 16), Long.parseLong(s1, 16) + Long.parseLong(s2, 16));
        assertEquals("1FFFFE", HexCompute.multiply(s1, s2));
        assertEquals(Long.parseLong("1FFFFE", 16), Long.parseLong(s1, 16) * Long.parseLong(s2, 16));

    }

    @Test
    public void test3() {

        String s1 = "FFFFF";
        String s2 = "AAAAA";
        assertEquals("1AAAA9", HexCompute.addStrings(s1, s2));
        assertEquals(Long.parseLong("1AAAA9", 16), Long.parseLong(s1, 16) + Long.parseLong(s2, 16));
        assertEquals("AAAA955556", HexCompute.multiply(s1, s2));
        assertEquals(Long.parseLong("AAAA955556", 16), Long.parseLong(s1, 16) * Long.parseLong(s2, 16));

    }

    @Test
    public void test4() {

        String s1 = "F";
        String s2 = "AAAAA";
        assertEquals("AAAB9", HexCompute.addStrings(s1, s2));
        assertEquals(Long.parseLong("AAAB9", 16), Long.parseLong(s2, 16) + Long.parseLong(s1, 16));
        assertEquals("9FFFF6", HexCompute.multiply(s1, s2));
        assertEquals(Long.parseLong("9FFFF6", 16), Long.parseLong(s1, 16) * Long.parseLong(s2, 16));

    }

    @Test
    public void test5() {

        String s1 = "123";
        String s2 = "456";
        assertEquals("579", HexCompute.addStrings(s1, s2));
        assertEquals(Long.parseLong("579", 16), Long.parseLong(s2, 16) + Long.parseLong(s1, 16));
        assertEquals("4EDC2", HexCompute.multiply(s1, s2));
        assertEquals(Long.parseLong("4EDC2", 16), Long.parseLong(s1, 16) * Long.parseLong(s2, 16));

    }

    @Test
    public void test6() {

        String s1 = "8888888888888888888888888888888888888888888888888888888888888888888888888888888";
        String s2 = "7777777777777777777777777777777777777777777777777777777777777777777777777777777";
        assertEquals("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",
                HexCompute.addStrings(s1, s2));
        assertEquals(
                "3FB72EA61D950C83FB72EA61D950C83FB72EA61D950C83FB72EA61D950C83FB72EA61D950C83FB6AF37C048D159E26AF37C048D159E26AF37C048D159E26AF37C048D159E26AF37C048D159E26AF38",
                HexCompute.multiply(s1, s2));
    }

    @Test
    public void test7() {

        String s1 = "8888888888888888888888888888888888888888888888888888888888888888888888888888888";
        String s2 = "-7777777777777777777777777777777777777777777777777777777777777777777777777777777";
        assertEquals("1111111111111111111111111111111111111111111111111111111111111111111111111111111",
                HexCompute.addStrings(s1, s2));
        assertEquals(
                "-3FB72EA61D950C83FB72EA61D950C83FB72EA61D950C83FB72EA61D950C83FB72EA61D950C83FB6AF37C048D159E26AF37C048D159E26AF37C048D159E26AF37C048D159E26AF37C048D159E26AF38",
                HexCompute.multiply(s1, s2));
    }

    @Test
    public void test9() {

        String s1 = "8888888888888888888888888888888888888888888888888888888888888888888888888888888";
        // String s2 =
        // "-7777777777777777777777777777777777777777777777777777777777777777777777777777777";
        assertEquals("11111111111111111111111111111111111111111111111111111111111111111111111111111110",
                HexCompute.addStrings(s1, s1));
        assertEquals(
                "48D159E26AF37C048D159E26AF37C048D159E26AF37C048D159E26AF37C048D159E26AF37C048D0C83FB72EA61D950C83FB72EA61D950C83FB72EA61D950C83FB72EA61D950C83FB72EA61D950C840",
                HexCompute.multiply(s1, s1));
    }
}
