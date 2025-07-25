# Binary Search Tree

### Java

I add additional null nodes on leaf nodes to represent null pointers.
The reason behind this clumsy implementation is that I want to deal with the case`this == null`when BSTNode methods are called recursively. For instance,
```java
public BSTNode<K> insert(K item) {
    if (this.item == null) { // `this` can not be `null`.  We need a node here.
        this.set(item, new BSTNode<>(), new BSTNode<>());
        return this;
    }
    if (item.compareTo(this.item) <= 0) return this.left.insert(item);
    else return this.right.insert(item);
}
```

After this, I found the including a node argument in helper methods may be a better approach to do so:
```java
public BSTNode<K> insert(BSTNode<K> node, K item) {
    if (node == null) return new BSTNode<K>(item, null, null);
    else if (item.compareTo(node.item) <= 0) node.left = insert(node.left, item);
    else node.right = insert(node.right, item);
    return node;
}
```