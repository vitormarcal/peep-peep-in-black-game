package br.com.vitormarcal.entities;

import br.com.vitormarcal.main.Game;
import br.com.vitormarcal.world.World;

import java.awt.image.BufferedImage;

public class Enemy extends Entity {

    private double speed = 1;

    public Enemy(int x, int y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, sprite);
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

    }
}
