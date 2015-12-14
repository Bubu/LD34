package com.ld34.buttongame.objects;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;

public class Obstacle extends GameObject {

    public Obstacle(ButtonGame game, World world, float xPos, float yPos, float sizeX, float sizeY) {
        super(game);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sizeX / 2 / Resources.PIXELS_TO_METERS, sizeY / 2 / Resources.PIXELS_TO_METERS);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0.1f;
        fixtureDef.restitution= 0.9f;
        bodyDef.position.set((xPos + sizeX / 2) / Resources.PIXELS_TO_METERS, (yPos + sizeY / 2) / Resources.PIXELS_TO_METERS);

        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        super.init();
    }

    @Override
    public void handleCollision() {
        Resources.getInstance().clack.play();
    }
}
