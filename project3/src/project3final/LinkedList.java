public class LinkedList<T extends Comparable<T>> implements List<T> {
    private boolean isSorted = true;
    private Node<T> data;
    private Node<T> tail;
    private Node<T> ptr;
    private int size = 0;
    public LinkedList() {
        data = null;
        tail = null;

    }
    public boolean add(T element) {
        if (element != null) {
            if (data == null) {
                data = new Node<T>(element, data);
                tail = data;
                size += 1;
            }
            else {
                tail.setNext(new Node<T>(element, null));
                tail = tail.getNext();
                size += 1;
            }
            return true;
        }
        return false;
    }

    public boolean add(int index, T element) {
        ptr = data;
        T[] temp = (T[]) new Comparable[2];
        if (element != null && index >= 0 && index < size) {
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    temp[0] = ptr.getData();
                    ptr.setData(element);
                    if (i == size - 1) {
                        ptr.setNext(new Node<T>(temp[0]));
                    }
                }
                else if (i > index) {
                    temp[1] = ptr.getData();
                    ptr.setData(temp[0]);
                    temp[0] = temp[1];
                    if (i == size - 1) {
                        ptr.setNext(new Node<T>(temp[0]));
                    }
                }
                ptr = ptr.getNext();
                tail = ptr;
            }
            size += 1;
            return true;
        }
        return false;
    }

    public void clear() {
        data = null;
        tail = null;
        size = 0;
    }

    public T get(int index) {
        ptr = data;
        if (index < 0 || index >= size) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            ptr = ptr.getNext();
        }
        if (ptr != null) {
            return ptr.getData();
        }
        return null;

    }

    public int indexOf(T element) {
        return 0;
    }

    public boolean isEmpty() {
        return data == null;
    }

    public int size() {
        return size;
    }

    public void sort() {

    }

    public T remove(int index) {
        return null;
    }

    public void equalTo(T element) {

    }

    public void reverse() {

    }

    public void merge(List<T> otherList) {

    }

    public boolean rotate(int n) {
        return false;
    }

    public boolean isSorted() {
        return isSorted;
    }

//    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        list.add(5);
//        list.add(3);
//        list.add(100);
//    }
}
