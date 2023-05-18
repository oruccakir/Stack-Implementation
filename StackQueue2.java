import java.util.ArrayDeque;
import java.util.Queue;


/*
 * to improve method 1 swapping is implemented in push function
 * and push function is implemented costly
 */

public class StackQueue2 implements StackInterface {

    private Queue <Object> q1, q2;

    public StackQueue2(){

        q1 = new ArrayDeque<>();

        q2 = new ArrayDeque<>();

    }



    @Override
    public void push(Object data) {

        q2.add(data);

        while(q1.isEmpty() == false){

            q2.add(q1.poll());

        }

        Queue<Object> temp = q1;

        q1 = q2;

        q2 = temp;

        
    }

    @Override
    public Object pop() {
        return q1.poll();
    }

    @Override
    public Object peek() {
        return q1.peek();
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
        System.out.println(q1);
    }

    @Override
    public Object[] toArray() {
        return q1.toArray();
    }

    public static void main(String[] args) {
        
        StackQueue2 st = new StackQueue2();

        st.push(15);
        st.push(16);
        
        st.push(18);

        st.pop();
        st.pop();
        st.pop();

        st.printStack();

        System.out.println(st.peek());

    }
    
}
