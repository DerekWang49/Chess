public class ArrayList<T extends Comparable<T>> implements List<T> {
    private boolean isSorted = true;
    private int pointer;
    private int size;
    T[] a = (T[]) new Comparable[2];

    public ArrayList() {
        size = 0;
    }

    public boolean add(T element) {
        // Add element to end of list
        //T[] arraySpace = (T[]) new Comparable[size * 2];
        if (element != null) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == null) {
                    a[i] = element;
                    if (i == 0) {
                        isSorted = true;
                    }
                    else if (i != a.length - 1) {
                        if (a[i+1] != null) {
                            if (a[i].compareTo(a[i+1]) > 0 || a[i].compareTo(a[i-1]) < 0) {
                                isSorted = false;
                            }
                        }
                        else {
                            if (a[i].compareTo(a[i-1]) < 0) {
                                isSorted = false;
                            }
                        }
                    }

                    else if (i == a.length - 1) {
                        if (a[i].compareTo(a[i-1]) < 0) {
                            isSorted = false;
                        }
                    }
                    size += 1;
                    return true;
                }
            }
            T[] temp = (T[]) new Comparable[a.length * 2];
            for (int i = 0; i < a.length; i++) {
                temp[i] = a[i];
            }
            temp[size] = element;
            size += 1;
            a = temp;
            if (a[size - 1].compareTo(a[size - 2]) < 0) {
                isSorted = false;
            }
            return true;
        }
        return false;

    }

    public boolean add(int index, T element) {
        T[] temp;
//        if (element != null && index >= 0 && index < size && size < a.length) {
//            for (int i = 0; i < a.length; i++) {
//                if (i == index) {
//                    temp[0] = a[i];
//                    a[i] = element;
//                }
//
//                if (i > index) {
//                    temp[1] = a[i];
//                    a[i] = temp[0];
//                    temp[0] = temp[1];
//                }
//
//
//            }
//            size += 1;
//            return true;
//        }
        if (element != null && index >= 0 && index < size) {
            if (size < a.length) {
                temp = (T[]) new Comparable[a.length];
            }
            else {
                temp = (T[]) new Comparable[a.length * 2];
            }

            for (int i = 0; i < a.length; i++) {
                if (i < index) {
                    temp[i] = a[i];
                }
                if (i == index) {
                    temp[i] = element;
                }

                if (i > index) {
                    temp[i] = a[i-1];
                }

            }
            size += 1;
            a = temp;
            return true;
        }
        return false;
    }

    public void clear() {
//        for (int i = 0; i < size; i++) {
//            a[i] = null;
//            size = 0;
//        }
        a = (T[]) new Comparable[2];
        size = 0;
        isSorted = true;
    }

    public T get(int index) {
        if (index < size && index >= 0) {
            if (a[index] == null) {
                System.out.println(index);
                System.out.println("Test");
            }
            return a[index];
        }
        return null;
    }

    public int indexOf(T element) {
        if (isSorted) {
            // WIP
            for (int i = 0; i < a.length; i++) {
                if (a[i] == element && a[i] != null) {
                    return i;
                }
            }
            return -1;
        }
        else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == element && a[i] != null) {
                    return i;
                }
            }
            return -1;
        }
    }

    public boolean isEmpty() {
        return a[0] == null;
    }

    public int size() {
        return size;
    }

    public void sort() {
        if (!isSorted) {
            for (int i = 1; i < a.length; i++) {
                if (a[i-1] != null && a[i] != null) {
                    if (a[i-1].compareTo(a[i]) > 0) {
                        T temp = a[i-1];
                        a[i-1] = a[i];
                        a[i] = temp;
                    }
                }
            }
            isSorted = true;
        }
    }

    public T remove(int index) {
        if (index >= a.length || index < 0) {
            return null;
        }
        else {
            T returnEle = null;
            for (int i = 0; i < a.length - 1; i++) {
                if (i == index) {
                    returnEle = a[index];
                    a[i] = a[i + 1];
                } else if (i > index) {
                    a[i] = a[i + 1];
                }
            }
            size -= 1;
            return returnEle;

        }


    }

    public void equalTo(T element) {
        for (int i = 0; i < size; i++) {
            while (a[i] != element) {
                if (a[i] == null) {
                    break;
                }
                for (int j = 0; j < size; j++) {
                    if (j >= i) {
                        if (j != size - 1) {
                            a[j] = a[j+1];
                        }

                        else {
                            a[j] = null;
                            size -= 1;
                        }

                    }
                }
            }

        }
//        for (int i = 0; i < a.length; i++) {
//            while (a[i] != element) {
//                for (int j = i; j < a.length - size; j++ ) {
//                        if (j < a.length - size - 1) {
//                            a[i + j] = a[i + j + 1];
//                        }
//                        else {
//                            a[i + j] = null;
//                        }
//                    }
//                size -= 1;
//            }
//
//        }
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            T temp = a[i];
            a[i] = a[size - 1 - i];
            a[size - 1 - i] = temp;
        }
    }

    public void merge(List<T> otherList) {
        if (otherList != null) {
            ArrayList<T> other = (ArrayList<T>) otherList;
            sort();
            other.sort();
            int thisCounter = 0;
            int otherCounter = 0;
            T[] temp = (T[]) new Comparable[size + other.size()];
            size += other.size();
            for (int i = 0; i < size; i++) {
                if (a[thisCounter] != null && other.a[otherCounter] != null) {
                    if (a[thisCounter].compareTo(other.a[otherCounter]) < 0) {
                        temp[i] = a[thisCounter];
                        thisCounter += 1;;
                    }
                    else {
                        temp[i] = other.a[otherCounter];
                        otherCounter += 1;
                    }
                }
            }
            isSorted = true;
        }
    }

    public boolean rotate(int n) {
        if (n > 0 && a.length > 1) {

        }
        return false;
    }

    public boolean isSorted() {
        return isSorted;
    }

}
