import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Barcode {

    // metodo per generare un'immagine con un font personalizzato
    public static BufferedImage generateBarcodeWithFont(String input, String fontPath, int fontSize) throws IOException, FontFormatException {
        // carico il font dal file
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont((float) fontSize);

        // determino la larghezza e l'altezza dell'immagine
        // larghezza proporzionale alla lunghezza del testo
        int width = input.length() * fontSize; 
        // altezza sufficiente per il testo
        int height = fontSize * 2; 

        // crea un'immagine BufferedImage
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // configura il rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // colore di sfondo
        g2d.setColor(Color.WHITE);
        // riempio lo sfondo con il colore bianco
        g2d.fillRect(0, 0, width, height);
        // colore del testo
        g2d.setColor(Color.BLACK); 
        // imposto il font
        g2d.setFont(font);

        // disegno il testo al centro dell'immagine
        FontMetrics fontMetrics = g2d.getFontMetrics();
        // posizione orizzontale
        int x = 0; 
        // posizione verticale
        int y = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        g2d.drawString(input, x, y);

        g2d.dispose();
        return image;
    }

    public static void main(String[] args) {
        try {
            // codice a barre da generare
            // stringa di esempio per il collaudo
            String input = "123456789";
            // percorso del font TrueType
            // devo avere il font "Libre Barcode 128" installato 
            // o disponibile nel percorso specificato
            String fontPath = "C:\\Users\\AlessioLongo\\AppData\\Local\\Microsoft\\Windows\\Fonts\\LibreBarcode128-Regular.ttf"; 
            int fontSize = 48;

            // genero l'immagine con il font personalizzato sopra
            BufferedImage barcodeImage = generateBarcodeWithFont(input, fontPath, fontSize);

            // ottengo la directory dell'utente
            String userHome = System.getProperty("user.home");
            // salvo l'immagine sul desktop
            // creo un file per l'immagine
            // il file si chiamerà barcode.png 
            File outputFile = new File(userHome + "\\Desktop\\barcode.png"); 
            ImageIO.write(barcodeImage, "png", outputFile);

            // messaggio di conferma
            System.out.println("Codice a barre generato e salvato come barcode.png");
        } catch (IOException | FontFormatException e) {
            System.err.println("Errore durante la generazione del codice a barre: " + e.getMessage());
        }
    }
}