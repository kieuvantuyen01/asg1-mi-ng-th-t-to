package bomberman.Entity;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Enemy extends MovableObject{
    public abstract Status generateMove();
    //viết nốt hàm kill
    //cập nhật ảnh lên
    //nhắc viết todo
    @Override
    public void kill() {
        this.status=Status.DEAD;
        gc.drawImage(imageLists[status.getVal()][indexOfFrame % imageLists[status.getVal()].length], x, y, width, heigh);
    }
    @Override
    public boolean checkCollideCharacter(MovableObject movableObject) {
        Rectangle2D recThis=new Rectangle(this.x,this.y,this.width,this.heigh);
        Rectangle2D recMovableObject=new Rectangle( movableObject.x,
                                                    movableObject.y,
                                                    movableObject.width,
                                                    movableObject.heigh);
        if(((Rectangle) recThis).intersects(recMovableObject)) return true;
        else return false;
    }
}
