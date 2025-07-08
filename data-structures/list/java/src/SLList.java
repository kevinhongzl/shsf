public class SLList<T> implements List61B<T> {
    private final Node<T> sentinel;
    private int size;

    public static class Node<T> {
        private final T item;
        private Node<T> next;
        public Node(T x, Node<T> n) {
            item = x;
            next = n;
        }
    }

    public SLList() {
        sentinel = new Node<>(null, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T x) {
        sentinel.next = new Node<>(x, sentinel.next);
        size += 1;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            return null;
        }
        return sentinel.next.item;
    }

    @Override
    public void addLast(T x) {
        insert(x, size);
    }

    @Override
    public T getLast() {
        return get(size);
    }

    @Override
    public T removeLast() {
        return remove(size - 1);
    }

    @Override
    public void insert(T x, int position) {
        Node<T> p = sentinel;
        for (int i = 0; i < position && p.next != null; i++) {
            p = p.next;
        }
        p.next = new Node<>(x, p.next);
        size += 1;
    }

    public T get(int position) {
        if (position < 0 || position >= size) {
            return null;
        }

        Node<T> p = sentinel.next;
        for (int i = 0; i < position; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T remove(int position) {
        if (position < 0 || position >= size) {
            return null;
        }
        Node<T> p = sentinel;
        for (int i = 0; i < position; i++) {
            p = p.next;
        }
        Node<T> removedItem = p.next;
        p.next = p.next.next;
        size -= 1;
        return removedItem.item;
    }

    public void display() {
        System.out.print("[");
        for (Node<T> p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item);
            if (p.next != null) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}

