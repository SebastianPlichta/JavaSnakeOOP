package io.github.snake.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

    private Texture snake;
    private Texture grid;
    private Texture point;

    public TextureManager(){
        initialize();
    }

    private void initialize(){
        snake = new Texture(Gdx.files.internal("snakesegment.png"));
        grid = new Texture(Gdx.files.internal("grid.png"));
        point = new Texture(Gdx.files.internal("point.png"));
    }

    public Texture getSnake() {
        return snake;
    }

    public Texture getGrid() {
        return grid;
    }

    public Texture getPoint() {
        return point;
    }
}
