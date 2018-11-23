package bomberman;
import javafx.scene.canvas.Canvas;
import javafx.stage.Screen;

public class GameScene extends Canvas {
    public static final int GAMETILE_SIZE = 16;
    private GameObjectManager goManager;
    public GameScene(GameObjectManager gameObjectManager){
        super(Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
        goManager = gameObjectManager;
    }
    public void update(){
        for(int i = 0; i < goManager.getFixedObjectList().length; i++){
            for(int j = 0; j < goManager.getFixedObjectList()[i].length; j++){
                goManager.getFixedObjectList()[i][j].update();
            }

        }
        for(int i = 0; i < goManager.getCharacters().size(); i++){
            goManager.getCharacters().get(i).update();
        }
    }


}