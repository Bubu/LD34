package com.ld34.buttongame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class MovingObstacle extends Obstacle {
    public MovingObstacle(ButtonGame game, World world, float xPos, float yPos, float sizeX, float sizeY, Vector2 dir) {
        super(game, world, xPos, yPos, sizeX, sizeY, 3);
        body.setType(BodyDef.BodyType.KinematicBody);
        body.setLinearVelocity(dir);
    }
    public void turn(){
        Vector2 dir = body.getLinearVelocity();
        body.setLinearVelocity(dir.scl(-1));
    }
}
