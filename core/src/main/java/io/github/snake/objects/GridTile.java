package io.github.snake.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GridTile extends Object {

    private Vector2 offset;

    public GridTile(int x, int y, int scale, Texture texture, Vector2 offset){
        super(x, y, scale, texture);
        this.offset = offset;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, x*size+offset.x,y*size+offset.y, size, size);
    }

}
