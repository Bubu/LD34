package com.ld34.buttongame.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;

public abstract class GameObject {
    ButtonGame game;
    protected Sprite sprite;
    protected Body body;
    public float width;
    public float height;

    public GameObject(ButtonGame game) {
        this.game = game;
    }

    public void draw(SpriteBatch batch){
        sprite.setOriginCenter();
        sprite.setRotation((float)Math.toDegrees(body.getAngle()));
        sprite.setPosition((body.getPosition().x * Resources.PIXELS_TO_METERS) - sprite.getWidth() / 2, (body.getPosition().y * Resources.PIXELS_TO_METERS) - sprite.getHeight() / 2);
        batch.draw(sprite, sprite.getX(), sprite.getY(),sprite.getOriginX(),
                sprite.getOriginY(), sprite.getWidth(),sprite.getHeight(),
                sprite.getScaleX(),sprite.getScaleY(),sprite.getRotation());

    }

    public void init() {
        body.setUserData(this);
    }

    public void handleCollision(){
    }

    public void handleLeave() {
    }
    
    public void step() {
    }
}
