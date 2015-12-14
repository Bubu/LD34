package com.ld34.buttongame.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;

public class Floor extends GameObject {
    public Floor(ButtonGame game, World world) {
        super(game);
        sprite = new Sprite(Resources.getInstance().floor);
        sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getWidth());
        this.height = this.sprite.getHeight();
        this.width = this.sprite.getWidth();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2/ Resources.PIXELS_TO_METERS, height/2/ Resources.PIXELS_TO_METERS);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor = true;
        bodyDef.position.set(width/2/ Resources.PIXELS_TO_METERS,height/2/ Resources.PIXELS_TO_METERS);

        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        super.init();
    }

    @Override
    public void handleLeave() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.levelScreen.restart.setVisible(true);
            }
        },0.6f);
    }

    @Override
    public void handleCollision() {

    }
}
