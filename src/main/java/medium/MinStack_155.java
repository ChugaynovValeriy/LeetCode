package medium;

// https://leetcode.com/problems/simplify-path/

public class MinStack_155 {
    private static class MinStack {
        private static final int INITIAL_SIZE = 10;
        private int size = 0;
        private int[] stack;
        private int minIndex = 0;

        public MinStack() {
            stack = new int[INITIAL_SIZE];
        }

        public void push(int val) {
            if (size == stack.length) {
                int[] copied = new int[(int) (stack.length * 1.5)];
                System.arraycopy(stack, 0, copied, 0, size);
                stack = copied;
            }
            stack[size] = val;
            if (val < stack[minIndex]) {
                minIndex = size;
            }
            size++;
        }

        public void pop() {
            size--;
            if (size == minIndex) {
                int min = size > 0 ? stack[0] : 0;
                minIndex = 0;
                for (int i = 1; i < size; i++) {
                    if (stack[i] < min) {
                        minIndex = i;
                        min = stack[i];
                    }
                }
            }
        }

        public int top() {
            return stack[size - 1];
        }

        public int getMin() {
            return size > 0 ? stack[minIndex] : Integer.MIN_VALUE;
        }

    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(395);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(276);
        minStack.push(29);
        System.out.println(minStack.getMin());
        minStack.push(-482);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(-108);
        minStack.push(-251);
        System.out.println(minStack.getMin());
        minStack.push(-439);
        System.out.println(minStack.top());
        minStack.push(-370);
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
