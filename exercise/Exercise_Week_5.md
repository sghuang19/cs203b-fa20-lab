# Exercise Week 4

## Question 1

>Use Strassen's algorithm to compute the following matrix product (show your working out and the intermediate calculations).
>
>$$
>\begin{pmatrix}
>1 & 3 \\ 7 & 5
>\end{pmatrix}
>\begin{pmatrix}
>6 & 8 \\ 4 & 2
>\end{pmatrix}
>$$

First, divide each matrix into four parts, that is

$$
\begin{aligned}
A_{11} = (1), \quad
A_{12} = (3), \quad
A_{21} = (7), \quad
A_{12} = (5) \\
B_{11} = (6), \quad
B_{12} = (8), \quad
B_{21} = (4), \quad
B_{22} = (2)
\end{aligned}
$$

Second, calculate matrices $S$s.

$$
\begin{aligned}
& S_1 = B_{12} - B_{22} = (8) - (2) = (6), \\
& S_2 = A_{11} + A_{12} = (1) + (3) = (4), \\
& S_3 = A_{21} + A_{22} = (7) + (5) = (12), \\
& S_4 = B_{21} - B_{11} = (4) - (6) = (-2), \\
& S_5 = A_{11} + A_{22} = (1) + (5) = (6), \\
& S_6 = B_{11} + B_{22} = (6) + (2) = (8), \\
& S_7 = A_{12} - A_{22} = (3) - (5) = (-2), \\
& S_8 = B_{21} + B_{22} = (4) + (2) = (6), \\
& S_9 = A_{11} - A_{21} = (1) - (7) = (-6), \\
& S_{10} = B_{11} + B_{12} = (6) + (8) = (14).
\end{aligned}
$$

Third, calculate matrices $P$s.

$$
\begin{aligned}
& P_1 = A_{11}\cdot S_1 = (1)\cdot(6) = (6), \\
& P_2 = S_2\cdot B_{22} = (4)\cdot(2) = (8), \\
& P_3 = S_3\cdot B_{11} = (12)\cdot(6) = (72), \\
& P_4 = A_{22}\cdot S_4 = (5)\cdot(-2) = (-30), \\
& P_5 = S_5\cdot S_6 = (-2)\cdot(6) = (-12), \\
& P_6 = S_7\cdot S_8 = (1)\cdot(6) = (6), \\
& P_7 = S_9\cdot S_{10} = (-6)\cdot(14) = (-84).
\end{aligned}
$$

Fourth, calculate the matrices $C$s.

$$
\begin{aligned}
& C_{11} = P_5 + P_4 - P_2 + P_6 = (-12) + (-30) - (8) + (6) = (-44), \\
& C_{12} = P_1 + P_2 = (6) + (4) = (10), \\
& C_{21} = P_3 + P_4 = (72) + (-30) = (42), \\
& C_{22} = P_5 + P_1 - P_3 -P_7 = (-12) + (6) - (72) - (-84) = (6).
\end{aligned}
$$

Therefore the result is

$$
\begin{pmatrix}
C_{11} & C{12} \\ C_{21} & C{22}
\end{pmatrix} =
\begin{pmatrix}
-44 & 10 \\ 42 & 6
\end{pmatrix}.
$$

---

## Question 2

>Use substitution to show that the solution of $T(n) = T(n-1) + n$ is $O(n^2)$.

Assuming for a constant $c>0$, we have $T(n)\le cn^2$, then obtains

$$
T(n)\le
c(n-1)^2 + n =
cn^2 + (1-2c)n + c^2 \le
cn^2,
$$

for constant $c>1/2$ and sufficiently large $n$.

Since $T(1) = 1 = 1^2$, the base case is satisfied.

Q.E.D.

---

## Question 3

>Use the master method to give tight asymptotic bounds for the following recurrences.
>
>**a.** $T(n) = 2T(n/4) + 1$.
>**b.** $T(n) = 2T(n/4) + \sqrt{n}$.
>**c.** $T(n) = 2T(n/4) + n$.
>**d.** $T(n) = 2T(n/4) + n^2$.

In these recurrences, $a = 2$ and $b = 4$, $n^{\log_ba} = \sqrt{n}$.

**a.** $\sqrt{n}$ is larger than $f(n)=1$, therefore $T(n)=\Theta(n^{\log_ba})=\Theta(\sqrt{n})$.

**b.** $\sqrt{n}$ is the same as $f(n)=\sqrt{n}$, therefore $T(n)=\Theta(f(n)\lg n)=\Theta(n)$.

**c.** $\sqrt{n}$ is smaller than $f(n)=n$, therefore $T(n)=\Theta(f(n))=\Theta(n)$.

**d.** $\sqrt{n}$ is smaller than $f(n)=n^2$, therefore $T(n)=\Theta(f(n))=\Theta(n^2)$.

---

## Question 4

>Professor Caesar wishes to develop a matrix-multiplication algorithm that is asymptotically faster than Strassen's algorithm. His algorithm will use the divide-and-conquer method, dividing each matrix into pieces of size $n/4\times n/4$, and the divide and combine steps together will take $\Theta(n^2)$ time. He needs to determine how many subproblems his algorithm has to create in order to beat Strassen's algorithm. If his algorithm creates $a$ subproblems, then the recurrence for the running time $T(n)$ becomes $T(n) = aT(n/4) + \Theta(n^2)$. What is the largest integer value of $a$ for which Professor Caesar's algorithm would be asymptotically faster than Strassen's algorithm?

We know that the running time of Strassen's algorithm is $\Theta(n^{\log7})$, therefore to overcome Strassen's algorithm, Prof. Caesar's algorithm must have

$$
n^{\log_4a} < n^{\lg7} \Rightarrow
\log_4a < \lg7\Rightarrow
\lg (a/2) < \lg7\Rightarrow
\sqrt{a} < 7\Rightarrow
a\le48
$$
