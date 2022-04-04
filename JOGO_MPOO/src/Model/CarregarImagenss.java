package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class CarregarImagenss {
	public  static BufferedImage loadImage(String nome) {
		try {
			// a imagem é armazenada em um bufferedimage então um bufferedimage é a imagem
		
		//	BufferedImage read = ImageIO.read(Paths.get("res//imagens//" + path).toFile().toURL());
			return ImageIO.read(new File("res//imagens//" + nome));

		} catch (IOException e) {	
			e.printStackTrace();
			System.exit(1); // SE O CORRER ALGUM ERRO
		}
		System.out.println("Retornou nullo");
		return null;
		
		
	}
	
	@SuppressWarnings("deprecation")
	public  static URL url(String nome ) {
		try {
			return Paths.get("res//imagens//" + nome).toFile().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
		
	
	}

	

}
