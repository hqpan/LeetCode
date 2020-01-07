[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 155
- 使用辅助栈，且与数据栈同步：
  - `push(), pop(), peek(), getMin()`等操作的时间复杂度：$O(1)$；
  - 空间复杂度：$O(n)$；
- 使用辅助栈，不与数据栈同步：
  - `push(), pop(), peek(), getMin()`等操作的时间复杂度：$O(1)$；
  - 空间复杂度：$O(n)$；
- 单个栈：
  - `push(), pop(), peek(), getMin()`等操作的时间复杂度：$O(1)$；
  - 空间复杂度：$O(n)$；
- 链表：
  - `push(), pop(), peek(), getMin()`等操作的时间复杂度：$O(1)$；
  - 空间复杂度：$O(n)$；

# 2. 使用辅助栈：与数据栈同步
- 解题思路：
  - 数据栈中存放入栈的所有数据；
  - 辅助栈中存放当前栈中的最小值；

```java
class MinStack {
    private Stack<Integer> nums;
    private Stack<Integer> min;

    public MinStack() {
        nums = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        if (nums.isEmpty() || min.peek() >= x)
            min.push(x);
        else
            min.push(min.peek());
        nums.push(x);
    }
    
    public void pop() {
        if (!nums.isEmpty())
        {
            nums.pop();
            min.pop();
        }    
    }
    
    public int top() {
        if (!nums.isEmpty())
            return nums.peek();
        throw new RuntimeException("The stack is empty.");        
    }
    
    public int getMin() {
        if (!nums.isEmpty())
            return min.peek();
        throw new RuntimeException("The stack is empty");        
    }
}
```

# 3. 使用辅助栈：不与数据栈同步
- 解题思路：
  - 数据栈中存放入栈的所有数据；
  - 辅助栈中存放当前栈中的最小值，与上一种方法的差别如下：
    - 辅助栈与数据栈同步：无论最小值是否发生变化，均需将当前最小值入栈；
    - 辅助栈与数据栈不同步：仅当最小值发生变化时，才将新的最小值入栈；
- 难点：
  - 栈中存放的是`Integer`对象，非基本数据类型的比较应使用`equals()`，不能使用`==`；

```java
class MinStack {
    private Stack<Integer> nums;
    private Stack<Integer> min;

    public MinStack() {
        nums = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        if (nums.isEmpty() || min.peek() >= x)
            min.push(x);
        nums.push(x);
    }
    
    public void pop() {
        if (!nums.isEmpty())
            if (nums.pop().equals(min.peek())) 
                min.pop();
    }
    
    public int top() {
        if (!nums.isEmpty())
            return nums.peek();
        throw new RuntimeException("The stack is empty.");        
    }
    
    public int getMin() {
        if (!nums.isEmpty())
            return min.peek();
        throw new RuntimeException("The stack is empty.");        
    }
}
```

# 4. 使用单个栈
- 解题思路：
  - 声明一个整型变量`min`存放当前栈中的最小值；
  - 入栈：
	- 若待处理的值大于`min`，则直接入栈；
	- 若待处理的值小于等于`min`，则先将当前的`min`入栈，再将待处理的值入栈，同时更新`min`；
  - 出栈：
    - 若待处理的值不等于`min`，则直接出栈；
    - 若待处理的值等于`min`，则先将该值出栈，再将栈中的下一个值弹出，用于更新`min`；
- 难点：
  - 注意程序中的`pop()`方法；
  - 若`if`语句判断条件中的`pop()`方法被执行，则将一个值出栈；
  - `if`语句块中的`pop()`方法弹出栈中的第二个值；

```java
// twice pop;
    public void pop() {
        if (!nums.isEmpty() && nums.pop() == min)
            min = nums.pop();       
    }
```

- Solution：
```java
class MinStack {
    private Stack<Integer> nums;
    private int min;

    public MinStack() {
        nums = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min)
        {
            nums.push(min);
            min = x;
        }
        nums.push(x);
    }
    
    public void pop() {
        if (!nums.isEmpty() && nums.pop() == min)
            min = nums.pop();       // twice pop;
    }
    
    public int top() {
        if (!nums.isEmpty())
            return nums.peek();
        throw new RuntimeException("The stack is empty.");
    }
    
    public int getMin() {
        if (!nums.isEmpty())
            return min;
        throw new RuntimeException("The stack is empty.");
    }
}
```

# 5. 链表
- 解题思路：创建一个`Node`类，每个节点中存放待处理的值和当前最小值；
- 难点：创建一个新的节点作为`head`节点；
```java
// 创建一个新的节点作为`head`节点
Node temp = new Node(x, Math.min(head.min, x));
temp.next = head;
head = temp;
```

- Solution：
```java
class MinStack {
    public class Node {
        private int value;
        private int min;
        private Node next;

        public Node() {}

        public Node(int value, int min)
        {
            this.value = value;
            this.min = min;
            next = null;
        }
    }

    private Node head;

    public MinStack() {}
    
    public void push(int x) {
        if (head == null)
            head = new Node(x, x);
        else {
            Node temp = new Node(x, Math.min(head.min, x));
            temp.next = head;
            head = temp;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        if (head == null)
            throw new RuntimeException("The stack is empty.");
        return head.value;
    }
    
    public int getMin() {
        if (head == null)
            throw new RuntimeException("The stack is empty.");
        return head.min;
    }
}
```

# References
[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.