# Exercise Week 3

## Question 1

Dictionary can be implemented by defining both `key` and `value` field in node class. For insert, delete and search, the worst case running time should all be $n$, which is the length of the list, and the best case running time should all be $1$.

## Question 2

Define two stack as `inbox` and `outbox`.

- Enqueue

Simply push the new element onto `inbox`.

- Dequeue
  - If `outbox` is empty, refill it by popping each element from `inbox`and pushing it onto `outbox`. If `inbox` is empty, do this in reverse way.
  - return the top element from `outbox` (or `inbox`)

The running time for enqueue is just $1$, for dequeue is $n + 1$, in which $n$ is the number of elements existed in the stack.

## Question 3

Let $h(n) = \Theta(f(n) + g(n))$, therefore, asymptotically we have

$$
\begin{aligned} &
\left\{\begin{aligned}
h(n) = O(f(n) +g(n)) \Leftrightarrow
h(n) \le c_1[f(n) + g(n)] \Rightarrow
h(n) \le c_1[\max(f(n), g(n))] \Leftrightarrow
h(n) = O(\max(f(n), g(n)))\\
h(n) = \Omega(f(n) +g(n)) \Leftrightarrow
h(n) \ge c_2[f(n) + g(n)] \Rightarrow
h(n) \ge c_2[\max(f(n), g(n))] \Leftrightarrow
h(n) = \Omega(\max(f(n), g(n)))
\end{aligned}\right. \\ \Rightarrow &
h(n) = \Theta(f(n) + g(n)) = \max(f(n), g(n)).
\end{aligned}
$$

Q.E.D.

## Question 4

>Explain why the statement, "the running time of algorithm A is at least $O(n^2)$", is meaningless.

Big $O$ notation indicates the upper bound of a function, so the statement is not valid.

## Question 5

|A|B|$O$|$o$|$\Omega$|$\omega$|$\Theta$|
|-|-|-|-|-|-|-|
|$\lg^k n$|$n^\epsilon$|yes|yes|no|no|no|
|$n^k$|$c^n$|yes|yes|no|no|no|
|$\sqrt{n}$|$n^{\sin n}$|no|no|yes|yes|no|
|$n^{\lg c}$|$c^{\lg n}$|yes|no|yes|no|yes|
|$\lg(n!)$|$\lg(n^n)$|yes|no|yes|no|yes|
