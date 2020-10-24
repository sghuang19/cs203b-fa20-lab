package exercise;

public class test {
    public static void main(String[] args) {
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

        System.out.println(23/16);
    }
}