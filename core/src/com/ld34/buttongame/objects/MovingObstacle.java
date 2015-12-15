package com.ld34.buttongame.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.ld34.buttongame.ButtonGame;

public class MovingObstacle extends Obstacle {
    public MovingObstacle(ButtonGame game, World world, float xPos, float yPos, float sizeX, float sizeY, Vector2 dir, float angle) {
        super(game, world, xPos, yPos, sizeX, sizeY);
        sprite = new Sprite(new Texture(Gdx.files.internal("graphics/moving.png")));
        sprite.setSize(sizeX,sizeY);
        this.height = this.sprite.getHeight();
        this.width = this.sprite.getWidth();

        body.setType(BodyDef.BodyType.KinematicBody);
        body.setTransform(body.getPosition(),(float)Math.toRadians(angle));
        body.setLinearVelocity(dir);
    }
    public void turn(){
        Vector2 dir = body.getLinearVelocity();
        body.setLinearVelocity(dir.scl(-1));
    }
}
