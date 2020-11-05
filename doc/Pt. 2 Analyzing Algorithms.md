# Pt. 2 Analyzing Algorithms

## Insertion Sort

Pseudocode

```java
for j = 2 to n
    key = A[j]
    // Insert A[j] into the sorted sequence A[1 ... j-1]
    i = j - 1
    while i > 0 and A[i] > key
        A[i + 1] = A[i]
        i = i - 1
    A[i + 1] = key
```

>A **loop invariant** can be used to prove the correctness of an algorithm
>Loop invariant is a specific **property** or **condition** that is always satisfied in the loop. Using loop invariant to prove the correctness of an algorithm is similar to **proof by induction**.
>For detailed explanation, see blogs below:
>
>- [循环不变量(Loop invariant) by dazhi316](https://blog.csdn.net/dazhi316/article/details/6004080)
>- [循环不变式 by Wu Yudong](https://www.cnblogs.com/wuyudong/p/loop-invariant.html)

For detailed explanation on insertion sort algorithm, see links below.

- [插入排序（Insertion Sort） by 有毒的程序猿](https://www.jianshu.com/p/4ccf86b4f827)
- [插入排序（InsertionSort） by shuai@23](https://blog.csdn.net/jinwanchiji/article/details/79652304)

---

## Running Time

### RAM Model

>In order to predict resource requirements, we need a computational model.

- Instructions are executed **one by one** (no parallel operations)
- It would be complex and unnecessary to define each instruction and its time cost
- Instead we assume a common instruction set from real computers:
- **Arithmetic**: add, subtract multiply divide, mod, floor, ceiling, shift left and shift right (good for operations on $2^k$)
- **Data ops**: load, store, copy
- **Control**: conditional/unconditional branching, subroutine calls, return

>Each instruction uses constant time.

### Definition of Run-Time

Running Time: on a **particular** input, it is the **number** of **primitive operations** (steps) executed.

>Run times are machine & compiler-dependent
>Time & space complexities are machine & compiler-independent.

Basic Assumptions:

- instructions are executed **sequentially**
- each instruction is **simple**, and takes exactly **one time unit**
- integer size is fixed and we have infinite memory

>Typically $T_\text{avg}(N)$ and $T_\text{worst}(N)$, the **average** and **worst** case time are concerned.

### Example: Run-Time of Insertion Sort

![Run-time of each line in insertion sort](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20200917200147-runtime-insertion-sort.png)

Then the running time of insertion sort is

$$
\begin{aligned}
T(n) = &
c_1n + c_2(n-1) + c_3(n-1) + \\ &
c_5 \sum_{j=2}^n t_j +
c_6 \sum_{j=2}^n (t_j-1) +
c_7 \sum_{j=2}^n (t_j-1) +
c_8(n-1)
\end{aligned}
$$

In which, $t_j$ is the number of times the `while` structure loops.

>The last time of the loop, judging sentence will be run once for exiting the loop structure, so the times of the judging sentence is $t_j$, while the lines inside the structure are executed $t_j-1$ times.

> Usually we concentrate on finding

#### Best Case

Which means the array is **already sorted**. Since `A[i] <= key` is always true upon the `while` loop test runs (when `i = j - 1`), all $t_j$ are $1$.

Hence, the running time is

$$
T(n) =
(c_1 + c_2 + c_4 +c_5 + c_8)n -
(c_2 + c_4 + c_5 + c_8)
$$

Which is a **linear function** of $n$.

#### Worst Case

Which means the array is **reverse sorted**.

- `A[i] > key` is always true upon the `while` loop test runs (when `i = j - 1`).
- Will need to compare `key` with all `j - 1` elements to the left of the `j`th position.
- Since the `while` loop exits when `i = 0`, there is an additional test, hence $t_j = j$.
- ... (Arithmetic operations, like summing)

Therefor. the running time is

$$
\begin{aligned}
T(n) = &
c_1n + c_2(n-1) + c_4(n-1) + \\ &
c_5 \left[\frac{n(n+1)}{2} - 1\right] +
c_6 \left[\frac{n(n-1)}{2}\right] +
c_7 \left[\frac{n(n-1)}{2}\right] + \\ &
c_8(n-1) \\ = &
\left(
    \frac{c_5}{2} + \frac{c_6}{2} + \frac{c_7}{2}
\right)n^2 + \\ &
\left(
    c_1 + c_2 + c_4 + \frac{c_5}{2} - \frac{c_6}{2} - \frac{c_7}{2}
\right)n - \\ &
(c_2 + c_4 + c_5 + c_8)
\end{aligned}
$$

Which is a **quadratic function** of $n$

---

## Divide and Conquer

There are several ways for designing algorithm.

**Incremental**: a small positive change in a variable quantity.

> Insertion sorting is an example of incremental design.

- **Divide** the problem into a number of sub-problems that are smaller instances of the same problem.
- **Conquer** the sub-problems by solving them recursively
- **Combine** the subproblem solutions to give a solution to the original problem.

---

## Merge Sort

- Based on divide and conquer
- Lower order of growth of worst-case running time

To sort `A[p ... r]`:

1. **Divide** by splitting into two sub-arrays `A[p ... q]` and `A[q+1 ... r]`, where `q` is the halfway point of `A[p ... r]`.
2. **Conquer** by recursively sorting the two sub-arrays `A[p ... q]` and `A[q+1 ... r]`.
3. **Combine** by merging the two sorted sub-arrays `A[p ... q]` and `A[q+1 ... r]` to produce a single sorted sub-array `A[p ... r]`. To accomplish this step, define a procedure `MERGE(A, p, q, r)`.

### Pseudocode

```java
MERGE-SORT(A, p, r)
    if p < r
        q = ⌊(p + r)/2⌋          // divide
        MERGE-SORT(A, p, q)     // conquer
        MERGE-SORT(A, q+1, r)   // conquer
        MERGE(A, p, q, r)       // combine
```

### Merge Procedure

We define `Merge(A, p, q, r)`, where

- $p\le q\le r$
- Sub-array `A[p ... q]` and `A[q+1 ... r]` is sorted

This would take linear time $\Theta(n)$, where $n = r - p + 1$, which is the **number of elements being merged**.

>Ideas behind: consider two piles of cards.
>
>- Choose the smaller of the two top cards.
>- Remove it from its pile, thereby exposing a new top card.
>- Place the chosen card face-down onto the output pile.

```java
MERGE(A, p, q, r)
    n1 = q - p + 1
    n2 = r - q
    let L[1 ... n1+1] and R[1 ... n2+1] be new arrays
    for i = 1 to n1
        L[i] = A[p + i - 1]
    for j = 1 to n2
        L[i] = A[p + i - 1]
    L[n1 + 1] = ∞
    R[n2 + 1] = ∞
    i = 1
    j = 1
    for k = p to r
     if L[i] <= R[j]
        A[k] = L[i]
        i = i + 1
    else A[k] = R[j]
        j = j + 1
```

>Put on the bottom of each input pile a special **sentinel** card, it contains a special value to **simplify the code**. We use ∞, since that’s guaranteed to “lose” to any other value.
>
>The only way that ∞ cannot lose is when both piles have ∞ exposed as their top cards. But when that happens, all the non-sentinel cards have already been placed into the output pile.

- The first two `for` loops take $\Theta(n_1 + n_2) = \Theta(n)$ time.
- The last `for` loop makes $n$ iterations, each take constant time for $\Theta(n)$ time.
- Total time: $\Theta(n)$

### Recurrence

**Recurrence equation** (or **recurrence**) can be used to describe the running time of a divide-and-conquer algorithm.

Let $T(n)$ be the running time on a problem of size $n$.

- If the problem size is **small enough** we have a base case.
- Otherwise, suppose we **divide** into sub-problems, each $1/b$ times the size of the original problem.
- Let the time to **divide** a size $n$ problem be $D(n)$.
- There are sub-problems to solve, each of size $n/b$.
- **Each sub-problem** takes $T(n/b)$ time to solve.
- We spend $aT(n/b)$ time **solving sub-problems**
- Let the time to **combine** solutions be $C(n)$

The recurrence is

$$
T(n) =
\begin{cases}
& \Theta(1) & \text{if } n\le c\\
& aT(n/b) + D(n) + C(n) & \text{otherwise}
\end{cases}
$$

### Total Run Time of Merge Sort

>For simplicity, assume each $n$ is a power of $2$

- Base case occurs when $n = 1$.

For $n\ge2$

- Divide
Compute $q$ as the average of $p$ and $r$, takes $D(n) = \Theta(1)$.
- Conquer
Recursively solve 2 sub-problems each of size $n/2$, takes $2T(n/2)$
- Merge
Merge an $n$ element sub-array that takes $\Theta(n)$ time, takes $C(n) = \Theta(n)$

Therefore the recurrence is

$$
T(n) =
\begin{cases}
& \Theta(1) & \text{if } n = 1\\
& 2T(n/2) + \Theta(n) & \text{if } n > 1
\end{cases}
$$

>By the **Master Theorem**, we can find the solution directly.
>Master Theorem will be covered in future chapters.

$$
T(n) = \Theta(n\lg n).
$$

Let $c$ be a constant that describes the running time for the base case and also is the time per array element for the divide and conquer steps.

![Running time of divide and conquer algorithm](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20200919174858-divide-conquer.png)

Each time we go down one level, **the number of sub-problems doubles** but **the cost per subproblem halves** so cost per level stays the same.

- a tree for problem size $2^i$ has $\lg 2^i + 1 = i + 1$ levels
- the next problem size after $2^i$ is $2^{i+1}$
- which has one more level, $i+2$ levels
- then $\lg 2^{i+1} + 1 = i+2$
- hence the assumption holds

Summing each level, gets $\Theta(n\lg n)$.
