package bomberman;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Game {
    private GameObjectManager goManager;
    private LevelLoader levelLoader;
    private GameScene gameScene;
    private static Game instance;
    private int width, heigh;
    private Game(){

    }
    public void start(Stage primaryStage){
        levelLoader = new LevelLoader();
        levelLoader.loadLevelInfo(1);
        goManager = new GameObjectManager(width, heigh);
        gameScene = new GameScene(goManager, width, heigh);
        levelLoader.loadGameObject(goManager);
        gameScene.setFocusTraversable(true);
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                goManager.getBomber().handleKeyEvent(event);
            }
        });
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                goManager.getBomber().handleKeyEvent(null);
            }
        });
        Group root = new Group();
        root.getChildren().add(gameScene);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }
    public GameObjectManager getGoManager() {
        return goManager;
    }

    public GameScene getGameScene() {
        return gameScene;
    }

    public void update(){
        gameScene.update();
    }

    public int getWidth() {
        return width;
    }

    public int getHeigh() {
        return heigh;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }
}
