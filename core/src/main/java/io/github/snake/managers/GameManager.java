package io.github.snake.managers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import io.github.snake.objects.Point;

import java.util.ArrayList;
import java.util.List;

public class GameManager {


    public GridManager gridManager;
    public TextureManager textureManager;
    public List<Point> pointList;

    private Stage stage;


    public GameManager(Stage stage, int SCALE, int width,int height){
        textureManager = new TextureManager();
        gridManager = new GridManager(10,10,stage,SCALE,textureManager, width, height);
        gridManager.createGrid();
        pointList = new ArrayList<>();
        this.stage = stage;
    }

    public void addPoint(int x, int y,int scale){
        pointList.add(new Point(x,y,scale,textureManager.getPoint(),gridManager.getOffset(),stage));
    }

    public List<Point> getPointList() {
        return pointList;
    }
}
