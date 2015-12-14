package com.ld34.buttongame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen extends ScreenAdapter {
    ButtonGame game;
    Stage stage;
    TextButton startbutton;
    TextButton quitbutton;
    TextButton restartbutton;
    private VerticalGroup group;
    private final TextButton selectButton;

    public MenuScreen(final ButtonGame game) {
        this.game = game;

        stage = new Stage(new ScreenViewport());
        stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if(keycode == Input.Keys.ESCAPE && game.isRunning){
                    game.resumeGame();
                    return true;
                }
                else{
                    return false;
                }
            }
        });

        group = new VerticalGroup();
        stage.addActor(group);
        group.center();
        Label titel = new Label("Button Sniper", Resources.Skin().get("title",LabelStyle.class));
        group.addActor(titel);
        startbutton = new TextButton("Start the game!", Resources.Skin());
        startbutton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.resumeGame();
            }
        });

        restartbutton = new TextButton("Restart Level!", Resources.Skin());
        restartbutton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.restart();
            }
        });

        selectButton = new TextButton("Select Level!", Resources.Skin());
        selectButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.levelSelect();
            }
        });

        quitbutton = new TextButton("Quit", Resources.Skin());
        quitbutton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.quit();
            }
        });
        group.addActor(startbutton);
        group.addActor(selectButton);
        group.addActor(quitbutton);
        group.space(20);
        group.padBottom(300);
        group.setSize(group.getPrefWidth(), group.getPrefHeight());
        group.setPosition((stage.getWidth() - group.getWidth()) / 2, (stage.getHeight() - group.getHeight()) / 2);
    }

    @Override
    public void show() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.input.setInputProcessor(stage);
        if(game.isRunning){
            selectButton.setVisible(true);
            startbutton.setText("Resume");
            group.addActorAt(2,restartbutton);
        }
        else{
            selectButton.setVisible(false);
        }
    }

    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void dispose () {
        stage.dispose();
    }
}
