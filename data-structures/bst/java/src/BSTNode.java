public class BSTNode<K extends Comparable<K>>{
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

    public void insert(K item) {
        if (this.item == null) {
            this.set(item, new BSTNode<>(), new BSTNode<>());
            return;
        }
        if (item.compareTo(this.item) <= 0) {
            this.left.insert(item);
        } else {
            this.right.insert(item);
        }
    }

    public boolean contains(K item) {
        BSTNode<K> result = this.find(item);
        return result.item != null;
    }

    public BSTNode<K> find(K item) {
        if (this.item == null) {
            return this;
        }
        if (item.compareTo(this.item) == 0) {
            return this;
        } else if (item.compareTo(this.item) < 0) {
            return left.find(item);
        } else {
            return right.find(item);
        }
    }

    public K delete(K item) {
        K itemDeleted;
        BSTNode<K> target = this.find(item);
        if (target.item == null) {
            return null;
        } else {
            itemDeleted = target.item;
        }

        // No children
        if (target.left.item == null && target.right.item == null) {
            target.set(null, new BSTNode<>(), new BSTNode<>());
            return itemDeleted;
        }

        // One child
        if (target.left.item == null) {
            target.set(target.right);
            return itemDeleted;
        }
        if (target.right.item == null) {
            target.set(target.left);
            return itemDeleted;
        }

        // Two children
        if (target.left.right.item == null){
            target.item = target.left.item;
            target.left = target.left.left;
        } else {
            BSTNode<K> parent = target.left;
            BSTNode<K> rightmost = target.left.right;
            while (rightmost.right.item != null) {
                parent = rightmost;
                rightmost = rightmost.right;
            }
            parent.right = rightmost.left;
            target.item = rightmost.item;
        }
        return itemDeleted;
    }
}