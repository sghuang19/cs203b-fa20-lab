# Exercise Week 1

---

## Question 1

>Give a real world example of a problem that requires sorting or a real world example that requires computing a convex hull.

- Arranging a given name list by age, income, or any other value requires sorting
- Finding a path for setting up isolating zone that surrounds a certain area requires computing convex hull

---

## Question 2

>Other than speed, what other measures of efficiency might one use in a real world setting?

- The time cost by computing
- The power consumption for running a certain task
- How expensive the computer would be in order to solve the problem in limited time

---

## Question 3

>How are the shortest path and travelling salesman problems similar? How are they different?

- The 2 problems are both about an efficient path
- shortest path is a P problem, TS problem is a NP problem

---

## Question 4

>Come up with a real-world problem in which only the best solution will do. Then come up with one in which a solution that is “approximately” the best is good enough.

- Since our processors are powerful enough, in most cases approximately best solution is enough
- In some cases, such as in medical or military area, efficiency may means life, so the best solution must be taken

---

## Question 5

For each function $f(n)$ and time $t$ in the following table, determine the largest size $n$ of a problem that can be solved in time $t$, assuming that the algorithm to solve the problem takes $f(n)$ microseconds.

![Question 5](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20200907210235-DSAA.png)

||1</br>second|1</br>minute|1</br>hour|1</br>day|1</br>month|1</br>year|1</br>century|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|$\lg n$|$10^{\left(10^6\right)}$|$10^{6\times 10^7}$|$10^{6\times 10^7}$|$10^{8.64\times10^{10}}$|$10^{2.59\times10^{12}}$|$10^{3.11\times10^{13}}$|$10^{3.11\times10^{15}}$|
|$\sqrt n$|$10^{12}$|$3.6\times10^{14}$|$\displaystyle{1.30\times10^{19}}$|$\displaystyle{7.46\times10^{21}}$|$\displaystyle{6.72\times10^{24}}$|$\displaystyle{9.95\times10^{26}}$|$\displaystyle{9.95\times10^{30}}$|
|$n$|$10^6$|$6\times10^7$|$3.6\times10^9$|$8.64\times10^{10}$|$2.59\times10^{12}$|$3.15\times10^{13}$|$3.15\times10^{15}$|
|$n\lg n$|$\displaystyle{1.89\times10^5}$|$\displaystyle{8.65\times10^6}$|$4.18\times10^8$|$8.69\times10^9$|$2.28\times10^{11}$|$2.54\times10^{12}$|$2.20\times10^{14}$|
|$n^2$|$10^3$|$7.75\times10^3$|$6\times10^4$|$2.94\times10^5$|$1.61\times10^6$|$5.62\times10^6$|$5.62\times10^7$|
|$n^3$|$10^2$|$3.91\times10^2$|$1.53\times10^3$|$4.42\times10^3$|$1.37\times10^4$|$3.16\times10^4$|$1.47\times10^5$|
|$2^n$|$19.93$|$25.84$|$31.75$|$36.33$|$41.24$|$44.84$|$51.49$|
|$n!$|$9$|$11$|$12$|$13$|$15$|$16$|$17$|
