package bomberman.Entity;

import javafx.scene.image.Image;

public abstract class MovableObject extends GameObject {
    protected Status status;
    protected int speed;
    protected boolean alive;
    protected boolean isMoving;
    protected Image[][] imageLists;
    protected int indexOfFrame = 0;
    public abstract void kill();

    public abstract boolean checkCollideCharacter();

    public void move(int addX, int addY){
        if(canMove(x + addX, y + addY)){
            x += addX;
            y += addY;
        }
    }

    @Override
    public void render() {
        gc.drawImage(imageLists[status.getVal()][indexOfFrame % imageLists[status.getVal()].length], x, y, width, heigh);
    }

    public boolean checkCollideFixedObject(int posX, int posY){
        return false;
    }
    public boolean canMove(int newX, int newY){
        return !checkCollideFixedObject(newX, newY);
    }
}
