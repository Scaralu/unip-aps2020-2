package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;


public class EscreverArquivo {
    
    public static void main(String[] args) {		
		ArrayList<String> nomes = new ArrayList<>();		
		nomes.add("12");		
		nomes.add("15");
		nomes.add("16");
                nomes.add("20");
                nomes.add("Shakira");
                nomes.add("Lady Gaga");
                nomes.add("Ed Sheeran");
                nomes.add("Daniel");
                
		try{
                    PrintStream out = new PrintStream(new FileOutputStream("arrayNumeros.txt"));
                        out.println("arrayNumeros:");
                        for (String obj : nomes) {
                            out.println(obj);
                        }
                    
                    out.close();
			System.out.println("Arquivo escrito com sucesso!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}		
	}
}
