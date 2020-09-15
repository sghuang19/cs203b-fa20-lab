# A Enhanced Solution of Our Lab Exercise on Array

>This thread is also a **TEST** for **Markdown** experience on Blackboard.

The problem in our lab 1 about array is to find the maximum income, the easiest way to **find out this value** can be concluded as one sentence "if the price tomorrow is higher then this day, then sell it". However, I didn't realise this and was trying to find the way of stocks transactions, which days to but and which days to sell, and really accomplished that! XD

---

## Code

Source code can be accessed at <https://github.com/SamuelHuang2019/DSAA-learning/blob/master/L1_Array.java>

I wrote 3 methods

### Find max and min

```java
private static int[] min(int[] price) {
    StringBuilder output = new StringBuilder("");
    // Verify the first price
    if (price[0] < price[1]) {
        output.append(0);
    }

    // Verify the prices in the middle
    for (int i = 1; i < price.length - 1; i++) {
        if (price[i] < price[i - 1] && price[i] < price[i + 1]) {
            output.append(i);
        }
    }

    // Verify the prices in the last
    if (price[price.length - 1] < price[price.length - 2]) {
        output.append(price.length - 1);
    }

    int[] mins = new int[output.length()];
    for (int i = 0; i < mins.length; i++) {
        mins[i] = Integer.parseInt(output.substring(i, i + 1));
    }
    return mins;
}
```

Input a array, then output an array of those local minimums. Another method called `max` is just similar.

### Merge these two arrays

```java
private static int[] merge(int[] min, int[] max) {
    StringBuilder output = new StringBuilder("");

    int j = 0; // index for max
    if (max[0] < min[0]) {
        j++;
    }
    // Verify the first maximum

    try {
        for (int i = 0; i < min.length; i++) {
            output.append(min[i]);
            output.append(max[j]);
            j++;
        } // Append them
    } catch (Exception e) {
        // Ignore Index Out of Bound Exception and go on
        output.deleteCharAt(output.length() - 1);
        // If one min is at the end of the output, then remove it
    }


    int[] merged = new int[output.length()];
    for (int i = 0; i < merged.length; i++) {
        merged[i] = Integer.parseInt(output.substring(i, i + 1));
    }

    // Final check if you should not buy at all!
    if (merged.length == 1) {
        merged = null;
    }
    return merged;
}
```

This method "merges" these two array into one, indicating the days of buying, selling, buying... etc. (I personally think use a `try` `catch` block to avoid `IndexOutofBoundsException` is really clever)

---

## Run

Take the 3 cases in Lab notes for example.

### Case 1

Input `[7,1,5,3,6,4]`(actually the digits can be separated by any chars), the out put is

![Case 1](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20200907191248-code.png)

Which means

- buying on day 2 for price of 1
- selling on day 3 for price of 5
- buying on day 4 for price of 3
- selling on day 5 for price of 6

That makes sense!

### Case 2

![Case 2](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20200907191821-code.png)

Also works well.

### Case 3

Case 3 is a little bit tricky, since the price is descending, you **should NOT buy at all**, in the earlier version the output would be just the final minimum ,which means "buy" in the end, obviously not what we want. This issue can be easily dealt with.

![Case 3](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20200907192527-code.png)

---

## Improvement

Maybe we could make the input more intuitive to understand, and calculate the final income, but I don't wanna deal with this anymore...
