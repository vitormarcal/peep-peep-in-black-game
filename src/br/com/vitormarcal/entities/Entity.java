package br.com.vitormarcal.entities;

import br.com.vitormarcal.main.Game;
import br.com.vitormarcal.world.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public static BufferedImage LIFEPACK_EN = Game.spritesheet.getSprite(6*16, 0, 16,16);
    public static BufferedImage WEAPON_EN = Game.spritesheet.getSprite(7*16, 0, 16,16);
    public static BufferedImage BULLET_EN = Game.spritesheet.getSprite(6*16, 16, 16,16);
    public static BufferedImage ENEMY_EN = Game.spritesheet.getSprite(7*16, 16, 16,16);

    protected double x;
    protected double y;
    protected int width;
    protected int height;
    protected BufferedImage sprite;

    public Entity(int x, int y, int width, int height, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }


    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
