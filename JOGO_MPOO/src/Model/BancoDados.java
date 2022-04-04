package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BancoDados {
	
	public static String carregarArquivo(String path) {
		StringBuilder builder = new StringBuilder(); // builder permite que você armazene ou adicione caracteres muito facilmente 
		
		try {
			BufferedReader br  = new BufferedReader(new FileReader(path));
			
			String line;
			while((line = br.readLine()) != null) {
				builder.append(line + "\n");
				
			}
			br.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0; 
		}
		
	}

}
