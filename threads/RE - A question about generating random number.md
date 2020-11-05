# RE : A question about generating random number

The answer is **NOPE**, but it just needs a slight adjustment.

---

The method `Math.random()` can generate a `double` value in range $[0,1)$, hence `Math.random()*6` is in range $[0,6)$. Using `(int)` for type casting will only round the value **DOWN**, so  `(int)(Math.random()*6)` is in range of $[0,5]$. Hence, `(int)(Math.random()*6)+1` is of course not the same as `rand7`, but is the same as `rand6`.

![Math.random()](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20200907221354-random.png)

Accordingly, `rand7 = (int)(Math.random()*7) + 1`.

---

On the other hand, I think you're probably concerned about the probability of these integers.

![Random](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20200907215338-random.png)

As we can see, the casted integer result can only be among these values: 0, 1, 2, 3, 4, 5. Since the corresponding line segment of these casted integers are exactly identical, the probability is evenly distributed among them.

A empty point at the end, will **NOT** affect the probability! Just like infinity plus one is still infinity.

I hope this could be helpful.
