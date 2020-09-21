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
for j = 1 to n - 1              c_1
    key = A[j]                  c_2
    i = j + 1                   c_3
    while A[i] > key and i <= n c_4
        i = i + 1               c_5
    key = A[i]                  c_6
    A[i] = A[j]                 c_7
    A[j] = key                  c_8
```

The loop invariant is `A[1 ... j]` is sorted.

Once the first $n - 1$ elements are sorted, the biggest element would be exchanged to the `n`th position automatically.

In best case, the array is already sorted, we only need to go through comparing the elements. Hence the running time would be

$$
T(n)_\text{best} =
(c_1 + c_2 + c_3)(n-1) + \sum^{}
$$
