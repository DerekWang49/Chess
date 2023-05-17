import java.util.Arrays;

public class BinaryTree<V extends Comparable<V>> {
    private Node<V> root;

    public BinaryTree(Node<V> root) {
        this.root = root;
    }

    public Node<V> getRoot() {
        return this.root;
    }

    public void printInorder() {
        printInOrderHelper(root);
    }
    private void printInOrderHelper(Node<V> node) {
        // TODO: Fill in definition
        if (node.getLeft() != null && node.getRight() != null) {
            printInOrderHelper(node.getLeft());
            System.out.println(node.getValue());
            printInOrderHelper(node.getRight());

        }

        else if (node.getLeft() == null) {
            System.out.println(node.getValue());
        }

    }

    public void printPreorder(){
        printPreorderHelper(root);
    }
    private void printPreorderHelper(Node<V> node) {
        // TODO: Fill in definition
        System.out.println(node.getValue());
        if (node.getLeft() != null && node.getRight() != null) {
            printPreorderHelper(node.getLeft());
            printPreorderHelper(node.getRight());
        }

    }

    public void printPostorder() {
        printPostorderHelper(root);
    }
    private void printPostorderHelper(Node<V> node) {
        // TODO: Fill in definition
        if (node.getLeft() != null && node.getRight() != null) {
            printPostorderHelper(node.getLeft());
            printPostorderHelper(node.getRight());
            System.out.println(node.getValue());

        }

        else if (node.getLeft() == null) {
            System.out.println(node.getValue());
        }
        else if (node.getRight() == null) {
            System.out.println(node.getValue());
        }
    }

    public V[] flatten() {
        // TODO: Fill in definition
        V[] a = (V[]) new Comparable[5];
        flatten_helper(a, root, 0);
        sort(a);
        return null;
    }

    public void flatten_helper(Comparable[] a, Node node, int index) {
        if (node.getLeft() != null && node.getRight() != null) {
            flatten_helper(a, node.getLeft(), index + 1);
            flatten_helper(a, node.getRight(), index + 1);
            a[index] = node.getValue();
        }

        else if (node.getLeft() == null) {
            a[index] = node.getValue();
        }
        else if (node.getRight() == null) {
            a[index] = node.getValue();
        }
        System.out.println(a);
    }


    // bubble sort
    // useful for flatten
    public void sort(Comparable[] a) {
        int i, j;
        Comparable temp;
        boolean swapped = true;
        for (i = 0; i < a.length && swapped == true; i++) {
            swapped = false;
            for (j = 1; j < a.length - i; j++) {
                if (a[j].compareTo(a[j-1]) < 0) {
                    swapped = true;
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }

    public void invert() {
        invertHelper(root);
    }

    public Node<V> invertHelper(Node<V> node) {
        // TODO: Fill in definition
        return null;
    }

    public boolean containsSubtree(BinaryTree<V> other) {
        // TODO: Fill in definition
        return false;
    }
    
    public void merge(BinaryTree<V> other) {
        // TODO: Fill in definition (honors milestone only)
        return;
    }

    // Main contains tests for each milestone.
    // Do not modify existing tests.
    // Un-comment tests by removing '/*' and '*/' as you move through the milestones.
    public static void main (String args[]) {
        // Tree given for testing on
        BinaryTree<Integer> p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4, null, null),
                        new Node<Integer>(5, null, null)),
                new Node<Integer>(3, null, null)));

        // Milestone 1 (Traversing)
        System.out.println("--- Milestone 1 ---");
        System.out.print("Expected: 4 2 5 1 3" + System.lineSeparator() + "Actual: ");
        p1Tree.printInorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 1 2 4 5 3" + System.lineSeparator() + "Actual: ");
        p1Tree.printPreorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 4 5 2 3 1" + System.lineSeparator() + "Actual: ");
        p1Tree.printPostorder();
        System.out.println();

        // Milestone 2 (flatten) -- expected output: 1 2 3 4 5

        System.out.println(System.lineSeparator() + "--- Milestone 2 ---");
        System.out.print("Expected: 1 2 3 4 5" + System.lineSeparator() + "Actual: ");

        Comparable[] array_representation = p1Tree.flatten();
        for (int i = 0; i < array_representation.length; i++) {
            System.out.print(array_representation[i] + " ");
        }
        System.out.println();


        // Milestone 3 (invert)
        /*
        System.out.println(System.lineSeparator() + "--- Milestone 3 ---");

        p1Tree.invert();

        System.out.print("Expected: 3 1 5 2 4" + System.lineSeparator() + "Actual: ");
        p1Tree.printInorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 1 3 2 5 4" + System.lineSeparator() + "Actual: ");
        p1Tree.printPreorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 3 5 4 2 1" + System.lineSeparator() + "Actual: ");
        p1Tree.printPostorder();
        System.out.println();
        */

        // Milestone 4 (containsSubtree)
        /*
        System.out.println(System.lineSeparator() + "--- Milestone 4 ---");

        p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4, null, null),
                        new Node<Integer>(5, null, null)),
                new Node<Integer>(3, null, null)));
        BinaryTree<Integer> p2Tree = new BinaryTree<Integer>(new Node<Integer>(2,
                new Node<Integer>(4, null, null),
                new Node<Integer>(5, null, null)));
        BinaryTree<Integer> p3Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2, null, null),
                new Node<Integer>(3, null, null)));
        BinaryTree<Integer> p4Tree = null;

        System.out.print("Expected: true" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p2Tree));
        System.out.println();

        System.out.print("Expected: false" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p3Tree));
        System.out.println();

        System.out.print("Expected: true" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p4Tree));
        */
        
        /*
        // Milestone 5 (merge) *HONORS SECTION*
        System.out.println(System.lineSeparator() + "--- Milestone 5 ---");
        BinaryTree<Integer> p5Tree = new BinaryTree<>(new Node<>(10,
                new Node<>(7,
                        new Node<>(1, null, null),
                        new Node<>(5, null, null)),
                new Node<>(3,
                        new Node<>(9, null, null),
                        null)));
        BinaryTree<Integer> p6Tree = new BinaryTree<>(new Node<>(6,
                new Node<>(7,
                        new Node<>(-3, null, null),
                        new Node<>(6, null, null)),
                new Node<>(4,
                        null,
                            new Node<>(9,
                                new Node<>(4, null, null),
                                    null))));
        BinaryTree<Integer> p7Tree = new BinaryTree<>(new Node<>(10,
                new Node<>(7,
                        new Node<>(1, null, null),
                        new Node<>(6, null, null)),
                new Node<>(4,
                        new Node<>(9, null, null),
                        new Node<>(9,
                                new Node<>(4, null, null),
                                null))));
        p5Tree.merge(p6Tree);
        System.out.print("Expected: ");
        p7Tree.printPreorder();
        System.out.print("\nActual: ");
        p5Tree.printPreorder();
        System.out.println();
        System.out.print("Expected: true" + System.lineSeparator() + "Actual: ");
        System.out.println(p5Tree.containsSubtree(p7Tree));
        System.out.println();
         */
    }
}