package com.ld34.buttongame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class GameObject {
    Sprite sprite;
    Body body;
    public float width;
    public float height;

    void draw(SpriteBatch batch){
        sprite.setPosition((body.getPosition().x * Resources.PIXELS_TO_METERS) - sprite.getWidth()/2, (body.getPosition().y * Resources.PIXELS_TO_METERS)- sprite.getHeight()/2);
        sprite.setRotation((float)Math.toDegrees(body.getAngle()));
        batch.draw(sprite, sprite.getX(), sprite.getY(),sprite.getOriginX(),
                sprite.getOriginY(), sprite.getWidth(),sprite.getHeight(),
                sprite.getScaleX(),sprite.getScaleY(),sprite.getRotation());

    }

    public void init() {
        body.setUserData(this);
    }

    public void handleCollision(){
    }
}
