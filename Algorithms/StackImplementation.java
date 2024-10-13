import java.util.Stack;

public class MinMaxStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;

    public MinMaxStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }

    // Push element x onto the stack
    public void push(int x) {
        mainStack.push(x);

        // Push into minStack if it's empty or the current element is less than or equal to the top of minStack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }

        // Push into maxStack if it's empty or the current element is greater than or equal to the top of maxStack
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    // Removes the element on top of the stack
    public void pop() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        int poppedElement = mainStack.pop();

        // If the popped element is the same as the top of minStack, pop from minStack
        if (poppedElement == minStack.peek()) {
            minStack.pop();
        }

        // If the popped element is the same as the top of maxStack, pop from maxStack
        if (poppedElement == maxStack.peek()) {
            maxStack.pop();
        }
    }

    // Get the top element of the stack
    public int peek() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return mainStack.peek();
    }

    // Retrieve the minimum element in constant time
    public int min() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return minStack.peek();
    }

    // Retrieve the maximum element in constant time
    public int max() {
        if (maxStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return maxStack.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public static void main(String[] args) {
        MinMaxStack stack = new MinMaxStack();
        
        // Push elements onto the stack
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(1);
        
        // Retrieve the minimum and maximum
        System.out.println("Minimum: " + stack.min());  // Output: 1
        System.out.println("Maximum: " + stack.max());  // Output: 7
        
        // Pop the top element
        stack.pop();  // Popped element is 1
        System.out.println("Minimum after pop: " + stack.min());  // Output: 3
        System.out.println("Maximum after pop: " + stack.max());  // Output: 7
        
        // Pop another element
        stack.pop();  // Popped element is 7
        System.out.println("Minimum after pop: " + stack.min());  // Output: 3
        System.out.println("Maximum after pop: " + stack.max());  // Output: 5
    }
}
