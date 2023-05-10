import java.util.EmptyStackException;

public class TwoStacks <T> {

    private Object[] stackArray;

    private int topIndex1, topIndex2;

    private int size;

    public TwoStacks(int capacity){

        this.size = capacity;
        stackArray = new Object[size];

        topIndex1=-1;
        topIndex2=size;

    }

    public void printStack(){

        System.out.print("[ ");
    
        for(int i=0; i<size; i++){

            if(stackArray[i] == null) System.out.print("--- ");

            else System.out.print(stackArray[i]+" ");

        }

        System.out.println("]");

    }

    public void push1(T data) throws StackOverflowError{

        if(topIndex1 == topIndex2 -1) throw new StackOverflowError();

        topIndex1++;

        stackArray[topIndex1] = data;

    }

    public void push2(T data){

        if(topIndex1 == topIndex2 -1) throw new StackOverflowError();

        topIndex2--;

        stackArray[topIndex2] = data;

    }

    public T pop1() throws EmptyStackException{

        if(topIndex1 == -1) throw new EmptyStackException();

        T data = (T)stackArray[topIndex1];

        stackArray[topIndex1] = null;

        topIndex1--;
        
        return data;

    }

    public T pop2() throws EmptyStackException{

        if(topIndex2 == size) throw new EmptyStackException();

        T data = (T) stackArray[topIndex2];

        stackArray[topIndex2] = null;

        topIndex2++;

        return data;

    }

    public T peek1() throws EmptyStackException{

        if(topIndex1 == -1) throw new EmptyStackException();

        return (T) stackArray[topIndex1];

    }

    public T peek2(){

        if(topIndex2 == size) throw new EmptyStackException();

        return (T) stackArray[topIndex2];
    }
    
    public boolean isEmpty(){

        if(topIndex1 == -1 && topIndex2 == size) return true;

        return false;
    }

    public int size (){
        return (topIndex1+1) + (size - topIndex2);
    }

    public static void main(String[] args) {
        
        TwoStacks<Integer> ts = new TwoStacks<>(10);

        ts.push1(12);
        ts.push2(89);
        ts.push1(18);
        ts.push1(14);
        ts.push1(9);
        ts.push1(-10);
        ts.push2(48);
        ts.push2(12);
        ts.push2(45);
        ts.push1(78);
        ts.push1(19);

        ts.printStack();
        System.out.println("Size : "+ts.size());
        //System.out.println("Peek 1 : "+ts.peek1());
        //System.out.println("Peek 2 : "+ts.peek2());

    }

    
}
