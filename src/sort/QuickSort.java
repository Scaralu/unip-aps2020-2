package sort;

import utils.GeradorDeNumeros;
import utils.Print;

import java.util.List;

public class QuickSort {

    public static int breakArr(List<Integer> arr, int firstPartitionIndex, int lastPartitionIndex) {
        int pivot = arr.get(lastPartitionIndex);
        int i = (firstPartitionIndex-1);

        for (int j=firstPartitionIndex; j<lastPartitionIndex; j++) {
            if (arr.get(j) <= pivot) {
                i++;

                int indexTemp = arr.get(i);

                arr.set(i, arr.get(j));
                arr.set(j, indexTemp);
            }
        }

        int swap = arr.get(i + 1);

        arr.set(i + 1, arr.get(lastPartitionIndex));
        arr.set(lastPartitionIndex, swap);

        return i+1;
    }

    public static void sort(List<Integer> arr, int firstIndex, int lastIndex) {
        // checks if there is still a element to be sorted
        if (firstIndex < lastIndex) {
            int brokeArrIndex = breakArr(arr, firstIndex, lastIndex);

            // sorts elements before and after the broken array index
            sort(arr, firstIndex, brokeArrIndex-1);
            sort(arr, brokeArrIndex+1, lastIndex);
        }
    }
}
