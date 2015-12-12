package com.ld34.buttongame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class MassiveObject {

	public Sprite sprite;
	private BodyDef bodyDef;
	private com.badlogic.gdx.physics.box2d.PolygonShape shape;
	private FixtureDef fixtureDef;
	private Body body;

	public MassiveObject(String graphicName)
	{
		Texture img = new Texture(graphicName);
		this.sprite = new Sprite(img);
		
		this.bodyDef = new BodyDef();
		this.bodyDef.type = BodyDef.BodyType.DynamicBody;
		
		shape = new PolygonShape();
		shape.setAsBox(sprite.getWidth()/2, sprite.getHeight()/2);
		
		this.fixtureDef = new FixtureDef();
		this.fixtureDef.shape = shape;
		this.fixtureDef.density = 1f;
		shape.dispose();
	}
	
	void createHere(World world, float xPos, float yPos)
	{
		this.sprite.setPosition(xPos, yPos);
		this.bodyDef.position.set(sprite.getX(), sprite.getY());
		
		this.body = world.createBody(bodyDef);
		this.body.createFixture(this.fixtureDef);
	}
	
}
