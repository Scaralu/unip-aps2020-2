import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
    
    // método do algoritmo de ordanação - INSERTION SORT
    private static void insertionSort(List<Integer> arrayNum) {
        int num = arrayNum.size();
        
        long start = System.nanoTime(); // faz o trabalho a ser medido 
        for (int j = 1; j < num; j++) {  
            Integer key = arrayNum.get(j);  
            int i = j-1;  
            while ( (i > -1) && ( arrayNum.get(i) > key ) ) {  
                arrayNum.set(i+1, arrayNum.get(i));  
                i--;  
            }  
            arrayNum.set(i+1, key);  
        }
        long elapsed = System.nanoTime() - start;
        
        // System.nanoTime() - para trabalhar com quantidades menores, sua precisão é maior
        // System.currentTimeMillis() - pega o tempo exato do sistema, sua precisão é menor
        System.out.println("\n\nTempo de execução: " + elapsed + "ns");
    }
    
    // método para gerar números aleatórios até de 0 a 100 para ordenar
    private static List<Integer> generateNumbers() {
        Random gerador = new Random();
        List<Integer> arrayList = new ArrayList<>();
        
        for (int i = 0; i < 20000; i++) {             
            arrayList.add(gerador.nextInt(20000));
        }
        
        return arrayList;
    }
    
    // método para ler arquivo com números em .csv
    private static List<Integer> readFile() {
        Scanner scanner = null;
        List<Integer> arrayList = new ArrayList<>();
        
        try {
            scanner = new Scanner(new FileReader("arrayNumeros.txt")).useDelimiter(",");
            while (scanner.hasNext()) {
                String numero = scanner.next().trim();
                if (!numero.isEmpty()) {
                    arrayList.add(Integer.parseInt(numero));
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("ERRO: O arquivo não pôde ser lido!");
            
        } finally {
            scanner.close();
        }
        
        return arrayList;
    }
    
    public static void main(String a[]){
        System.out.println("*** ANTES ***");
        List<Integer> arrayList = generateNumbers();
        
        for(int i:arrayList){    
            System.out.print(i+" ");    
        }
        
        insertionSort(arrayList);

        System.out.println("\n\n");
        System.out.println("*** DEPOIS ***");

        for(int i:arrayList){    
            System.out.print(i+" ");
        }
    }    
} 
