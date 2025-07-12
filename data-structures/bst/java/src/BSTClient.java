public class BSTClient {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<Integer>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        
        for (int i: tree) {
            System.out.print(i + " ");
        }
    }
}
