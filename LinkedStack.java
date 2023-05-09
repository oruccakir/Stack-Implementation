

public class LinkedStack <T>implements StackInterface <T> {

    public Node head;
    public int size;

    public LinkedStack(){

        this.head = null;

        this.size = 0;

    }


    private class Node{

        public T data;
        public Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        public String toString(){
            return ""+data;
        }

    }


    @Override
    public void push(T data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        size++;
       
    }

    @Override
    public T pop() {

        try{

            if(head == null) throw new Exception();

            T data = head.data;

            head = head.next;

            size--;
       
            return data;

        }
        catch(Exception e){

            System.err.println("Stack is Empty ->> UNDERFLOW ");

            return null;

        }

        
    }

    @Override
    public T peek() {

        try{

            if(head == null) throw new Exception();
       
            return head.data;

        }
        catch(Exception e){

            System.err.println("Stack is Empty ->> UNDERFLOW ");

            return null;

        }

    }

    @Override
    public boolean isEmpty() {
       return head== null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printStack() {

        Node temp = head;

        if(temp == null) System.out.println("[ ]");

        while(temp != null){

            System.out.println("[ "+temp.data+" ]");

            temp = temp.next;

        }

        
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    public static void main(String[] args) {

        LinkedStack<Integer> linkedStack = new LinkedStack<>();

        linkedStack.push(121);
        linkedStack.push(15);
        linkedStack.push(17);
        linkedStack.push(89);
        
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();

        linkedStack.printStack();

        System.out.println(linkedStack.isEmpty());
        System.out.println(linkedStack.size);

        System.out.println(linkedStack.peek());


        
        
    }
    
}
