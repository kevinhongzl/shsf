void main() {
    SLList<Integer> list = new SLList<>();
    list.addLast(21);
    list.addLast(10);
    list.addLast(11);
    list.addFirst(123);
    System.out.println(list.getFirst());
    System.out.println(list.size());
    list.display();
}
