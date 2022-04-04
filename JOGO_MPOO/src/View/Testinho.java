package View;

import java.io.File;
import java.nio.file.Paths;

import javax.swing.JFrame;


public class Testinho {
		
		public void metodo() {
			File file = Paths.get("res//Imagens//dngn_open_door.png").toFile();
			System.out.println(file.exists());
			
		}
		public static void main(String[] args) {
			new Testinho().metodo();
		}
		


}
