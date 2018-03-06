import java.util.Stack;

public class QueueSolution extends MyQueue {
    private Stack<Integer> queue;
    private Stack<Integer> support;
    public QueueSolution() {
        queue = new Stack<>();
        support = new Stack<>();
    }

    @Override
    public void push(int x) {
        queue.push(x);
    }

    @Override
    public int pop() {
        int x = 0;
        while (!queue.isEmpty()) {
            x = queue.pop();
            if (!queue.isEmpty()) support.push(x);
        }
        while (!support.isEmpty()) {
            queue.push(support.pop());
        }
        return x;
    }

    @Override
    public int peek() {
        int x = 0;
        while (!queue.isEmpty()) {
            x = queue.pop();
            support.push(x);
        }
        while (!support.isEmpty()) {
            queue.push(support.pop());
        }
        return x;
    }

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }
}
