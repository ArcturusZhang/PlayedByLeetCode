import java.util.LinkedList;
import java.util.Queue;

public class StackSolution extends MyStack {
    private Queue<Integer> stack;
    private Queue<Integer> support;
    public StackSolution() {
        stack = new LinkedList<>();
        support = new LinkedList<>();
    }

    @Override
    public void push(int x) {
        stack.offer(x);
    }

    @Override
    public int pop() {
        int x = 0;
        while (!stack.isEmpty()) {
            x = stack.poll();
            if (!stack.isEmpty()) support.offer(x);
        }
        while (!support.isEmpty()) {
            stack.offer(support.poll());
        }
        return x;
    }

    @Override
    public int top() {
        int x = 0;
        while (!stack.isEmpty()) {
            x = stack.poll();
            support.offer(x);
        }
        while (!support.isEmpty()) {
            stack.offer(support.poll());
        }
        return x;
    }

    @Override
    public boolean empty() {
        return stack.isEmpty();
    }
}
