
package project_aps;

import java.util.Random;  

public class GeradorDeNumeros {    
        
    public static void main(String[] args) {
        
        int quantidadeNumeros = 100;
        //instância um objeto da classe Random usando o construtor básico         
        Random gerador = new Random();          
        //imprime sequência de 10 números inteiros aleatórios entre 0 e 25         
        for (int i = 0; i < quantidadeNumeros; i++) {             
            System.out.println(gerador.nextInt(100));        
        }    
    } 
}
