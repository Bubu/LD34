package com.ld34.buttongame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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
	private DialogueScreen dialogueScreen;

    @Override
	public void create () {
        menuScreen = new MenuScreen(this);
        setScreen(menuScreen);
	}

    public void resumeGame() {
        if(!isRunning) start();
        setScreen(currentScreen);
    }

    public void quit() {
        Gdx.app.exit();
    }

    public void restart() {
        start();
        resumeGame();
    }

    void start() {
        isRunning = true;
        currentLevel = new Level1(this);
        levelScreen = new LevelScreen(this);
        dialogueScreen = new DialogueScreen(this);
        currentScreen = dialogueScreen;
    }

    public void handleWin() {
        levelScreen.showWinDialog();
        currentLevel = currentLevel.getNextLevel();
    }
}
