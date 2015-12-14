package com.ld34.buttongame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.gui.LevelScreen;
import com.ld34.buttongame.gui.MenuScreen;
import com.ld34.buttongame.gui.PrologueScreen;
import com.ld34.buttongame.gui.SelectionScreen;

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
        prefs.flush();
        Gdx.app.exit();
    }

    public void restart() {
        startLevel(com.ld34.buttongame.level.Level.get(this, currentLevel.getNumber()));
    }

    void start() {
        isRunning = true;
        currentLevel = new com.ld34.buttongame.level.Level1(this);
        levelScreen = new LevelScreen(this);
        selectionScreen = new SelectionScreen(this);
        prologueScreen = new PrologueScreen(this);
        finalDialogueScreen = new com.ld34.buttongame.gui.FinalDialogueScreen(this);
        
        currentScreen = finalDialogueScreen;
    }

    public void handleWin() {
        levelScreen.showWinDialog();
        prefs.putInteger("level", getLevel() + 1);
        startLevel(currentLevel.getNextLevel());
    }

    public int getLevel(){
        return prefs.getInteger("level",1);
    }

    public void startLevel(com.ld34.buttongame.level.Level level) {
        if(level != null) {
            Gdx.app.log("Debug", "Starting level " + level.getNumber());
            Timer.instance().clear();
            Resources.getInstance().powerdown.stop();
            levelScreen.restart.setVisible(false);
            buttonOnTheWay = false;
            currentLevel = level;
            currentLevel.init();
            currentScreen = levelScreen;
            setScreen(levelScreen);
        }
    }

    public void levelSelect() {
        currentScreen = selectionScreen;
        setScreen(currentScreen);
    }
}
