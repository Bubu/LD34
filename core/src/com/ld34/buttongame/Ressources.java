package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public final class Ressources {
    private Skin skin;
    private static Ressources instance = null;

    public static Ressources getInstance() {
        if(instance == null) {
            instance = new Ressources();
        }
        return instance;
    }

    private Ressources() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
    }

    public static Skin Skin(){
        return getInstance().skin;
    }

    public static EventListener EscListener(final ButtonGame game) {
        InputListener esclistner = new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if(keycode == Input.Keys.ESCAPE ){
                    game.setScreen(game.menuScreen);
                    return true;
                }
                else{
                    return false;
                }
            }
        };
        return esclistner;

    }
}
