import utils.GeradorDeNumeros;
import java.util.List;

class QuickSort {

    public static void main(String args[]) {
        QuickSort quickSort = new QuickSort();
        List<Integer> arr = GeradorDeNumeros.randomNumberList(10);
        System.out.print("Unsorted array: ");
        printArray(arr);

        int n = arr.size();
        long startTimer = System.nanoTime();

        quickSort.sort(arr, 0, n-1);

        long endTimer = System.nanoTime();
        long timer = endTimer - startTimer;
        System.out.println();
        System.out.println("Time for sorting this array: " + timer);
        System.out.print("Sorted array: ");
        printArray(arr);
    }

    public int breakArr(List<Integer> arr, int firstPartitionIndex, int lastPartitionIndex) {
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

    public void sort(List<Integer> arr, int firstIndex, int lastIndex) {
        // checks if there is still a element to be sorted
        if (firstIndex < lastIndex) {
            int brokeArrIndex = breakArr(arr, firstIndex, lastIndex);

            // sorts elements before and after the broken array index
            sort(arr, firstIndex, brokeArrIndex-1);
            sort(arr, brokeArrIndex+1, lastIndex);
        }
    }

    public static void printArray(List<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n; ++i)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }
}
