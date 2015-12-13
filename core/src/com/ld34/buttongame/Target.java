package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Timer;

public class Target extends GameObject {
    Texture imgOn;
    Texture imgOff;
    boolean state = true;
    public Target(ButtonGame game, World world, float posX, float posY) {
        super(game);
        imgOn = new Texture(Gdx.files.internal("graphics/TriggerOn.png"));
        imgOff = new Texture(Gdx.files.internal("graphics/TriggerOff.png"));
        sprite = new Sprite(imgOn);
        sprite.setSize(80,80);
        this.height = this.sprite.getHeight();
        this.width = this.sprite.getWidth();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2/ Resources.PIXELS_TO_METERS,height/2/ Resources.PIXELS_TO_METERS);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor = true;
        bodyDef.position.set(posX/ Resources.PIXELS_TO_METERS, posY/ Resources.PIXELS_TO_METERS);

        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        super.init();
    }

    @Override
    public void handleCollision() {
        if(state) {
            sprite.setTexture(imgOff);
            Resources.getInstance().off.play();
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Resources.getInstance().powerdown.play();
                }
            }, 0.1f);
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    game.handleWin();
                }
            }, 3f);
        }
        if(!state) {
            sprite.setTexture(imgOn);
            Resources.getInstance().on.play();
            Resources.getInstance().powerdown.stop();
        }
        state = !state;
}
}
