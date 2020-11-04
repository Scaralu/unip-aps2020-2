import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LerArquivo {
    
    public static void main(String[] args) {		
		Scanner scanner = null;
		try {
                    List<Integer> arrayList = new ArrayList<>();
			scanner = new Scanner(new FileReader("arrayNumeros.txt")).useDelimiter(",");
			while (scanner.hasNext()) {
				String numero = scanner.next().trim();
                                if (!numero.isEmpty()) {
                                    arrayList.add(Integer.parseInt(numero));
                                }
			}
                        for(Integer i:arrayList){    
                            System.out.print(i+" ");  
                        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO: O arquivo não pôde ser lido!");
			e.printStackTrace();
		} finally {
			scanner.close();
		}	
              
	}
    
}
