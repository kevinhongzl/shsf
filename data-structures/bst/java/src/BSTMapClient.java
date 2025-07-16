public class BSTMapClient {
    public static void main(String[] args) {
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        bstMap.put("hello", 5);
        bstMap.put("cat", 10);
        bstMap.put("fish", 22);
        bstMap.put("zebra", 90);

        System.out.println("Size of the map: " + bstMap.size());

        System.out.println("Value for key 'hello': " + bstMap.get("hello"));

        System.out.println("Does the map contain key 'cat'? " + bstMap.containsKey("cat"));
        System.out.println("Does the map contain key 'dog'? " + bstMap.containsKey("dog"));

        System.out.println("Keys in the map:");
        for (String key : bstMap) {
            System.out.println(key);
        }

        System.out.println("Removing key 'fish'");
        bstMap.remove("fish");

        System.out.println("Size of the map after removal: " + bstMap.size());

        System.out.println("Clearing the map");
        bstMap.clear();

        System.out.println("Final size of the map: " + bstMap.size());
    }
}