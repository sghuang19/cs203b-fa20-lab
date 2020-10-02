# Exercise Week 2

---

## Question 1

>Express the function $n^3/1000-100n^2-100n+3$ in $\Theta$ notation.

$$
n^3/1000 - 100n^2 - 100n+3 = \Theta(n^3) - \Theta(n^2) - \Theta(n) + \Theta(1) = \Theta(n^3)
$$

---

## Question 2

>Consider sorting $n$ numbers stored in array `A` by ﬁrst ﬁnding the smallest element of `A` and exchanging it with the element in `A[1]`. Then find the second smallest element of `A` and exchange it with `A[2]`. Continue in this manner for the ﬁrst $n-1$ elements of `A`. Write pseudocode for this algorithm, which is known as selection sort. What loop invariant does this algorithm maintain? Why does it need to run for only the ﬁrst $n-1$ elements, rather than for all $n$ elements? Give the best-case and worst-case running times of selection sort in $\Theta$-notation.

```python
for j = 1 to n - 1                  c_1
    key = A[j]                      c_2
    i = j + 1                       c_3
    while A[i] < key and i <= n     c_4
        key = A[i]                  c_6
        i = i + 1                   c_6
    A[i] = A[j]                     c_7
    A[j] = key                      c_8
```

The loop invariant is `A[1 ... j]` is sorted.

Once the first $n - 1$ elements are sorted, the biggest element would be exchanged to the `n`th position automatically.

In best case, the array is already sorted, we only need to go through comparing the elements. Since the condition for the `while` loop to execute is always true, and this loop is embedded inside a `for` loop, the running time in $\Theta$ notation would be

$$
T(n)_\text{best} = \Theta(n^2).
$$

<!-- $$
\begin{aligned}
T(n)_\text{best} = &
c_1n + (c_2 + c_3 + c_6 + c_7 + c_8)(n-1) + \\ & \sum_{k = 2}^{n - 1} (k - 2)
\end{aligned}
$$ -->

In the worst case, accordingly, like in the best case, the running time is still

$$
T(n)_\text{worst} = \Theta(n^2).
$$

---

## Question 3

>How can we modify almost any algorithm to have a good best case running time?

Add a sub-algorithm to examine if the array being sorted is already sorted before the algorithm is executed.

---

## Question 4

>Use mathematical induction to show that when n is an exact power of 2, the solution to the recurrence
>
>$$
>\left\{\begin{aligned}
>& 2, & \quad\text{if}\quad n = 2, \\
>& 2T\left(\frac{n}{2}\right) + n
>& \quad\text{if}\quad n = 2^k,\text{ for } k > 1
>\end{aligned}\right.
>$$
>
>is $T(n) = n\lg n$.

For the base case, $T(2) = 2\lg2 = 2$, the solution is correct.

Set for $n = 2^k, k > 1$, the solution is valid, we have.

$$
T(n) = T(2^k) = 2^k\lg2^k = k\times2^k
$$

Therefore, we have the following

$$
T(2n) =
T(2^{k + 1}) =
2T(2^k) + 2^{k + 1} =
k\times2^{k + 1} + 2^{k + 1} =
(k + 1)2^{k + 1}
$$

Which implies that the solution is also correct for $k + 1$.

In conclusion, the solution is correct.

---

## Question 5

$$
T(n) =
\left\{\begin{aligned}
&1, \quad n = 1 \\
&T(n - 1) + \Theta(n), \quad n\ge 2
\end{aligned}\right.
$$
