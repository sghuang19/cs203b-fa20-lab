# Exercise Week 4

## Question 1

![Pic](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20201007111606.png)

## Question 2

![Pic](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20201007115558.png)

## Question 3

Firstly, define function to verify if the deque is empty or full.

```java
QUEUE-EMPTY(Q)
    if Q.head == Q.tail
        return true
    else return false
```

```java
QUEUE-FULL(Q)
    if Q.head == Q.tail + 1 or (Q.head == 1 and Q.tail == Q.length)
        return true
    else return false
```

- For inserting elements

```java
HEAD-ENQUEUE(Q, x)
    if QUEUE-FULL(Q)
        error "overflow"
    else
        if Q.head == 1
            Q.head = Q.length
        else Q.head = Q.head - 1
        Q[Q.head] = x
```

```java
TAIL-ENQUEUE(Q, x)
    if QUEUE-FULL(Q)
        error "overflow"
    else
        Q[Q.tail] = x
        if Q.tail == Q.length
            Q.tail = 1
        else Q.tail = Q.tail + 1
```

- For deleting elements

```java
HEAD-DEQUEUE(Q)
    if QUEUE-EMPTY(Q)
        error "underflow"
    else
        x = Q[Q.head]
        if Q.head == Q.length
            Q.head = 1
        else Q.head = Q.head + 1
        return x
```

```java
TAIL-DEQUEUE(Q)
    if QUEUE-EMPTY(Q)
        error "underflow"
    else
        if Q.tail == 1
            Q.tail = Q.length
        else Q.tail = Q.tail - 1
        x = Q[Q.tail]
        return x
```

## Question 4

- When `enqueue`, push the element to be enqueued into the stack storing elements. Which takes running time of $O(1)$.
- When `dequeue`, pop each element and push them into another stack one by one, then obtain the top element in the stack. Which takes running time of $O(n)$.

## Question 5

- When `push`, enqueue the element to be pushed into the queue storing elements. Which takes running time of $O(1)$.
- When `pop`, dequeue each element and enqueue them into another queue one by one, then dequeue the element in the queue. Which takes running time of $O(n)$.
