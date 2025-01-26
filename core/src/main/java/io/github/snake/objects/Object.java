package io.github.snake.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

abstract class Object extends Actor {

    protected int x;
    protected int y;
    protected int scale;
    protected int size;
    protected Texture texture;

    protected Object(int x, int y, int scale, Texture texture){
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.size = texture.getWidth()*scale;
        this.texture = texture;
    }

    public int getCordX() {
        return this.x;
    }

    public int getCordY(){
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
