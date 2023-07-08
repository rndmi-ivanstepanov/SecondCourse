package course2.string_list_hw;

import course2.string_list_hw.exceptions.ElementNotFoundException;
import course2.string_list_hw.exceptions.IdxOutOfBoundsException;
import course2.string_list_hw.exceptions.NullItemException;
import org.junit.jupiter.api.Test;

import static course2.string_list_hw.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    MyArrayList out = new MyArrayList(10);

    private void fill(int upTo) {
        for (int i = 0; i < upTo; i++) {
            out.add(STR);
        }
    }

    @Test
    void testAdd() {
        fill(5);
        assertEquals(out.get(4), STR);

        out.add(0, STR2);
        assertEquals(0, out.indexOf(STR2));
    }

    @Test
    void testSet() {
        fill(3);
        out.set(2, STR2);
        assertEquals(2, out.indexOf(STR2));
    }

    @Test
    void testRemove() {
        fill(1);
        out.remove(STR);
        assertTrue(out.isEmpty());
        assertThrows(NullItemException.class, () -> out.remove(NULL));
        assertThrows(ElementNotFoundException.class, () -> out.remove(STR));
    }

    @Test
    void testContains() {
        fill(5);
        assertTrue(out.contains(STR));
        assertFalse(out.contains(STR2));
    }

    @Test
    void testIndexOf() {
        fill(100);
        assertEquals(-1, out.lastIndexOf(STR2));
        assertEquals(99, out.lastIndexOf(STR));
        assertEquals(0, out.indexOf(STR));
    }

    @Test
    void get_shouldThrowIfIdxIsBiggerThanLength() {
        fill(10);
        assertThrows(IdxOutOfBoundsException.class, () -> out.get(10));
    }

    @Test
    void testEquals() {
        fill(2);
        MyArrayList clone = new MyArrayList(10);
        clone.add(STR);
        clone.add(STR);
        assertTrue(out.equals(clone));
        clone.add(STR2);
        assertFalse(out.equals(clone));
        fill(100);
        assertFalse(out.equals(clone));
    }

    @Test
    void size_shouldReturnZeroIfArrIsEmpty() {
        assertEquals(0, out.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(out.isEmpty());
        fill(10);
        assertFalse(out.isEmpty());
    }

    @Test
    void clear_shouldClearTheArrayAndNullifyTheSize() {
        fill(100);
        assertFalse(out.isEmpty());
        assertNotEquals(0, out.size());

        out.clear();
        assertTrue(out.isEmpty());
        assertEquals(0, out.size());
    }
}
