public class BST<K extends Comparable<K>>{
    public K key;
    public BST<K> left;
    public BST<K> right;

    public BST() {
        this.set(null, null, null);
    }

    private void set(K key, BST<K> left, BST<K> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    private void set(BST<K> other) {
        this.set(other.key, other.left, other.right);
    }

    public void insert(K key) {
        if (this.key == null) {
            this.set(key, new BST<>(), new BST<>());
            return;
        }
        if (key.compareTo(this.key) <= 0) {
            this.left.insert(key);
        } else {
            this.right.insert(key);
        }
    }

    public void traverse() {
        if (key == null) {
            return;
        }
        System.out.print(key);
        System.out.print(" ");
        left.traverse();
        right.traverse();
    }

    public Boolean contains(K key) {
        BST<K> result = this.find(key);
        return result != null;
    }

    public BST<K> find(K key) {
        if (this.key == null) {
            return null;
        }
        if (key.compareTo(this.key) == 0) {
            return this;
        } else if (key.compareTo(this.key) < 0) {
            return left.find(key);
        } else {
            return right.find(key);
        }
    }

    public Boolean delete(K key) {
        BST<K> target = this.find(key);
        if (target == null) {
            return false;
        }

        // No children
        if (target.left.key == null && target.right.key == null) {
            target.set(null, new BST<>(), new BST<>());
            return true;
        }

        // One child
        if (target.left.key == null) {
            target.set(target.right);
            return true;
        }
        if (target.right.key == null) {
            target.set(target.left);
            return true;
        }

        // Two children
        if (target.left.right.key == null){
            target.key = target.left.key;
            target.left = target.left.left;
        } else {
            BST<K> parent = target.left;
            BST<K> rightmost = target.left.right;
            while (rightmost.right.key != null) {
                parent = rightmost;
                rightmost = rightmost.right;
            }
            parent.right = rightmost.left;
            target.key = rightmost.key;
        }
        return true;
    }
}