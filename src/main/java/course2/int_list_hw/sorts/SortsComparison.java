package course2.int_list_hw.sorts;

import java.util.Arrays;
import java.util.Random;

public class SortsComparison {
    public static void main(String[] args) {
        int[] arr = generateArray();
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        int[] arr4 = Arrays.copyOf(arr, arr.length);
        int[] arr5 = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();

            switch (i) {
                case 0:
                    insertionSort(arr);
                    System.out.print("insertion sort - ");
                    break;
                case 1:
                    selectionSort(arr2);
                    System.out.print("selection sort - ");
                    break;
                case 3:
                    quickSort(arr4, 0, arr4.length - 1);
                    System.out.print("quick sort - ");
                    break;
                case 4:
                    mergeSort(arr5);
                    System.out.print("merge sort - ");
                    break;
                case 2:
//                    bubbleSort(arr3);
                    System.out.print("bubble sort - 15000");
                    break;
            }
            System.out.println(System.currentTimeMillis() - start);
        }
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
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
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

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }

    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int l = begin - 1;

        for (int r = begin; r < end; r++) {
            if (arr[r] <= pivot) {
                l++;

                swap(arr, l, r);
            }
        }
        swap(arr, l + 1, end);
        return l + 1;
    }

    private static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
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
}
