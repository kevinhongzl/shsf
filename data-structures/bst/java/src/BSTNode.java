public class BSTNode<K extends Comparable<K>> {
    public K item;
    public BSTNode<K> left;
    public BSTNode<K> right;

    public BSTNode() {
        this.set(null, null, null);
    }

    public void set(K item, BSTNode<K> left, BSTNode<K> right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }

    public void set(BSTNode<K> other) {
        this.set(other.item, other.left, other.right);
    }

    public BSTNode<K> insert(K item) {
        if (this.item == null) {
            this.set(item, new BSTNode<>(), new BSTNode<>());
            return this;
        }
        if (item.compareTo(this.item) <= 0) return this.left.insert(item);
        else return this.right.insert(item);
    }

    public BSTNode<K> find(K item) {
        if (this.item == null || item.compareTo(this.item) == 0) return this;
        else if (item.compareTo(this.item) < 0) return left.find(item);
        else return right.find(item);
    }

    public BSTNode<K> delete(K item) {
        BSTNode<K> target = this.find(item);
        BSTNode<K> output = new BSTNode<>();
        output.set(target);

        if (target.item == null) return null; // Item not found
        else if (target.left.item == null) target.set(target.right); // No children || One child (right)
        else if (target.right.item == null) target.set(target.left);  // One child (left)
        else {
            // Two children
            BSTNode<K> iop = target.left.deleteMax();
            target.item = iop.item;
        }
        return output;
    }

    public BSTNode<K> deleteMax() {
        if (this.item == null) return null;
        if (this.right.item == null) {
            BSTNode<K> output = new BSTNode<>();
            output.set(this);
            this.set(this.left);
            return output;
        }
        return this.right.deleteMax();
    }
}