package io.github.snake.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SnakeSegment extends Object{

    private Vector2 velocity;
    private Vector2 offset;

    public SnakeSegment(int x, int y, int scale, Texture texture, Vector2 velocity, Vector2 offset, Stage stage) {
        super(x, y, scale, texture);
        this.velocity = velocity;
        this.offset = offset;
        stage.addActor(this);

    }

    public void move(){
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

    public Vector2 getVelocity() {
        return velocity;
    }
}
