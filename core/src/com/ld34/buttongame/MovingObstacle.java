package com.ld34.buttongame;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class MovingObstacle extends Obstacle {
    public MovingObstacle(ButtonGame game, World world, float xPos, float yPos, float sizeX, float sizeY) {
        super(game, world, xPos, yPos, sizeX, sizeY, 3);
        body.setType(BodyDef.BodyType.KinematicBody);
        body.setLinearVelocity(1f,0);
    }
}
