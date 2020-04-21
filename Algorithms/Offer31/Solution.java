class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int pushNum : pushed) {
            stack.push(pushNum);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                ++index;
            }
        }
        return stack.isEmpty();
    }
}