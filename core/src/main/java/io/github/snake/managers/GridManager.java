package io.github.snake.managers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import io.github.snake.objects.GridTile;

import java.util.ArrayList;
import java.util.List;

public class GridManager {

    private int width;
    private int heigth;
    private List<List<GridTile>> gridMap;
    private Stage stage;
    private Vector2 offset;
    private int scale;
    private Texture gridTexture;

    public GridManager(int width, int heigth, Stage stage, int scale, TextureManager textureManager, int windowWidth, int windowHeight){
        this.width = width;
        this.heigth = heigth;
        this.stage = stage;
        this.gridTexture = textureManager.getGrid();
        this.scale = scale;
        this.offset = new Vector2(windowWidth/2 - gridTexture.getWidth()*width*scale/2, windowHeight/2 - gridTexture.getHeight()*heigth*scale/2);
        gridMap = new ArrayList<>();
    }

    public void createGrid(){

        for(int y = 0; y < heigth; y++){
            List<GridTile> row = new ArrayList<>();
            for(int x = 0; x < width; x++){
                GridTile newTile = new GridTile(x,y,scale,gridTexture,offset);
                row.add(newTile);
                stage.addActor(newTile);
            }
            gridMap.add(row);
        }

    }

    public Vector2 getOffset() {
        return offset;
    }
}
