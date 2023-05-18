import java.util.ArrayDeque;
import java.util.Queue;


/*
 * This another approach to implement stack with one
 * queue but using recursion stack or stack data structure
 */

public class StackQueue4 implements StackInterface {

    private Queue <Object> q1;

    public StackQueue4(){

        q1 = new ArrayDeque<>();

    }

    public void iterativeReverse(){

        Stack<Object> st = new Stack<>();

        while(q1.isEmpty() == false) st.push(q1.poll());

        while(st.isEmpty() == false) q1.add(st.pop());

    }

    public void recursionReverse(){

        if(q1.isEmpty()) return;

        Object element = q1.poll();

        recursionReverse();

        q1.add(element);

    }


    @Override
    public void push(Object data) {
        q1.add(data);
    }





    @Override
    public Object pop() {
        
        iterativeReverse();

        Object poppedElement = q1.poll();

        iterativeReverse();

        return poppedElement;

    }





    @Override
    public Object peek() {

        iterativeReverse();

        Object element = q1.peek();

        iterativeReverse();

        return element;
        
    }





    @Override
    public boolean isEmpty() {
       return q1.isEmpty();
    }





    @Override
    public int size() {
        return q1.size();
    }





    @Override
    public void printStack() {
        
        recursionReverse();

        System.out.println(q1);

        iterativeReverse();

    }





    @Override
    public Object[] toArray() {

        recursionReverse();

        Object temp[] = q1.toArray();

        iterativeReverse();

        return temp;
        
    }

    public static void main(String[] args) {
        
        StackQueue4 st = new StackQueue4();

        st.push(15);
        st.push(16);
        
        st.push(18);

        st.pop();
        st.pop();

        

        st.printStack();

        System.out.println(st.peek());

    }
    
}
