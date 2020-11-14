package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorDeNumeros {
        
    public static List<Integer> randomNumberList(int size) {
        Random gerador = new Random();
        List<Integer> randomNumbersList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbersList.add(gerador.nextInt(100));
        }
        return randomNumbersList;
    } 
}
