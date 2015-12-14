package com.ld34.buttongame.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.ButtonGame;


public class Laser{

	private Sprite sprite;
	boolean isVisible;
	Timer.Task downTask;
	Timer.Task upTask;

	public Laser(ButtonGame game, float xPos, float yPos, float Angle) {
		
		sprite = new Sprite(new Texture(Gdx.files.internal("graphics/Laserbeam.png")));
		sprite.setRotation(Angle);
		sprite.setPosition(xPos, yPos);
		isVisible = true;
		
		downTask = new Timer.Task() {
            @Override
            public void run() {
                isVisible = false;
            }
        };
		upTask = new Timer.Task() {
            @Override
            public void run() {
                isVisible = true;
            }
        };
		
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Batch batch){
		if(isVisible){
        batch.draw(sprite, sprite.getX(), sprite.getY(),sprite.getOriginX(),
                sprite.getOriginY(), sprite.getWidth(),sprite.getHeight(),
                sprite.getScaleX(),sprite.getScaleY(),sprite.getRotation());
		}
        }
	
	public void powerDown(boolean down){
		if(down){
            Timer.schedule(downTask, 0.2f, 0.3f, 5);
            Timer.schedule(upTask, 0.4f, 0.4f, 3);
            //Timer.schedule(downTask, 1f);
        }else{
        	downTask.cancel();
        	upTask.cancel();
        	isVisible = true;
        }
	}
	
}
