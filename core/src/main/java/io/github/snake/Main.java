package io.github.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.snake.managers.GameManager;
import io.github.snake.managers.GridManager;
import io.github.snake.managers.TextureManager;
import io.github.snake.objects.Point;
import io.github.snake.objects.Snake;

import java.util.Vector;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private OrthographicCamera camera;
    private Stage stage;
    private FitViewport viewport;

    private GameManager gameManager;

    private Snake snake;

    private float time;
    private static final int SCALE = 4;

    @Override
    public void create() {

        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();


        camera = new OrthographicCamera(width,height);
        viewport = new FitViewport(width,height,camera);
        stage = new Stage(viewport);

        gameManager = new GameManager(stage,SCALE,width,height);

        snake = new Snake(4,4,SCALE,gameManager.textureManager.getSnake(),gameManager.gridManager.getOffset(), stage);

        stage.addActor(snake);

        gameManager.addPoint(5,5,SCALE);

        camera.update();
        Gdx.input.setInputProcessor(stage);


    }

    @Override
    public void render() {
        inputHandler();
        update(Gdx.graphics.getDeltaTime());
        draw();

    }

    private void inputHandler(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.A)){
            snake.setVelocity(new Vector2(-1,0));
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.D)){
            snake.setVelocity(new Vector2(1,0));
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.W)){
            snake.setVelocity(new Vector2(0,1));
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.S)){
            snake.setVelocity(new Vector2(0,-1));
        }
    }

    private void update(float deltaTime){
        time += deltaTime;
        snake.checkCollision(gameManager.getPointList());
        if(time > 0.2){
            stage.act(deltaTime);
            time = 0;
        }
    }

    private void draw(){

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
