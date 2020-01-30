[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 225
## 1.1 复杂度分析
- 两个队列：
  - push：
    - 时间复杂度：$O(n)$；
    - 空间复杂度：$O(1)​$；
  - pop：
    - 时间复杂度：$O(1)$；
    - 空间复杂度：$O(1)$；
  - peek：
    - 时间复杂度：$O(1)$；
    - 空间复杂度：$O(1)$；
  - empty：
    - 时间复杂度：$O(1)​$；
    - 空间复杂度：$O(1)​$；
- 单个队列：
  - push：
    - 时间复杂度：$O(n)$；
    - 空间复杂度：$O(1)$；
  - pop：
    - 时间复杂度：$O(1)$；
    - 空间复杂度：$O(1)$；
  - peek：
    - 时间复杂度：$O(1)$；
    - 空间复杂度：$O(1)$；
  - empty：
    - 时间复杂度：$O(1)$；
    - 空间复杂度：$O(1)$；



## 1.2 两个队列
- 解题思路：
  - queue1 保存当前所有元素；
  - push：将元素添加到 queue1 中；
  - pop & peek：除最后一个元素之外的所有元素，添加到 queue2 中，再交换两个队列的引用；
  - empty：检测 queue1 的大小即可；
- 难点：
  - Q1：两种方法的区别？
    - Approach 1：将 queue2 中的所有元素重新添加到 queue1 中；
    - Approach 2：交换两个队列的引用；
  - A1：Approach 2 效率更高；

```java
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return queue2.poll();
    }
    
    /** Get the top element. */
    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int ans = queue1.poll();
        queue2.add(ans);
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return ans;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
```



## 1.3 单个队列

- 解题思路：
  - queue 保存当前所有元素；
  - push：将元素添加到 queue 中，然后将队列中的 n-1 个元素删除后重新添加到队列中，实现所有元素逆序存放；
  - pop & peek：队列的第一个元素即为所求；
  - empty：检测 queue 的大小即可；
- 难点：push 方法的实现；

```java
class MyStack {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = queue.size() - 1; i > 0; i--)
            queue.add(queue.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
```



# 2. LeetCode 232

## 2.1 复杂度分析
- LeetCode 232 和 225 对比：
  - LeetCode 225：用队列实现栈，用单个队列或两个队列均可；
  - LeetCode 232：用栈实现队列，用两个栈实现；
- 两个栈：
  - push：
    - 时间复杂度：$O(1)​$；
    - 空间复杂度：$O(n)​$；
  - pop：
    - 时间复杂度：$O(n)​$；
    - 空间复杂度：$O(1)$；
  - peek：
    - 时间复杂度：$O(n)​$；
    - 空间复杂度：$O(1)​$；
  - empty：
    - 时间复杂度：$O(1)​$；
    - 空间复杂度：$O(1)​$；



## 2.2 两个栈

- 解题思路：
  - stack1 保存当前所有元素；
  - push：将新元素添加到 stack1 中；
  - pop & peek：将 stack1 中的所有元素添加到 stack2 中，实现栈中现有元素的逆序排放；
  - empty：检测 stack1 的大小即可；
- 难点：
  - Q1：两种方法的区别？
    - Approach 1：每次 push 新元素时，将栈中所有元素逆序存放；
    - Approach 2：仅当执行 pop、peek 操作时，将栈中所有元素逆序存放；
  - A1：Approach 2 能减少不必要的操作；

```java
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
```



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.