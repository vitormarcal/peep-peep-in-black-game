package br.com.vitormarcal.graficos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spritesheet {

    private BufferedImage spritesheet;

    public Spritesheet(String path) {
        try {
            spritesheet = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int x, int y, int width, int heigth) {
        return spritesheet.getSubimage(x, y, width, heigth);
    }
}
