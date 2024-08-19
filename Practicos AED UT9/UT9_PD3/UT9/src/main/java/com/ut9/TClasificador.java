package com.ut9;

public class TClasificador {
    static int currentDepth = 0;
    static int maxDepth = 0;
    public  void quicksort(int[] arr, int low, int high) {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }

        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }

        currentDepth--;
    }

    private  int partition(int[] arr, int low, int high) {
        System.out.println(encuentraPivote(arr));
        int pivot = Math.max(arr[low], arr[low + 1]);
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    
    public  int[] quickSort(int[] vector) {
        quicksort(vector, 0, vector.length - 1);
        return vector;
    }
    public int encuentraPivote(int[] vector) {
        return Math.max(vector[0], vector[1]);
    }
}
