package exercise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import exercise.hello;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i = 10;
        for (i = 0; i < 10; i++) {

        }
        System.out.println(i);
        i = 0;
        System.out.println(i -= 10);

        int num = 10;
        System.out.println(Integer.toHexString(num));
        String hex = "F";
        int x = Integer.parseInt(hex, 16);
        System.out.println(x);

        System.out.println(23 / 16);

        // hello.sayHello();

        Class h = Class.forName("exercise.hello");
        System.out.println(h);
        Method method = h.getMethod("sayHello");
        method.invoke(null, null);
    }
}