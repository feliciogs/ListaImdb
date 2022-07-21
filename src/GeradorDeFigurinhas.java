import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    
    public void criar(InputStream inputStream,String nomeArquivo) throws IOException{
        // Leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Nova imagem
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImage = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);

        //Editar imagem
        Graphics2D graphics2D = (Graphics2D) novaImage.getGraphics();
        graphics2D.drawImage(imagemOriginal, 0, 0, null);

        //Adicionar texto
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD,64);
        graphics2D.setColor(Color.YELLOW);
        graphics2D.setFont(fonte);

        graphics2D.drawString("TEXTO",100,novaAltura-100);
        
        Random rand = new Random();
        int n = rand.nextInt(1000);

        //Salvar nova Imagem editada
        ImageIO.write(novaImage, "png", new File("src/assets/figurinhas/"+n+".png")) ;       
    }


}
