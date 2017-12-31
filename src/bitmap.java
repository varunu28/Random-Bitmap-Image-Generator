import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class bitmap {

    public static void main(String[] args) throws IOException {

        final int w = 128;
        final int h = 128;
        final int numOfPoints = 3;

        File file = new File("bitMap.png");

        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < w; i++) {
            
            int[] randomNumbers = getRandom();
            int k = 0;
            
            for (int j = 0; j < h; j++) {

                int x = randomNumbers[k];
                int y = randomNumbers[k+1];
                int z = randomNumbers[k+2];
                
                Color color = new Color(x, y, z);
                int rgb = color.getRGB();
                
                img.setRGB(i, j, rgb);
                
                k += numOfPoints;
            }
        }

        ImageIO.write(img,"png", file);
    }

    private static int[] getRandom() throws IOException {
        
        URL url = new URL("https://www.random.org/integers/?num=384&min=0&max=255&col=1&base=10&format=plain&rnd=new");
        URLConnection uc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));

        int[] val = new int[384];
        int k = 0;

        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            val[k] = Integer.parseInt(inputLine);
            k++;
        }

        in.close();
        
        return val;
    }
}
