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

        if (size == length) {
            length *= 2;
            Integer[] newArr = Arrays.copyOf(arr, length);
            newArr[size] = item;
            arr = newArr;
        } else {
            arr[size] = item;
        }
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkIndex(index);

        if (size == length) {
            length *= 2;
        }

        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
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
        Integer[] copy = toArray();
        sort(copy);
        return binarySearch(copy, item) != -1;
    }

    @Override
    public int indexOf(Integer item) {

        for (int i = 0; i < size; i++) {

            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {

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
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
