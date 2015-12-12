package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class RigidBody {

	public Sprite sprite;
	private BodyDef bodyDef;
	private com.badlogic.gdx.physics.box2d.PolygonShape shape;
	private FixtureDef fixtureDef;
	public Body body;
	public float width;
	public float height;

	public RigidBody(String graphicName, World world, float xPos, float yPos)
	{
		Texture img = new Texture(Gdx.files.internal(graphicName));
		this.sprite = new Sprite(img);
		this.height = this.sprite.getHeight();
		this.width = this.sprite.getWidth();
		
		this.bodyDef = new BodyDef();
		this.bodyDef.type = BodyDef.BodyType.DynamicBody;
		
		shape = new PolygonShape();
		shape.setAsBox(sprite.getWidth()/2, sprite.getHeight()/2);
		
		this.fixtureDef = new FixtureDef();
		this.fixtureDef.shape = shape;
		this.fixtureDef.density = 1f;
		this.sprite.setPosition(xPos, yPos);
		this.bodyDef.position.set(sprite.getX(), sprite.getY());

		this.body = world.createBody(bodyDef);
		this.body.createFixture(this.fixtureDef);
	}
	
	void draw(SpriteBatch batch)
	{
		sprite.setPosition(body.getPosition().x, body.getPosition().y);
		sprite.setRotation((float)Math.toDegrees(body.getAngle()));
		batch.draw(sprite, sprite.getX(), sprite.getY(),sprite.getOriginX(),
                sprite.getOriginY(), sprite.getWidth(),sprite.getHeight(),
                sprite.getScaleX(),sprite.getScaleY(),sprite.getRotation());
	}
	
}
