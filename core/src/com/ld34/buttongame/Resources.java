package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
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
    final Texture cursor;
    final Texture cursorPressed;
    final Texture floor;
    private Skin skin;

    final static float PIXELS_TO_METERS = 100f;
    final static boolean DEBUG = true;
    private static Resources instance = null;

    public static Resources getInstance() {
        if(instance == null) {
            instance = new Resources();
        }
        return instance;
    }

    private Resources() {
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        cursor = new Texture(Gdx.files.internal("graphics/ButtonBlue.png"));
        floor = new Texture(Gdx.files.internal("graphics/Floor.png"));
        cursorPressed = new Texture(Gdx.files.internal("graphics/ButtonPressed.png"));
        new Texture(Gdx.files.internal("graphics/TriggerOff.png"));
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
