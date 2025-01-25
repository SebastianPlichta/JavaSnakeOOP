package io.github.snake.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Snake extends Object{

    private Vector2 offset;
    private Vector2 velocity;

    public Snake(int x, int y, int scale, Texture texture, Vector2 offset){
        super(x, y, scale, texture);
        this.offset = offset;
        velocity = new Vector2(0,1);
    }

    @Override
    public void act(float delta) {
        this.x += velocity.x;
        this.y += velocity.y;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, x*size+offset.x,y*size+offset.y, size, size);
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
}
