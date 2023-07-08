package course2.string_list_hw;

import course2.string_list_hw.exceptions.ElementNotFoundException;
import course2.string_list_hw.exceptions.IdxOutOfBoundsException;

import java.util.Arrays;

public class MyArrayList implements StringList {
    private String[] arr;
    private int length;
    private int size = 0;

    public MyArrayList(int length) {
        this.length = length;
        this.arr = new String[length];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            builder.append(arr[i]).append(", ");
            builder.append(arr[i]).append(", ");
        }

        return builder
                .delete(builder.length() - 2, builder.length())
                .append("]")
                .toString();
    }

    @Override
    public String add(String item) {

        if (size == length) {
            length *= 2;
            String[] newArr = Arrays.copyOf(arr, length);
            newArr[size] = item;
            arr = newArr;
        } else {
            arr[size] = item;
        }
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
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
    public String set(int index, String item) {
        checkIndex(index);
        arr[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int i = 0, token = 0;

        for (; i < size; i++) {

            if (arr[i].equals(item)) {
                arr[i] = null;
                token++;
                break;
            }
        }

        if (token == 0) {
            throw new ElementNotFoundException(notFoundMessage(item));
        }

        System.arraycopy(arr, i + 1, arr, i, size - i);
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String item = arr[index];
        arr[index] = null;
        System.arraycopy(arr, index + 1, arr, index, size - index);
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {

        for (int i = 0; i < size; i++) {

            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {

        for (int i = size - 1; i >= 0; i--) {

            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public boolean equals(StringList otherList) {

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
        arr = new String[length];
        size = 0;
    }

    @Override
    public String[] toArray() {

        return new String[0];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IdxOutOfBoundsException(outOfBoundsMessage(index));
        }
    }

    private String outOfBoundsMessage(int index) {
        return "Index " + index + " is out of bounds for length " + size;
    }

    private String notFoundMessage(String element) {
        return element + " has not been found in list";
    }
}
