package com.ld34.buttongame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LevelScreen extends ScreenAdapter {
    ButtonGame game;
    Stage stage;

    public LevelScreen(final ButtonGame game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        stage.addListener(Ressources.EscListener(game));

    }

    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void show() {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.9f, 1);
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCursorCatched(true);
    }

    public void hide () {
        Gdx.input.setCursorCatched(false);
    }

}
