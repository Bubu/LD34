package com.ld34.buttongame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class LevelScreen extends ScreenAdapter {
    private final SpriteBatch batch;
    ButtonGame game;
    RigidBody buttonRed;
    World world;
    private InputProcessor input;
    OrthographicCamera camera;

    public LevelScreen(final ButtonGame game) {
    	camera= new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    	camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.game = game;
        this.input = new InputHandler(game);
        this.batch = new SpriteBatch();
        this.world = new World(new Vector2(0, 0f), true);
        this.buttonRed = new RigidBody("ButtonRed.png", world,
                Gdx.graphics.getWidth() / 2,
                Gdx.graphics.getHeight() / 2);
    }

    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        batch.begin();
        buttonRed.draw(batch);
        batch.end();
    }

    public void resize (int width, int height) {
    }

    public void show() {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.9f, 1);
        Gdx.input.setInputProcessor(this.input);
        //Gdx.input.setCursorCatched(true);
    }

    public void hide () {
        Gdx.input.setCursorCatched(false);
    }

    public void dispose() {
        world.dispose();
    }

}
