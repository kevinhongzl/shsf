import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>> implements Iterable<K> {
    public final BSTNode<K> root;
    public int size;

    public BST() {
        root = new BSTNode<>();
        size = 0;
    }

    public void insert(K item) {
        root.insert(item);
        size += 1;
    }

    public int size() {
        return size;
    }

    public boolean contains(K item) {
        return root.contains(item);
    }

    public K delete(K item) {
        K itemDeleted = root.delete(item);
        size -= itemDeleted != null? 1 : 0;
        return itemDeleted;
    }

    public Iterator<K> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<K> {
        Stack<BSTNode<K>> stack;

        public BSTIterator() {
            stack = new Stack<>();
            BSTNode<K> curr = root;
            while (curr.item != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }

        public boolean hasNext(){
            return !stack.isEmpty();
        }

        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            BSTNode<K> output = stack.pop();
            BSTNode<K> curr = output.right;
            while (curr.item != null) {
                stack.push(curr);
                curr = curr.left;
            }
            return output.item;
        }
    }
}