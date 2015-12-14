package com.ld34.buttongame.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;

public class Attractor extends GameObject{

	Vector2 center;
	
	public Attractor(ButtonGame game, World world, float xPos, float yPos, float force) {
		super(game);
		// TODO Auto-generated constructor stub
		
        sprite = new Sprite(new Texture(Gdx.files.internal("graphics/Attractor.png")));
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        PolygonShape shape = new PolygonShape();
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0.2f;
        fixtureDef.restitution= 0.9f;
        bodyDef.position.set(xPos/ Resources.PIXELS_TO_METERS, yPos/ Resources.PIXELS_TO_METERS);
        
        center = new Vector2();
        center.x = xPos + sprite.getWidth()/2;
        center.y = yPos + sprite.getWidth()/2;
        
        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        super.init(); 
	}
	
	public void step(){
		attractButton();
	}
	
	void attractButton(){
		
		Vector2 buttonPos = game.currentLevel.buttonRed.body.getPosition();
		Vector2 dist = buttonPos.sub(center);

		double ForceX = dist.x/Math.pow(dist.len(),3.0);
		double ForceY = dist.y/Math.pow(dist.len(),3.0);
		
		game.currentLevel.buttonRed.body.applyForceToCenter((float) ForceX, (float) ForceY, true);
		
	}

	
}
