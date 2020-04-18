// Approach 1: 使用辅助栈：与数据栈同步
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

// Approach 2: 使用辅助栈：不与数据栈同步
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

// Approach 3: 使用单个栈
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

// Approach 4: 链表
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

