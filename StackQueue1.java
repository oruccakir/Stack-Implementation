import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Method 1 :
 * just make push operation costly 
 * by using two queue but in push operation
 * traversed two times to avoid that in
 * method 2 and method 3 swapping will be implemented
 */

public class StackQueue1 implements StackInterface{

    private Queue <Object> q1, q2;

    public StackQueue1(){

        q1 = new ArrayDeque<>();

        q2 = new ArrayDeque<>();

    }


    @Override
    public void push(Object data) {

        while(q1.isEmpty() == false){

            q2.add(q1.peek());

            q1.remove();

        }

        q1.add(data);

        while(q2.isEmpty() == false){

            q1.add(q2.peek());

            q2.remove();

        }
        
    }

    @Override
    public Object pop() {

        Object poppedElement = q1.poll();

        return poppedElement;

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
        
        StackQueue1 st = new StackQueue1();

        st.push(15);
        st.push(12);
        st.pop();

        System.out.println(st.pop());
        
        st.printStack();

    }
    
}
