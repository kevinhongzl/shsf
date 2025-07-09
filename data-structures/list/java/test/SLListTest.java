import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class SLListTest {
    @Test
    @DisplayName("Test SLList initialization")
    void initialization() {
        SLList<Integer> list = new SLList<>();
        assertEquals(0, list.size());
    }

    @Test
    void testSize() {
        SLList<Integer> list = new SLList<>();
        assertEquals(0, list.size());
        list.addFirst(10);
        assertEquals(1, list.size());
        list.addLast(20);
        assertEquals(2, list.size());
    }

    @Test
    void testAddFirst() {
        SLList<String> list = new SLList<>();
        list.addFirst("world");
        assertEquals("world", list.getFirst());
        list.addFirst("hello");
        assertEquals("hello", list.getFirst());
    }

    @Test
    void testGetFirst() {
        SLList<Integer> list = new SLList<>();
        assertNull(list.getFirst());
        list.addFirst(10);
        assertEquals(10, list.getFirst());
        list.addFirst(20);
        assertEquals(20, list.getFirst());
    }

    @Test
    void testAddLast() {
        SLList<Integer> list = new SLList<>();
        list.addLast(10);
        assertEquals(1, list.size());
        assertEquals(10, list.getFirst());
        list.addLast(20);
        assertEquals(2, list.size());
        assertEquals(10, list.getFirst());
    }

    @Test
    void testGet() {
        SLList<Integer> list = new SLList<>();
        assertNull(list.get(0));

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertNull(list.get(3));
        assertNull(list.get(-1));
    }

    @Test
    void testInsert() {
        SLList<Integer> list = new SLList<>();
        list.insert(5, 0); // Insert into empty list
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));

        list.insert(1, 0); // Insert at beginning
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(1));

        list.insert(10, 2); // Insert at end
        assertEquals(3, list.size());
        assertEquals(10, list.get(2));

        list.insert(3, 1); // Insert in middle
        assertEquals(4, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(5, list.get(2));
        assertEquals(10, list.get(3));

        list.insert(100, 10); // Out of bounds
        assertEquals(5, list.size());
    }

    @Test
    void testRemove() {
        SLList<Integer> list = new SLList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Remove from middle
        assertEquals(20, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));

        // Remove first
        assertEquals(10, list.remove(0));
        assertEquals(1, list.size());
        assertEquals(30, list.get(0));

        // Remove last
        list.addFirst(5);
        assertEquals(30, list.remove(1));
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));

        // Remove from empty list
        SLList<Integer> emptyList = new SLList<>();
        assertNull(emptyList.remove(0));

        // Remove with invalid index
        assertNull(list.remove(-1));
        assertNull(list.remove(list.size()));
    }
}
