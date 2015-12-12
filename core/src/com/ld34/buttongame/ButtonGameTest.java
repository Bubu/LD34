package com.ld34.buttongame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class ButtonGameTest extends ApplicationAdapter implements InputProcessor{
    SpriteBatch batch;
    MassiveObject buttonRed;
    World world;

    @Override
    public void create() {
    	
        world = new World(new Vector2(0, 0f), true);
        batch = new SpriteBatch();
        // We will use the default LibGdx logo for this example, but we need a sprite since it's going to move
        
        buttonRed = new MassiveObject("ButtonRed.png");
         
        buttonRed.createHere(world, Gdx.graphics.getWidth() / 2 - buttonRed.width / 2,
        		Gdx.graphics.getHeight() / 2);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {

        // Advance the world, by the amount of time that has elapsed since the 
        // last frame
        // Generally in a real game, dont do this in the render loop, as you are 
        // tying the physics
        // update rate to the frame rate, and vice versa
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

        // buttonRed.body.applyTorque(10000f,true);
        
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        buttonRed.draw(batch);
        batch.end();
        
        Gdx.app.log("Angle", "" + buttonRed.body.getLinearVelocity());
    }

    @Override
    public void dispose() {
        // Hey, I actually did some clean up in a code sample!
        world.dispose();
    }
    
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        buttonRed.body.applyForce(10000f,10000f,screenX,screenY,true);
        buttonRed.body.setLinearVelocity(1000f, 0f);
        Gdx.app.log("Klicked", "True");
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		buttonRed.body.setLinearVelocity(-1000f, 0f);
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}

