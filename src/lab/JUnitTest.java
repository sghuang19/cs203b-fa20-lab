package lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class JUnitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Junit test OK");
	}
	@Test
	public void test01() {
		helloworld Helloworld = new helloworld();
		assertEquals("Hello world", Helloworld.print());
		//assertNotEquals("hello world", Helloword.print());
	}
	@Test
	public void test02() {
		helloworld Helloworld = new helloworld();
		assertEquals("hello world", Helloworld.print());
		//assertNotEquals("hello world", Helloword.print());
	}

}
