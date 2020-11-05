# Pt. 1 Foundation

## Data Structures

A way to store and organize data in order to facilitate access and modifications.

- Insert
- Search
- Delete

>No single data structure works well for all purposes.
>It is necessary to know the strengths and limitations of each one.

| Data Structures | Advantages | Disadvantages |
|-|-|-|
| Array | Quick insertion, very fast access if index known | Slow search, slow deletion, fixed size |
|Ordered array | Quicker search than unsorted array | Slow insertion and deletion, fixed size |
| Stack | Provides last-in, first-out access | Slow access to other items |
| Queue | Provides first-in, first-out access| Slow access to other items |
| Linked list | Quick insertion, quick deletion| Slow search |
| Binary tree | Quick search, insertion, deletion| Deletion algorithm is complex |
| Graph | Models real-world situations | Some algorithms are slow and complex |
| Hashing | quick search, insertion and deletion | Collision |

---

## Algorithm

A sequence of instructions with clear semantics for solving a particular information processing problems, realizable based on a set computing model.

- Unambiguous
- Input/Output
- Correctness
- Finiteness
- Feasibility
- Independent

---

## Asymptotic Notation

| Asymptotic Notation | Similar to |
| :-----------------: | :--------: |
| $O$ | $\le$|
|$\Omega$ | $\ge$|
|$\Theta$ |$=$ |
| $o$ |$<$ |
|$\omega$ |$>$ |

>More on asymptotic notation:
>[Asymptotic notation @Khan Academy](https://www.khanacademy.org/computing/computer-science/algorithms/asymptotic-notation/a/asymptotic-notation)
>[算法复杂度的渐近表示法（详细版） @逆向菜鸟](https://blog.csdn.net/corivSky/article/details/2772004)
>[算法导论学习-渐进表达式 @Meiyoumingzilema](https://blog.csdn.net/zhangguoxiang1987/article/details/35633473)
---

## Proof by Induction

- Prove a **base case**: establish a theorem is true for some small numbers
- **Inductive hypothesis**: assume the theorem is true for all cases to $k$
- Given this assumption, show the theorem is true for $k+1$

Also

- Direct proof
- Proof by contradiction

---

## Pseudocode

>See pages 22-24 in text book.

- Indenting indicates block structure
- Loop variable in `for` loop is **still defined** when the loop exists
- `//` indicates comment.
- For an attribute `attr` of object `x`, write `x.attr`.
- This can be cascaded, for example, `x.y.attr`, and is with implicitly parenthesis `(x.y).attr`.
- **Objects** are treated as **references**.
- **Parameters** are passed by **value**.
- The boolean operators `and` and `or` are **short-circuiting**.
