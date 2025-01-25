package io.github.snake.managers;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameManager {


    public GridManager gridManager;
    public TextureManager textureManager;


    public GameManager(Stage stage, int SCALE, int width,int height){
        textureManager = new TextureManager();
        gridManager = new GridManager(5,5,stage,SCALE,textureManager, width, height);
        gridManager.createGrid();
    }



}
