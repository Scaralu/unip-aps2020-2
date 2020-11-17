package sort;

import utils.GeradorDeNumeros;

import java.util.List;

public class InsertionSort {

    public static void sort(List<Integer> arrayNum) {
        for (int j = 1; j < arrayNum.size(); j++) {
            Integer key = arrayNum.get(j);
            int i = j-1;
            while ( (i > -1) && ( arrayNum.get(i) > key ) ) {
                arrayNum.set(i+1, arrayNum.get(i));
                i--;
            }
            arrayNum.set(i+1, key);
        }
    }
}
