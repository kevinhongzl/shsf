public class BSTClient {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<Integer>();
        System.out.println("BST initialized.");

        System.out.println("\nPutting 4, 7, 10, -1, 2, 1, 3, 5 into the tree.");
        tree.put(4);
        tree.put(7);
        tree.put(10);
        tree.put(-1);
        tree.put(2);
        tree.put(1);
        tree.put(3);
        tree.put(5);

        System.out.println("\nSize of the tree: " + tree.size());

        System.out.println("\nDoes the tree contain 7? " + tree.contains(7));
        System.out.println("Does the tree contain 99? " + tree.contains(99));

        System.out.println("\nGet 10 from the tree: " + tree.get(10));

        System.out.println("\nRemoving 7 from the tree.");
        tree.remove(7);

        System.out.println("Size of the tree after removing 7: " + tree.size());
        System.out.println("Does the tree contain 7? " + tree.contains(7));

        System.out.println("\nPrinting the tree using an iterator (in-order traversal):");
        for (int i: tree) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
