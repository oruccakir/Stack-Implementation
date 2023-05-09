import java.util.Arrays;

public class Stack <T> implements StackInterface <T>{

    public Object[] stackArray;

    public int topIndex;

    public int size;

    public int capacity;

    public Stack(int capacity){

        this.capacity = capacity;
        stackArray = new Object[capacity];
        topIndex = capacity;

    }

    public Stack(){

        this.capacity = 16;
        stackArray = new Object[capacity];
        topIndex = capacity;

    }

    @Override
    public void push(T data) {

        try{

            if(topIndex == 0 && stackArray[topIndex] != null) throw new Exception();

            topIndex--;

            stackArray[topIndex] = data;

            size++;


        }
        catch(Exception e){

            System.err.println("Stack is Full ->> OVERFLOW ");

        }

        
       
    }

    @Override
    public T pop() {

       try{

          if(topIndex == capacity -1 && stackArray[topIndex] == null) throw new Exception();

          T data = (T) stackArray[topIndex];

          stackArray[topIndex] = null;

          topIndex++;

          size--;

          return data;

       }
       catch(Exception e){

          System.err.println("Stack is Empty ->>  UNDERFLOW ");

          return null;

       }
        
    }

    @Override
    public T peek() {

        try{

            if(topIndex == capacity -1 && stackArray[topIndex] == null) throw new Exception();

            return (T) stackArray[topIndex];


        }
        catch (Exception e){

            System.err.println("Stack is Empty ->> UNDERFLOW ");

            return null;

        }
       
    }

    @Override
    public boolean isEmpty() {

        return stackArray[capacity-1] == null;
        
    }

    @Override
    public int size() {

       return size;
        
    }

    @Override
    public void printStack() {

        for(int i=0; i<capacity; i++){

            System.out.print("[ ");

            if(stackArray[i] == null) System.out.print("------");

            else System.out.print("  "+stackArray[i]+"  ");

            System.out.println(" ]");

        }
        
    }

    @Override
    public Object[] toArray() {

        Object arr[] = new Object[size];

        int index = 0;

        for(int i=topIndex; i<capacity; i++){

            arr[index] = stackArray[i];
            index++;

        }

        return arr;

    }

    

    public static void main(String[] args) {

        
        
    }

}