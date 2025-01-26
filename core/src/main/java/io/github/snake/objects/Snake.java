package io.github.snake.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snake extends Object{

    private Vector2 offset;
    private List<SnakeSegment> segments;
    private Stage stage;

    public Snake(int x, int y, int scale, Texture texture, Vector2 offset, Stage stage){
        super(x, y, scale, texture);
        this.offset = offset;
        segments = new ArrayList<>();
        this.stage = stage;
        addSegment();
    }

    @Override
    public void act(float delta) {
        for(int x = segments.size()-1; x > 0; x--){
            SnakeSegment currentSegment = segments.get(x);
            System.out.println(currentSegment.getX());
            segments.get(x).setX(segments.get(x-1).getCordX());
            segments.get(x).setY(segments.get(x-1).getCordY());
        }

        segments.get(0).move();
    }

    public void checkCollision(List<Point> pointList){
        for(Point point : pointList){
            for(SnakeSegment segment : segments){
                if(point.y == segment.y && point.x == segment.x){
                    Random  random = new Random();
                    int randX = random.nextInt(10);
                    int randY = random.nextInt(10);
                    while(randX == point.getX()) randX = random.nextInt(10);
                    while(randY == point.getY()) randY = random.nextInt(10);

                    point.setX(randX);
                    point.setY(randY);
                    addSegment();
                    return;
                }
            }
        }
    }

    private void addSegment(){
        if(segments.isEmpty()){
            segments.add(new SnakeSegment(x,y,scale,texture,new Vector2(-1,0),offset, stage));
            return;
        }
        SnakeSegment lastSegment = segments.get(segments.size() -1);
        Vector2 lastSegmentVel = lastSegment.getVelocity();
        Vector2 newSegmentPosition = new Vector2(lastSegment.x- lastSegmentVel.x, lastSegment.y-lastSegmentVel.y);
        segments.add(new SnakeSegment((int) newSegmentPosition.x, (int) newSegmentPosition.y,scale,texture,new Vector2(0,0),offset, stage));
    }

    public void setVelocity(Vector2 velocity) {
        Vector2 segmentVelocity = segments.get(0).getVelocity();
        if(segmentVelocity.x != -velocity.x || segmentVelocity.y != -velocity.y){

            segments.get(0).setVelocity(velocity);
        }
    }

}
