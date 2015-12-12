package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;


public class InputHandler implements InputProcessor {
    private final ButtonGame game;
	private boolean mouseDown;

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.ESCAPE ) {
            game.setScreen(game.menuScreen);
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
        //buttonRed.body.applyForce(10000f,10000f,screenX,screenY,true);
        //buttonRed.body.setLinearVelocity(1000f, 0f);
        Gdx.app.log("Klicked", "True");
        Vector3 worldCoords = game.levelScreen.camera.unproject(new Vector3(screenX, screenY,0));
        double dist = Math.sqrt(Math.pow(screenX - game.levelScreen.buttonRed.getCenterX(),2.0d) + Math.pow(screenY - game.levelScreen.buttonRed.getCenterY(),2.0d));
        Gdx.app.log("FFF", "" + game.levelScreen.buttonRed.body.getPosition().y + " " + game.levelScreen.buttonRed.sprite.getY());
        Gdx.app.log("Mouse", "" + worldCoords.y);
        
        if(dist<game.levelScreen.buttonRed.height/2)
        {
        	mouseDown = true;
        	Gdx.app.log("GGG", "" + dist);
        	
        }
        
        return true;
    }
    
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
    	double dist = Math.sqrt(Math.pow(screenX - game.levelScreen.buttonRed.getCenterX(),2.0d) + Math.pow(screenY - game.levelScreen.buttonRed.getCenterY(),2.0d));
    	

    	if(mouseDown)
    	{
        	if(dist>game.levelScreen.buttonRed.height/2)
        	{
        		game.levelScreen.buttonRed.body.setLinearVelocity(-(screenX - game.levelScreen.buttonRed.getCenterX()), (screenY - game.levelScreen.buttonRed.getCenterY()));
        		mouseDown = false;
        	}
    	}

    	return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        
    	mouseDown = false;
    	
    	return false;
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
