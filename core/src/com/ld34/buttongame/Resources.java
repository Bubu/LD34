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
    public final Sound clack;
    public final Sound click;
    public final Sound on;
    public final Sound off;
    public final Sound powerdown;
    public final Texture cursor;
    final Texture cursorPressed;
    public final Texture floor;
    public final Texture bg_level;
    private Skin skin;

    public final static float PIXELS_TO_METERS = 100f;
    public final static boolean DEBUG = false;
    private static Resources instance = null;
    
    public final String[] prologue;
    public final Color[] prologueColor;
    public final int[] prologueAlign;
    public final int prologueLength = 8;
    
    public final String[] finalDialogue;
    public final Color[] finalDialogueColor;
    public final int[] finalDialogueAlign;
    public final int finalDialogueLength = 8;
    
    public final String[] epilogue;
    public final Color[] epilogueColor;
    public final int[] epilogueAlign;
    public final int epilogueLength = 8;
    
    public final String[] interlude;
    public final Color[] interludeColor;
    public final int[] interludeAlign;
    public final int interludeLength = 10;
	public Texture bg_menu;

    public static Resources getInstance() {
        if(instance == null) {
            instance = new Resources();
        }
        return instance;
    }

    private Resources() {
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        cursor = new Texture(Gdx.files.internal("graphics/ButtonBlue.png"));
        bg_level = new Texture(Gdx.files.internal("graphics/bg_level.png"));
        bg_menu = new Texture(Gdx.files.internal("graphics/bg_title.png"));

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
        
        // Interlude
        
        interlude = new String[interludeLength];
        interludeColor = new Color[interludeLength];
        interludeAlign = new int[interludeLength];
        
        interludeColor[0] = Color.WHITE;
        interlude[0] = "RING, RING ...";
        interludeAlign[0] = Align.center;
        
        interludeColor[1] = Color.RED;
        interlude[1] = "Jimmy: I should have turned off my phone ... Hello?";
        interludeAlign[1] = Align.right;
        
        interludeColor[2] = Color.YELLOW;
        interlude[2] = "Prof Zipper: Thank god, Jimmy, you are still alive." ; 
        interludeAlign[2] = Align.left;
        
        interludeColor[3] = Color.RED;
        interlude[3] = "Jimmy: Listen, I can't really talk right now ... ";
        interludeAlign[3] = Align.right;
        
        interludeColor[4] = Color.YELLOW;
        interlude[4] = "Prof Zipper: But I must warn you! My gravitational measurements show that" +
        		" Captain Calamari uses a powerful space-time concentrator.";
        interludeAlign[4] = Align.left;
        
        interludeColor[5] = Color.RED;
        interlude[5] = "Jimmy: What?";
        interludeAlign[5] = Align.right;
        
        interludeColor[6] = Color.YELLOW;
        interlude[6] = "Prof. Zipper: It's a device that warps gravity.";
        interludeAlign[6] = Align.left;
        
        interludeColor[7] = Color.RED;
        interlude[7] = "Jimmy: Wow ... Awesome!";
        interludeAlign[7] = Align.right;
        
        interludeColor[8] = Color.YELLOW;
        interlude[8] = "Prof. Zipper: It is not awesome, it is dangerous! You are not" +
        		" prepared for that.";
        interludeAlign[8] = Align.left;
        
        interludeColor[9] = Color.RED;
        interlude[9] = "Jimmy: Let's see ...";
        interludeAlign[9] = Align.right;
        
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
        finalDialogue[2] = "Captain Calamari: Who dares t'intrude into me secret hideout? I will" +
        		" devour yer bones! Arrr!";      
        finalDialogueAlign[2] = Align.left;
        
        finalDialogueColor[3] = Color.RED;
        finalDialogue[3] = "Jimmy: My bones?";
        finalDialogueAlign[3] = Align.right;
        
        finalDialogueColor[4] = Color.CYAN;
        finalDialogue[4] = "Captain Calamari: Jimmy Two-Button, thee scurvy lubber! F'course! Who else would be so brashly stupid t'come" +
        		" into my lair with nothing more than two rotting buttons!";
        finalDialogueAlign[4] = Align.left;
        
        finalDialogueColor[5] = Color.RED;
        finalDialogue[5] = "Jimmy: True ... ";
        finalDialogueAlign[5] = Align.right;
        
        finalDialogueColor[6] = Color.CYAN;
        finalDialogue[6] = "Captain Calamari: Avast! Once I mutate all me aquatic allies," +
        		" none of ye lice-'nfested bilge-rats can stop me from" +
        		" taking o'er the world. Arrr!";
        finalDialogueAlign[6] = Align.left;
        
        finalDialogueColor[7] = Color.RED;
        finalDialogue[7] = "Jimmy: We'll see about that, Captain!";
        finalDialogueAlign[7] = Align.right;
        
        // Epilogue
        
        epilogue = new String[epilogueLength];
        epilogueColor = new Color[epilogueLength];
        epilogueAlign = new int[epilogueLength];
        
        epilogueColor[0] = Color.CYAN;
        epilogue[0] = "NOOOOOO! ... ";
        epilogueAlign[0] = Align.center;
        
        epilogueColor[1] = Color.RED;
        epilogue[1] = "Jimmy: Sorry.";
        epilogueAlign[1] = Align.right;
        
        epilogueColor[2] = Color.CYAN;
        epilogue[2] = "Captain Calamari: Ye'll meet the rope's end for that, me bucko! Ye n'yer stupid buttons ruined everything!" +
        		" ... the elixir! ... Me can feel myself mut'ting ... Curse ye, Jimmy Two-Button, by the mighty sea, curse yeeee!";      
        epilogueAlign[2] = Align.left;
        
        epilogueColor[3] = Color.RED;
        epilogue[3] = "Jimmy: Sorry, man.";
        epilogueAlign[3] = Align.right;
        
        epilogueColor[4] = Color.CYAN;
        epilogue[4] = "Captain Calamari: What is this? Me have returned to ma human form. " +
        		" The mutation elixir must have repaired me epig'netic histone modif'cation. Oh, most joyous of all th'days!" +
        		" Thank ye, Jimmy Two-Button, thank ye!";
        epilogueAlign[4] = Align.left;
        
        epilogueColor[5] = Color.RED;
        epilogue[5] = "Jimmy: No biggie. ";
        epilogueAlign[5] = Align.right;
        
        epilogueColor[6] = Color.CYAN;
        epilogue[6] = "Captain Calamari: Arrr! T'is a biggie! Tell me, what you want and I'll do it for ye.";
        epilogueAlign[6] = Align.left;
        
        epilogueColor[7] = Color.RED;
        epilogue[7] = "Jimmy: Do you still have any fish sticks? I am starving!";
        epilogueAlign[7] = Align.right;
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
