package course2.int_list_hw;

import course2.string_list_hw.exceptions.ElementNotFoundException;
import course2.string_list_hw.exceptions.IdxOutOfBoundsException;
import course2.string_list_hw.exceptions.NullItemException;

import java.util.Arrays;

public class IntegerList implements IntList {
    private Integer[] arr;
    private int length;
    private int size = 0;

    public IntegerList(int length) {
        this.length = length;
        this.arr = new Integer[length];
    }

    public IntegerList() {
        this.length = 10;
        this.arr = new Integer[length];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            builder.append(arr[i]).append(", ");
        }

        return builder
                .delete(builder.length() - 2, builder.length())
                .append("]")
                .toString();
    }

    @Override
    public Integer add(Integer item) {
        checkItem(item);
        growIfNeeded();
        arr[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkItem(item);

        if (index == size) {
            growIfNeeded();
            arr[size++] = item;
            return item;
        }
        checkIndex(index);
        growIfNeeded();

        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkItem(item);
        checkIndex(index);
        arr[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        int index = indexOf(item);

        if (index == -1) {
            throw new ElementNotFoundException(notFoundMessage(item));
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer item = arr[index];
        arr[index] = null;
        System.arraycopy(arr, index + 1, arr, index, size - index);
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        checkItem(item);

        Integer[] copy = toArray();
        sort(copy);
        return binarySearch(copy, item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);

        for (int i = 0; i < size; i++) {

            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);

        for (int i = size - 1; i >= 0; i--) {

            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public boolean equals(IntList otherList) {

        if (size != otherList.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {

            if (!(arr[i].equals(otherList.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        arr = new Integer[length];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IdxOutOfBoundsException("Index " + index + " is out of bounds for length " + size);
        }
    }

    private void checkItem(Integer item) {
        if (item == null) {
            throw new NullItemException("Cannot store null");
        }
    }

    private String notFoundMessage(Integer element) {
        return element + " has not been found in list";
    }

    private int binarySearch(Integer[] arr, int target) {
        int l = 0, r = size - 1;
        int mid;

        while (l <= r) {

            mid = l + (r - l) / 2;

            if (target == arr[mid]) {
                return target;
            }

            if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private void sort(Integer[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        sort(left);
        sort(right);

        merge(arr, left, right);
    }

    private void merge(Integer[] arr, Integer[] left, Integer[] right) {
        int mainPos = 0;
        int leftPos = 0;
        int rightPos = 0;

        while (leftPos < left.length && rightPos < right.length) {

            if (left[leftPos] < right[rightPos]) {
                arr[mainPos++] = left[leftPos++];
            } else {
                arr[mainPos++] = right[rightPos++];
            }
        }

        while (leftPos < left.length) {
            arr[mainPos++] = left[leftPos++];
        }

        while (rightPos < right.length) {
            arr[mainPos++] = right[rightPos++];
        }
    }

    private void grow() {
        length *= 1.5;
        arr = Arrays.copyOf(arr, length);
    }

    private void growIfNeeded() {
        if (size == length) {
            grow();
        }

    }

    int getLength() {
        return length;
    }
}
