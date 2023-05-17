public class Stack<T extends Comparable<T>> {
    private int size;

    private Node<T> start = null;
    private int howMany = 0;


    public Stack() {size = 5;
    }

    public Stack(int size) {
        this.size = size;
    }

    public T pop() throws StackException {
        if (start == null) {
            throw new StackException(size);
        }
        else {
            T data = start.getData();
            start = start.getNext();
            howMany--;
            return data;

        }
    }

    public void push (T item) throws StackException{
        if (howMany < size) {
            start = new Node <T> (item, start);
            howMany++;
        }
        else {
            throw new StackException(size);
        }
    }

}
