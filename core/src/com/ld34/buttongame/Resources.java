package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
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
    final Texture cursor;
    final Texture cursorPressed;
    final Texture floor;
    private Skin skin;

    final static float PIXELS_TO_METERS = 100f;
    final static boolean DEBUG = true;
    private static Resources instance = null;
    
    final String[] prologue;
    final Color[] prologueColor;
    final int[] prologueAlign;
    final int prologueLength = 8;
    
    final String[] finalDialogue;
    final Color[] finalDialogueColor;
    final int[] finalDialogueAlign;
    final int finalDialogueLength = 8;
    

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
        
        prologue = new String[prologueLength];
        prologueColor = new Color[prologueLength];
        prologueAlign = new int[prologueLength];
        
        prologueColor[0] = Color.WHITE;
        prologue[0] = "TOCK, TOCK ...";
        prologueAlign[0] = Align.center;
        
        prologueColor[1] = Color.RED;
        prologue[1] = "Jimmy: Who is that?";
        prologueAlign[1] = Align.right;
        
        prologueColor[2] = Color.YELLOW;
        prologue[2] = "Prof Zipper: Jimmy Two-Button, the legendary button sniper!" +
        		" ..., I knew, I would find you here ...";      
        prologueAlign[2] = Align.left;
        
        prologueColor[3] = Color.RED;
        prologue[3] = "Jimmy: In my appartement?";
        prologueAlign[3] = Align.right;
        
        prologueColor[4] = Color.YELLOW;
        prologue[4] = "Prof Zipper: You must help us! Captain Calamari broke into my laboratory" +
        		" and stole my new mutation elixir. If he figures out how to use it ...";
        prologueAlign[4] = Align.left;
        
        prologueColor[5] = Color.RED;
        prologue[5] = "Jimmy: Wait, ... I know you! You are Professor Zipper!";
        prologueAlign[5] = Align.right;
        
        prologueColor[6] = Color.YELLOW;
        prologue[6] = "Prof. Zipper: Junior-Professor..., but yes! Please, he took the elixir to his secret base" +
        		" under the city harbor, quayside 23. \n Only a master button sniper could enter his hideout" +
        		" and survive.";
        prologueAlign[6] = Align.left;
        
        prologueColor[7] = Color.RED;
        prologue[7] = "Jimmy: Don't worry. I'm on it!";
        prologueAlign[7] = Align.right;
        
        // Final Dialogue!
        
        finalDialogue = new String[finalDialogueLength];
        finalDialogueColor = new Color[finalDialogueLength];
        finalDialogueAlign = new int[finalDialogueLength];
        
        finalDialogueColor[0] = Color.CYAN;
        finalDialogue[0] = "BLAST! ...";
        finalDialogueAlign[0] = Align.center;
        
        finalDialogueColor[1] = Color.RED;
        finalDialogue[1] = "Jimmy: That can't be good.";
        finalDialogueAlign[1] = Align.right;
        
        finalDialogueColor[2] = Color.CYAN;
        finalDialogue[2] = "Captain Calamari: Who dares to intrude into my secret hideout? I will" +
        		" devour your bones! Arrr!";      
        finalDialogueAlign[2] = Align.left;
        
        finalDialogueColor[3] = Color.RED;
        finalDialogue[3] = "Jimmy: My bones?";
        finalDialogueAlign[3] = Align.right;
        
        finalDialogueColor[4] = Color.CYAN;
        finalDialogue[4] = "Captain Calamari: Jimmy Two-Button! Of course! Who else would be so brashly stupid to come" +
        		" into my lair with nothing more than two rotting buttons!";
        finalDialogueAlign[4] = Align.left;
        
        finalDialogueColor[5] = Color.RED;
        finalDialogue[5] = "Jimmy: Yeah ... ";
        finalDialogueAlign[5] = Align.right;
        
        finalDialogueColor[6] = Color.CYAN;
        finalDialogue[6] = "Captain Calamari: Once I mutate all my aquatic allies, noone can stop me from" +
        		" taking over the world. Arrr!";
        finalDialogueAlign[6] = Align.left;
        
        finalDialogueColor[7] = Color.RED;
        finalDialogue[7] = "Jimmy: We'll see about that, Captain!";
        finalDialogueAlign[7] = Align.right;
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
