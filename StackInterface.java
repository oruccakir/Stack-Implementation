public interface StackInterface <T>{

    public void push(T data);

    public T pop();

    public T peek();

    public boolean isEmpty();

    public int size();

    public void printStack();

    public Object[] toArray();
    
}
