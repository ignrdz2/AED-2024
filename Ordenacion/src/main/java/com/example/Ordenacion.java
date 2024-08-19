package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ordenacion {

    // Ordenamiento por Inserción
    public void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Ordenación Shell
    public void shellSort(int arr[]) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    // Método Burbuja
    public void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Quicksort
    public void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    // Clasificación por Selección
    public void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // HeapSort
    public void heapSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    // Cuenta por Distribución (Counting Sort)
    public void countingSort(int arr[]) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    // Binsort
    public void binSort(int arr[]) {
        int n = arr.length;
        if (n <= 0)
            return;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] bins = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            bins[i] = new ArrayList<Integer>();
        }
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            int binIndex = (int)((float)arr[i] / (max + 1) * n);
            bins[binIndex].add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(bins[i]);
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bins[i].size(); j++) {
                arr[index++] = bins[i].get(j);
            }
        }
    }

    // Algoritmo de Radix
    public void radixSort(int arr[]) {
        int max = getMax(arr, arr.length);
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(arr, arr.length, exp);
    }

    int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int count[] = new int[10];
        for (int i = 0; i < 10; i++)
            count[i] = 0;
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void main(String args[]) {
        Ordenacion sorter = new Ordenacion();

        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array: " + Arrays.toString(array));

        // Test Insertion Sort
        int[] arr1 = array.clone();
        sorter.insertionSort(arr1);
        System.out.println("Sorted array by Insertion Sort: " + Arrays.toString(arr1));

        // Test Shell Sort
        int[] arr2 = array.clone();
        sorter.shellSort(arr2);
        System.out.println("Sorted array by Shell Sort: " + Arrays.toString(arr2));

        // Test Bubble Sort
        int[] arr3 = array.clone();
        sorter.bubbleSort(arr3);
        System.out.println("Sorted array by Bubble Sort: " + Arrays.toString(arr3));

        // Test Quick Sort
        int[] arr4 = array.clone();
        sorter.quickSort(arr4, 0, arr4.length - 1);
        System.out.println("Sorted array by Quick Sort: " + Arrays.toString(arr4));

        // Test Selection Sort
        int[] arr5 = array.clone();
        sorter.selectionSort(arr5);
        System.out.println("Sorted array by Selection Sort: " + Arrays.toString(arr5));

        // Test Heap Sort
        int[] arr6 = array.clone();
        sorter.heapSort(arr6);
        System.out.println("Sorted array by Heap Sort: " + Arrays.toString(arr6));

        // Test Counting Sort
        int[] arr7 = array.clone();
        sorter.countingSort(arr7);
        System.out.println("Sorted array by Counting Sort: " + Arrays.toString(arr7));

        // Test Bin Sort
        int[] arr8 = array.clone();
        sorter.binSort(arr8);
        System.out.println("Sorted array by Bin Sort: " + Arrays.toString(arr8));

        // Test Radix Sort
        int[] arr9 = array.clone();
        sorter.radixSort(arr9);
        System.out.println("Sorted array by Radix Sort: " + Arrays.toString(arr9));
    }
}
