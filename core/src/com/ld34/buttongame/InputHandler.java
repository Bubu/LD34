package com.ld34.buttongame;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;


public class InputHandler implements InputProcessor {
    private final ButtonGame game;
	private boolean buttonPressed;

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.ESCAPE ) {
            game.setScreen(game.menuScreen);
            return true;
        }
        else if (keycode == Input.Keys.R){
            game.restart();
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 worldCoords = game.levelScreen.camera.unproject(new Vector3(screenX, screenY,0));
        if(worldCoords.y <=150 || Resources.DEBUG) {
            double dist = Math.sqrt(Math.pow(worldCoords.x - game.currentLevel.buttonRed.getCenterX(), 2.0) + Math.pow(worldCoords.y - game.currentLevel.buttonRed.getCenterY(), 2.0));
            if (dist < game.currentLevel.buttonRed.height) {
                buttonPressed = true;
            }
        }
        game.levelScreen.buttonBlue.setTexture(Resources.getInstance().cursorPressed);
        return false;
    }
    
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector3 worldCoords = game.levelScreen.camera.unproject(new Vector3(screenX, screenY,0));
    	double dist = Math.sqrt(Math.pow(worldCoords.x - game.currentLevel.buttonRed.getCenterX(),2.0) + Math.pow(worldCoords.y - game.currentLevel.buttonRed.getCenterY(), 2.0));
    	if(buttonPressed) {
        	if(dist>game.currentLevel.buttonRed.height) {
        		//if(!game.buttonOnTheWay) {
                    game.buttonOnTheWay = true;
                    game.currentLevel.buttonRed.startMove((float) ((game.currentLevel.buttonRed.getCenterX() - worldCoords.x) / dist * 10), (float) ((game.currentLevel.buttonRed.getCenterY() - worldCoords.y) / dist * 10));
                //}
        		buttonPressed = false;
        	}
    	}
    	return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    	buttonPressed = false;
        game.levelScreen.buttonBlue.setTexture(Resources.getInstance().cursor);
    	return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public InputHandler(ButtonGame game) {
        this.game = game;
    }
}
