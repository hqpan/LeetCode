/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// Approach 1: 二重循环
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node res = new Node(head.val);
        Node currHead = head;
        Node currRes = res;
        while (currHead.next != null) {
            currRes.next = new Node(currHead.next.val);
            currHead = currHead.next;
            currRes = currRes.next;
        }
        currHead = head;
        currRes = res;
        while (currHead != null) {
            Node nodeHead = head;
            Node nodeRes = res;
            if (currHead.random == null)
                currRes.random = null;
            else {
                while (!nodeHead.equals(currHead.random)) {
                    nodeHead = nodeHead.next;
                    nodeRes = nodeRes.next;
                }
                currRes.random = nodeRes;
            }
            currHead = currHead.next;
            currRes = currRes.next;
        }
        return res;
    }
}

// Approach 2: 哈希表
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node res = new Node(head.val);
        Node currHead = head;
        Node currRes = res;
        HashMap<Node, Node> st = new HashMap<>();
        while (currHead.next != null) {
            currRes.next = new Node(currHead.next.val);
            st.put(currHead, currRes);   // take notes
            currHead = currHead.next;
            currRes = currRes.next;
        }
        st.put(currHead,currRes);
        currHead = head;
        currRes = res;
        while (currHead != null) {
            currRes.random = st.get(currHead.random);
            currHead = currHead.next;
            currRes = currRes.next;
        }
        return res;
    }
}

// Approach 3: 复制、拆分链表
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        copy(head);
        link(head);
        return split(head);
    }

    public void copy(Node head) {
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = curr.next.next;
        }
    }

    public void link(Node head) {
        Node curr = head;
        while (curr != null) {
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }
    }

    public Node split(Node head) {
        Node res = head.next;
        Node currHead = head;
        Node currRes = res;
        while (currRes.next != null) {
            currHead.next = currHead.next.next;
            currRes.next = currRes.next.next;
            currHead = currHead.next;
            currRes = currRes.next;
        }
        currHead.next = null;
        currRes.next = null;
        return res;
    }
}