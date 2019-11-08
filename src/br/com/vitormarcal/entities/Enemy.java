package br.com.vitormarcal.entities;

import br.com.vitormarcal.main.Game;
import br.com.vitormarcal.world.Camera;
import br.com.vitormarcal.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends Entity {

    private double speed = 0.8;

    private int frames = 0;
    private int maxFrames = 20;
    private int index = 0;
    private int maxIndex = 1;

    private BufferedImage[] sprites;

    public Enemy(int x, int y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, null);
        sprites = new BufferedImage[2];
        sprites[0] = Game.spritesheet.getSprite(112, 16, 16, 16);
        sprites[1] = Game.spritesheet.getSprite(112 + 16, 16, 16, 16);
    }

    @Override
    public void tick() {
        if (Game.rand.nextInt(100) < 30) {
            if ((int) x < Game.player.getX() && World.isFree((int) (x + speed), this.getY())) {
                x += speed;
            } else if ((int) x > Game.player.getX() && World.isFree((int) (x - speed), this.getY())) {
                x -= speed;
            }

            if ((int) y < Game.player.getY() && World.isFree(this.getX(), (int) (y + speed))) {
                y += speed;
            } else if ((int) y > Game.player.getY() && World.isFree(this.getX(), (int) (y - speed))) {
                y -= speed;
            }
        }


        frames++;
        if (frames == maxFrames) {
            frames = 0;
            index++;
            if (index > maxIndex) {
                index = 0;
            }
        }


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprites[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
    }
}
