package assignment_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;

public class KMPJUnitTest extends KMP {

    public static void main(String[] args) {

        int i = 1;
        System.out.println(i++);
        System.out.println(i);
    }

    @Before

    @Test
    public void computeNextArrayTest() {
        int[] next;

        next = computeNextArray("abaabcac");
        System.out.println(Arrays.toString(next));
        assertEquals("[-1, 0, 0, 1, 1, 2, 0, 1]", Arrays.toString(next));

        next = computeNextArray("touristrealgod");
        System.out.println(Arrays.toString(next));
        assertEquals("[-1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0]", Arrays.toString(next));

        next = computeNextArray("asardasd");
        System.out.println(Arrays.toString(next));
        assertEquals("[-1, 0, 0, 1, 0, 0, 1, 2]", Arrays.toString(next));
    }

    @Test
    public void KMPSearchTimesTest() {
        String P, S;
        int result;
        P = "wo";
        S = "chenljnbwowowoo";
        result = KMPSearchTimes(S, P);
        System.out.println(result);
        assertEquals(3, result);

        P = "tourist";
        S = "touristrealgod";
        result = KMPSearchTimes(S, P);
        System.out.println(result);
        assertEquals(1, result);

        P = "aba";
        S = "ababa";
        result = KMPSearchTimes(S, P);
        System.out.println(result);
        assertEquals(2, result);

    }

    @Test
    public void KMPFindLocationsTest() {
        String P, S;
        LinkedList<Integer> result;
        P = "wo";
        S = "chenljnbwowowoo";
        result = KMPFindLocations(S, P);
        System.out.println(result);
        assertEquals("[8, 10, 12]", result.toString());

        P = "tourist";
        S = "touristrealgod";
        result = KMPFindLocations(S, P);
        System.out.println(result);
        assertEquals("[0]", result.toString());
    }

    @After
    public void name() {

    }
}