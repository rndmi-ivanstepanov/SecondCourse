package course2.int_list_hw;

import course2.string_list_hw.exceptions.ElementNotFoundException;
import course2.string_list_hw.exceptions.IdxOutOfBoundsException;
import course2.string_list_hw.exceptions.NullItemException;
import org.junit.jupiter.api.Test;

import static course2.int_list_hw.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class IntegerListTest {
    IntegerList out = new IntegerList();

    private void fill(IntList arr, int upTo) {
        for (int i = 0; i < upTo; i++) {
            arr.add(NUM);
        }
    }

    @Test
    void testAdd() {
        fill(out, 5);
        assertEquals(NUM, out.get(4));

        out.add(0, NUM2);
        assertEquals(0, out.indexOf(NUM2));

        out.add(6, ZERO);
        assertEquals(7, out.size());
        assertEquals(6, out.indexOf(ZERO));
    }

    @Test
    void testSet() {
        fill(out, 3);
        out.set(2, NUM2);
        assertEquals(2, out.indexOf(NUM2));
    }

    @Test
    void testRemove() {
        fill(out, 1);
        out.remove(NUM);
        assertTrue(out.isEmpty());
        assertThrows(NullItemException.class, () -> out.remove(NULL));
        assertThrows(ElementNotFoundException.class, () -> out.remove(NUM));
    }

    @Test
    void testContains() {
        fill(out, 5);
        assertTrue(out.contains(NUM));
        assertFalse(out.contains(NUM2));
    }

    @Test
    void testIndexOf() {
        fill(out, 100);
        assertEquals(-1, out.lastIndexOf(NUM2));
        assertEquals(99, out.lastIndexOf(NUM));
        assertEquals(0, out.indexOf(NUM));
    }

    @Test
    void get_shouldThrowIfIdxIsBiggerThanLength() {
        fill(out, 10);
        assertThrows(IdxOutOfBoundsException.class, () -> out.get(10));
    }

    @Test
    void testEquals() {
        fill(out, 2);
        IntList clone = new IntegerList();
        fill(clone, 2);
        assertEquals(out.size(), clone.size());
        assertTrue(out.equals(clone));
        clone.add(NUM2);
        assertFalse(out.equals(clone));
        fill(out, 100);
        assertFalse(out.equals(clone));
    }

    @Test
    void size_shouldReturnZeroIfArrIsEmpty() {
        assertEquals(0, out.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(out.isEmpty());
        fill(out, 10);
        assertFalse(out.isEmpty());
    }

    @Test
    void clear_shouldClearTheArrayAndNullifyTheSize() {
        fill(out, 100);
        assertFalse(out.isEmpty());
        assertNotEquals(0, out.size());

        out.clear();
        assertTrue(out.isEmpty());
        assertEquals(0, out.size());
    }

    @Test
    void testGrow() {
        fill(out, 11);
        assertEquals(15, out.getLength());
        fill(out, 5);
        double expected = Math.rint(15 * 1.5);
        assertEquals(expected, out.getLength());
    }
}
