package com.ld34.buttongame;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Button extends GameObject{

    public final Sound clack;
    private final Sound click;
	public float width;
	public float height;

	public Button(World world, float xPos, float yPos) {
        clack = Gdx.audio.newSound(Gdx.files.internal("sounds/clack.wav"));
        click = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
		Texture img = new Texture(Gdx.files.internal("ButtonRed.png"));
		this.sprite = new Sprite(img);
		this.height = this.sprite.getHeight();
		this.width = this.sprite.getWidth();

        BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.linearDamping = 0.1f;

        CircleShape shape = new CircleShape();
		shape.setRadius(sprite.getWidth() / 2 / Resources.PIXELS_TO_METERS);

        FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1f;
        fixtureDef.friction = 0.2f;
        fixtureDef.restitution = 0.9f;
		bodyDef.position.set(xPos/ Resources.PIXELS_TO_METERS, yPos/ Resources.PIXELS_TO_METERS);

		this.body = world.createBody(bodyDef);
		this.body.createFixture(fixtureDef);
	}
	
	double getCenterX()
	{
		return body.getPosition().x * Resources.PIXELS_TO_METERS;
	}

    double getCenterY()
	{
		return body.getPosition().y * Resources.PIXELS_TO_METERS;
	}

    public void startMove(float x,float y) {
        body.setLinearVelocity(x,y);
        click.play();
    }
}
