package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public class LevelScreen extends ScreenAdapter {
    private final SpriteBatch batch;
    private final Sprite buttonBlue;
    ButtonGame game;
    InputHandler inputHandler;
    OrthographicCamera camera;
    Box2DDebugRenderer debugRenderer;
    Matrix4 debugMatrix;
    Cursor customCursor;

    public LevelScreen(final ButtonGame game) {
        customCursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("graphics/EmptyCursor.png")), 0, 0);
    	camera= new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        if(Resources.DEBUG){
            debugRenderer = new Box2DDebugRenderer();
        }
        this.game = game;
        this.inputHandler = new InputHandler(game);
        this.batch = new SpriteBatch();
        Texture img = new Texture(Gdx.files.internal("graphics/ButtonBlue.png"));
        this.buttonBlue = new Sprite(img);
    }

    public void render(float delta) {
        camera.update();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.currentLevel.world.step(1f / 60f, 8, 3);
        batch.setProjectionMatrix(camera.combined);
        debugMatrix = batch.getProjectionMatrix().cpy().scale(Resources.PIXELS_TO_METERS,
                Resources.PIXELS_TO_METERS, 0);
        batch.begin();
        for(GameObject object:game.currentLevel.objects) {
            object.draw(batch);
        }
        Vector3 worldCoords = camera.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0));
        buttonBlue.setCenter(worldCoords.x, worldCoords.y);
        buttonBlue.draw(batch);
        batch.end();
        if(Resources.DEBUG) {
            debugRenderer.render(game.currentLevel.world, debugMatrix);
        }
    }

    public void resize (int width, int height) {
    }

    public void show() {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.9f, 1);
        Gdx.input.setInputProcessor(this.inputHandler);
        Gdx.graphics.setCursor(customCursor);
    }

    public void hide () {
        Gdx.graphics.setCursor(null);
    }

    public void dispose() {
    }

}
