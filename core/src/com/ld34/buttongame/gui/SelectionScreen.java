package com.ld34.buttongame.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;

import java.util.ArrayList;

public class SelectionScreen extends ScreenAdapter {
    ButtonGame game;
    Stage stage;
    ArrayList<TextButton> buttonList;
    public SelectionScreen(final ButtonGame game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        stage.addListener(Resources.EscListener(game));
        buttonList = new ArrayList<TextButton>();
        Table table = new Table();
        stage.addActor(table);
        table.align(Align.top);
        table.setFillParent(true);
        Label title = new Label("Select a Level!", Resources.Skin().get("title",Label.LabelStyle.class));
        Table levelTable = new Table();
        if(Resources.DEBUG) levelTable.setDebug(true);

        int level = game.getLevel();
        for(int i=1; i<=20; i++){
            TextButton button = new TextButton(Integer.toString(i), Resources.Skin());
            buttonList.add(button);
            final int finalI = i;
            button.addListener(new ChangeListener() {
                public void changed (ChangeEvent event, Actor actor) {
                    game.startLevel(com.ld34.buttongame.level.Level.get(game, finalI));
                }
            });
            if(i > level) {
                button.setDisabled(true);
            }
            levelTable.add(button).size(60).pad(10);
            if(i%8 == 0) levelTable.row();
        }
        table.add(title).padTop(50).padBottom(100);
        table.row();
        table.add(levelTable);
    }

    @Override
    public void show() {
        Gdx.gl.glClearColor(0.7f, 0.3f, 0.9f, 1);
        Gdx.input.setInputProcessor(stage);
        updateButtons();
    }

    private void updateButtons() {
        int i = 1;
        int level = game.getLevel();
        for(TextButton button:buttonList){
            if(i <= level || Resources.DEBUG){
                button.setDisabled(false);
            }
            i++;
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.getBatch().begin();
        stage.getBatch().draw(Resources.getInstance().bg_level, 0,0);
        stage.getBatch().end();
        stage.draw();
    }

    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void dispose () {
        stage.dispose();
    }
}
