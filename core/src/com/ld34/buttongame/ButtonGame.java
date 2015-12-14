package com.ld34.buttongame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;

public class ButtonGame extends Game {
    MenuScreen menuScreen;
    LevelScreen levelScreen;
    public boolean isRunning;
    private Screen currentScreen;
    Level currentLevel;
    private SelectionScreen selectionScreen;
    Preferences prefs;
	private DialogueScreen dialogueScreen;
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
        Gdx.app.exit();
    }

    public void restart() {
        startLevel(Level.get(this, currentLevel.getNumber()));
    }

    void start() {
        isRunning = true;
        currentLevel = new Level1(this);
        levelScreen = new LevelScreen(this);
        selectionScreen = new SelectionScreen(this);
        dialogueScreen = new DialogueScreen(this);
        currentScreen = dialogueScreen;
    }

    public void handleWin() {
        levelScreen.showWinDialog();
        prefs.putInteger("level", getLevel() + 1);
        currentLevel = currentLevel.getNextLevel();
    }

    public int getLevel(){
        return prefs.getInteger("level",1);
    }

    public void startLevel(Level level) {
        if(level != null) {
            Gdx.app.log("Debug", "Starting level " + level.getNumber());
            buttonOnTheWay = false;
            currentLevel = level;
            currentScreen = levelScreen;
            setScreen(levelScreen);
        }
    }

    public void levelSelect() {
        currentScreen = selectionScreen;
        setScreen(currentScreen);
    }
}
