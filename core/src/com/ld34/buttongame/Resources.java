package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public final class Resources {
    final Sound clack;
    final Sound click;
    final Sound on;
    final Sound off;
    final Sound powerdown;
    private Skin skin;

    final static float PIXELS_TO_METERS = 100f;
    final static boolean DEBUG = true;
    final static int BUTTON_RADIUS = 25;
    private static Resources instance = null;

    public static Resources getInstance() {
        if(instance == null) {
            instance = new Resources();
        }
        return instance;
    }

    private Resources() {
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        clack = Gdx.audio.newSound(Gdx.files.internal("sounds/clack.wav"));
        click = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
        on = Gdx.audio.newSound(Gdx.files.internal("sounds/switch_on.wav"));
        off = Gdx.audio.newSound(Gdx.files.internal("sounds/switch_off.wav"));
        powerdown = Gdx.audio.newSound(Gdx.files.internal("sounds/powerdown_full.wav"));
    }

    public static Skin Skin(){
        return getInstance().skin;
    }

    public static EventListener EscListener(final ButtonGame game) {
        return new InputListener() {
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

    }
}
