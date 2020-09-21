# Memo

## On for loop

```java
public class test{
    public static void main(String[] args) {
        int i = 10;
        for (i = 0; i < 10; i++) {
        }
        System.out.println(i);
    }
}
```

This yields an output pf `10`, and the running time would be `11`, since `i` would be added up to `10` and then examined to exit the loop.

$$
T(n) = T(n-1) + 1 + 1
$$
$$
T(1) = T(0) + 1 + 1
$$
$$
T(0) = 1
$$
