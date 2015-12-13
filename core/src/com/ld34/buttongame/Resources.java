package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

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
    
    final String[] Epilogue;
    final Color[] EpilogueColor;
    final int[] EpilogueAlign;
    final int dialogueLength = 8;

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
        
        Epilogue = new String[dialogueLength];
        EpilogueColor = new Color[dialogueLength];
        EpilogueAlign = new int[dialogueLength];
        
        EpilogueColor[0] = Color.WHITE;
        Epilogue[0] = "TOCK, TOCK ...";
        EpilogueAlign[0] = Align.center;
        
        EpilogueColor[1] = Color.RED;
        Epilogue[1] = "Jimmy: Who is that?";
        EpilogueAlign[1] = Align.right;
        
        EpilogueColor[2] = Color.YELLOW;
        Epilogue[2] = "Prof Zipper: Jimmy Two-Button, the legendary button sniper!" +
        		" ..., I knew, I would find you here ...";      
        EpilogueAlign[2] = Align.left;
        
        EpilogueColor[3] = Color.RED;
        Epilogue[3] = "Jimmy: In my appartement?";
        EpilogueAlign[3] = Align.right;
        
        EpilogueColor[4] = Color.YELLOW;
        Epilogue[4] = "Prof Zipper: You must help us! Captain Calamari broke into my laboratory" +
        		" and stole my new mutation elixir. If he figures out how to use it ...";
        EpilogueAlign[4] = Align.left;
        
        EpilogueColor[5] = Color.RED;
        Epilogue[5] = "Jimmy: Wait, ... I know you! You are Professor Zipper!";
        EpilogueAlign[5] = Align.right;
        
        EpilogueColor[6] = Color.YELLOW;
        Epilogue[6] = "Prof. Zipper: Junior-Professor..., but yes! Please, he took the elixir to his secret base" +
        		" under the city harbor, quayside 23. \n Only a master button sniper could enter his hideout" +
        		" and survive.";
        EpilogueAlign[6] = Align.left;
        
        EpilogueColor[7] = Color.RED;
        Epilogue[7] = "Jimmy: Don't worry. I'm on it!";
        EpilogueAlign[7] = Align.right;
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
