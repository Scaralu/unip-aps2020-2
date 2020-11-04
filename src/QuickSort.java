class QuickSort {
    int breakArr(int arr[], int firstPartitionIndex, int lastPartitionIndex) {
        int pivot = arr[lastPartitionIndex];
        int i = (firstPartitionIndex-1);

        for (int j=firstPartitionIndex; j<lastPartitionIndex; j++) {
            if (arr[j] <= pivot) {
                i++;

                int indexTemp = arr[i];

                arr[i] = arr[j];
                arr[j] = indexTemp;
            }
        }

        int swap = arr[i+1];

        arr[i+1] = arr[lastPartitionIndex];
        arr[lastPartitionIndex] = swap;

        return i+1;
    }

    void sort(int arr[], int firstIndex, int lastIndex)
    {
        // checks if there is still a element to be sorted

        if (firstIndex < lastIndex) {
            int brokeArrIndex = breakArr(arr, firstIndex, lastIndex);


            // sorts elements before and after the broken array index

            sort(arr, firstIndex, brokeArrIndex-1);
            sort(arr, brokeArrIndex+1, lastIndex);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        // arr to be used in sort funtcion
        int arr[] = new int[]{10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, n-1);

        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
