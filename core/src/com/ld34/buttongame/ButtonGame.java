package com.ld34.buttongame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.gui.EpilogueScreen;
import com.ld34.buttongame.gui.FinalDialogueScreen;
import com.ld34.buttongame.gui.InterludeScreen;
import com.ld34.buttongame.gui.LevelScreen;
import com.ld34.buttongame.gui.MenuScreen;
import com.ld34.buttongame.gui.PrologueScreen;
import com.ld34.buttongame.gui.SelectionScreen;
import com.ld34.buttongame.level.Level2;
import com.ld34.buttongame.level.Level3;
import com.ld34.buttongame.level.Level5;

public class ButtonGame extends Game {
    com.ld34.buttongame.gui.MenuScreen menuScreen;
    public com.ld34.buttongame.gui.LevelScreen levelScreen;
    public boolean isRunning;
    private Screen currentScreen;
    public com.ld34.buttongame.level.Level currentLevel;
    private com.ld34.buttongame.gui.SelectionScreen selectionScreen;
    Preferences prefs;
	private com.ld34.buttongame.gui.PrologueScreen prologueScreen;
	private com.ld34.buttongame.gui.FinalDialogueScreen finalDialogueScreen;
    public boolean buttonOnTheWay = false;
    public boolean isWinning;
	private EpilogueScreen epilogueScreen;
	private Screen interludeScreen;
	private boolean interlude;
	private boolean finalDialogue;
	private boolean epilogue;

    @Override
	public void create () {
        menuScreen = new MenuScreen(this);
        setScreen(menuScreen);
        prefs = Gdx.app.getPreferences("Preferences");
}

    public void resumeGame() {
        if(!isRunning) start();
        setScreen(currentScreen);
    }

    public void quit() {
        Gdx.app.exit();
    }

    public void restart() {
        startLevel(currentLevel);
    }

    void start() {
        isRunning = true;
        currentLevel = new com.ld34.buttongame.level.Level1(this);
        levelScreen = new LevelScreen(this);
        selectionScreen = new SelectionScreen(this);
        prologueScreen = new PrologueScreen(this);
        epilogueScreen = new EpilogueScreen(this);
        finalDialogueScreen = new FinalDialogueScreen(this);
        interludeScreen = new InterludeScreen(this);
        interlude = true;
        finalDialogue = true;
        epilogue = true;
        
        currentScreen = prologueScreen;
    }

    public void handleWin() {
        levelScreen.showWinDialog();
        prefs.putInteger("level", getLevel() + 1);
        prefs.flush();
        startLevel(currentLevel.getNextLevel());
    }

    public int getLevel(){
        return prefs.getInteger("level",1);
    }

    public void startLevel(com.ld34.buttongame.level.Level level) {
        if(level != null) {
        	
        	Gdx.app.log("Here", level + "");
        	
        	if(level instanceof Level5 && interlude){
        		currentScreen = interludeScreen;
        		setScreen(currentScreen);
        		interlude = false;
        	}else if(level instanceof Level2 && finalDialogue){
        		currentScreen = finalDialogueScreen;
        		setScreen(currentScreen);
        		finalDialogue = false;
        	}else if(level instanceof Level3 && epilogue){
        		currentScreen = epilogueScreen;
        		setScreen(currentScreen);
        		epilogue = false;
        	}else{
        	
            Timer.instance().clear();
            Resources.getInstance().powerdown.stop();
            levelScreen.restart.setVisible(false);
            buttonOnTheWay = false;
            isWinning = false;
            currentLevel = level;
            currentLevel.init();
            currentScreen = levelScreen;
            setScreen(levelScreen);
        	}
        }
    }

    public void levelSelect() {
        currentScreen = selectionScreen;
        setScreen(currentScreen);
    }
}
