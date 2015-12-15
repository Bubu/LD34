package com.ld34.buttongame.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;

public class MovingCaptain extends GameObject {
    public MovingCaptain(ButtonGame game, World world, float xPos, float yPos, Vector2 dir) {
        super(game);
        sprite = new Sprite(new Texture(Gdx.files.internal("graphics/MovingCaptain.png")));
        sprite.setPosition(xPos, yPos);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth() / 2 / Resources.PIXELS_TO_METERS, sprite.getHeight() / 2 / Resources.PIXELS_TO_METERS);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0.2f;
        fixtureDef.restitution= 0.9f;
        fixtureDef.isSensor = true;
        bodyDef.position.set(xPos/ Resources.PIXELS_TO_METERS, yPos/ Resources.PIXELS_TO_METERS);

        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);

        
        body.setType(BodyDef.BodyType.KinematicBody);
        body.setLinearVelocity(dir);
        super.init();
    }
    public void turn(){
        Vector2 dir = body.getLinearVelocity();
        body.setLinearVelocity(dir.scl(-1));
    }

    @Override
    public void handleCollision() {
        super.handleCollision();
        Timer.schedule( new Timer.Task() {
            @Override
            public void run() {
                game.handleWin();
            }
        }, 0.3f);
        game.isWinning = true;
    }
}