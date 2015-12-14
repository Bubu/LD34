package com.ld34.buttongame.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;

public class Obstacle extends GameObject {

    public Obstacle(ButtonGame game, World world, float xPos, float yPos, float sizeX, float sizeY, int type) {
        super(game);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        PolygonShape shape = new PolygonShape();
        if(type == 0){
            shape.setAsBox(sizeX/ Resources.PIXELS_TO_METERS,sizeY/ Resources.PIXELS_TO_METERS);
        }
        else if(type == 1) {
            sprite = new Sprite(new Texture(Gdx.files.internal("graphics/Wall.png")));
            sprite.setSize(sizeX,sizeY);
            this.height = this.sprite.getHeight();
            this.width = this.sprite.getWidth();
            shape.setAsBox(width/2/ Resources.PIXELS_TO_METERS,height/2/ Resources.PIXELS_TO_METERS);
        }
        else if(type == 2) {
            sprite = new Sprite(new Texture(Gdx.files.internal("graphics/Wall_v.png")));
            sprite.setSize(sizeX,sizeY);
            this.height = this.sprite.getHeight();
            this.width = this.sprite.getWidth();
            shape.setAsBox(width/2/ Resources.PIXELS_TO_METERS,height/2/ Resources.PIXELS_TO_METERS);
        }
        else if(type == 3) {
            sprite = new Sprite(new Texture(Gdx.files.internal("graphics/moving.png")));
            sprite.setSize(sizeX,sizeY);
            this.height = this.sprite.getHeight();
            this.width = this.sprite.getWidth();
            shape.setAsBox(width/2/ Resources.PIXELS_TO_METERS,height/2/ Resources.PIXELS_TO_METERS);
        }

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0.2f;
        fixtureDef.restitution= 0.9f;
        bodyDef.position.set(xPos/ Resources.PIXELS_TO_METERS, yPos/ Resources.PIXELS_TO_METERS);

        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        super.init();
    }

    @Override
    public void handleCollision() {
        Resources.getInstance().clack.play();
    }
}
