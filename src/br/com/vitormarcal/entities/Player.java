package br.com.vitormarcal.entities;

import br.com.vitormarcal.main.Game;
import br.com.vitormarcal.world.Camera;
import br.com.vitormarcal.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    public boolean right;
    public boolean left;
    public boolean up;
    public boolean down;

    private int right_dir = 0, left_dir = 1;
    private int dir = right_dir;

    private int frames = 0;
    private int maxFrames = 5;
    private int index = 0;
    private int maxIndex = 3;
    private boolean moved = false;
    private BufferedImage[] rigthPlayer;
    private BufferedImage[] leftPlayer;

    private final double speed = 1.4;

    public Player(int x, int y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, sprite);

        rigthPlayer = new BufferedImage[4];
        leftPlayer = new BufferedImage[4];

        for (int i = 0; i < 4; i++) {
            rigthPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 0, 16, 16);
            leftPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 16, 16, 16);
        }
    }

    public void tick() {
        moved = false;
        if (right && World.isFree((int) (x + speed), this.getY())) {
            moved = true;
            dir = right_dir;
            x += speed;
        } else if (left && World.isFree((int) (x - speed), this.getY())) {
            moved = true;
            dir = left_dir;
            x -= speed;
        }

        if (up && World.isFree(this.getX(), (int) (y - speed))) {
            moved = true;
            y -= speed;
        } else if (down && World.isFree(this.getX(), (int) (y + speed))) {
            moved = true;
            y += speed;
        }

        if (moved && World.isFree((int) (x + speed), this.getY())) {
            frames++;
            if (frames == maxFrames) {
                frames = 0;
                index++;
                if (index > maxIndex) {
                    index = 0;
                }
            }
        }

        Camera.x = Camera.clamp(this.getX() - (Game.WIDTH / 2), 0, World.WIDTH * 16 - Game.WIDTH);
        Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT / 2), 0, World.HEIGHT * 16 - Game.HEIGHT);
    }

    @Override
    public void render(Graphics g) {

        if (dir == right_dir) {
            g.drawImage(rigthPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
        } else if (dir == left_dir) {
            g.drawImage(leftPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
        }
    }
}
