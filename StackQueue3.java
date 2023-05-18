import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


/*
 * to improve method 1 swapping is implemented in pop and peek function
 * and peek and pop function is implemented costly
 */

public class StackQueue3 implements StackInterface {

    private Queue <Object> q1, q2;

    public StackQueue3(){

        q1 = new ArrayDeque<>();

        q2 = new ArrayDeque<>();

    }



    @Override
    public void push(Object data) {

        q1.add(data);

    }

    @Override
    public Object pop() {
        
        while(q1.size() != 1){

            q2.add(q1.poll());

        }

        Object popedElement = q1.poll();

        Queue <Object> temp = q1;

        q1 = q2;

        q2 = temp;

        return popedElement;

    }

    @Override
    public Object peek() {

        if(q1.size() == 0) return null;

        while(q1.size() != 1){

            q2.add(q1.poll());

        }

        Object peekElement = q1.poll();

        q2.add(peekElement);

        Queue <Object> temp = q1;

        q1 = q2;

        q2 = temp;

        return peekElement;
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
        System.out.println(Arrays.toString(this.toArray()));
    }

    @Override
    public Object[] toArray() {

        Object []tempArray = new Object[q1.size()];

        Object []realArray = q1.toArray();

        int index = 0;

        for(int i=realArray.length-1; i>=0; i--) {
            tempArray[index] = realArray[i];
            index++;
        }
        
        return tempArray;
    }

    public static void main(String[] args) {
        
        StackQueue3 st = new StackQueue3();

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