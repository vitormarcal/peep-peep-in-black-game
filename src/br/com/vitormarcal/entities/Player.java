package br.com.vitormarcal.entities;

import java.awt.image.BufferedImage;

public class Player extends Entity {

    public boolean right;
    public boolean left;
    public boolean up;
    public boolean down;

    private final double speed = 1.4;

    public Player(int x, int y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, sprite);
    }

    public void tick() {
        if (right) {
            x += speed;
        } else if (left) {
            x -= speed;
        } else if (up) {
            y -= speed;
        } else if (down) {
            y += speed;
        }
    }
}
