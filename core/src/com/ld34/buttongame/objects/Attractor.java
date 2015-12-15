package com.ld34.buttongame.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;

public class Attractor extends GameObject{

	Vector2 center;
	float mult;
	
	public Attractor(ButtonGame game, World world, float xPos, float yPos, float mult) {
		super(game);
		// TODO Auto-generated constructor stub
		
        sprite = new Sprite(new Texture(Gdx.files.internal("graphics/Attractor.png")));
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        CircleShape shape = new CircleShape();
		shape.setRadius(sprite.getWidth() / 2 / Resources.PIXELS_TO_METERS);
        
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0.2f;
        fixtureDef.restitution= 0f;
        fixtureDef.isSensor = true;
        bodyDef.position.set(xPos/ Resources.PIXELS_TO_METERS, yPos/ Resources.PIXELS_TO_METERS);
        
        center = new Vector2();
        center.x = xPos + sprite.getWidth()/2;
        center.y = yPos + sprite.getWidth()/2;
        this.mult = mult;
        
        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        super.init(); 
	}
	
	public void step(){
		if(game.buttonOnTheWay){
			attractButton();
		}
	}
	
	void attractButton(){
		
		Vector2 buttonPos = game.currentLevel.buttonRed.body.getPosition();
		Vector2 dist = buttonPos.sub(body.getPosition());
		
		Vector2 Force = new Vector2();
		Force.x = (float) (- dist.x/Math.pow(dist.len(),1.5));
		Force.y = (float) (- dist.y/Math.pow(dist.len(),1.5));
		Force.scl(mult);
		//Force.x = Math.min(Force.x, 0.01f);
		//Force.y = Math.min(Force.y, 0.01f);

		//game.currentLevel.buttonRed.body.applyLinearImpulse(Force, buttonPos, true);
        game.currentLevel.buttonRed.body.applyForceToCenter(Force, true);
		game.currentLevel.buttonRed.body.setLinearDamping((float) (100 / Math.exp(dist.len()))); //  applyForceToCenter((float) ForceX, (float) ForceY, true);
	}

    @Override
    public void handleCollision() {

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.currentLevel.objects.remove(game.currentLevel.buttonRed);
            }
        },0.5f);
    }
}
