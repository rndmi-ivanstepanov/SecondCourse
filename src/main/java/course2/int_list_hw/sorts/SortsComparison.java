package course2.int_list_hw.sorts;

import java.util.Arrays;
import java.util.Random;

public class SortsComparison {
    public static void main(String[] args) {
        int[] arr = generateArray();
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);

        long start = System.currentTimeMillis();
        insertionSort(arr);
        System.out.println("insertion sort - " + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        selectionSort(arr2);
        System.out.println("selection sort - " + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        bubbleSort(arr3);
        System.out.println("bubble sort - " + (System.currentTimeMillis() - start3));
    }

    private static int[] generateArray() {
        int length = 100_000;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(50_000);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void insertionSort(int[] arr) {
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
