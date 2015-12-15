package com.ld34.buttongame.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;

public class GlueObstacle extends Obstacle {

    public GlueObstacle(ButtonGame game, World world, float xPos, float yPos, float sizeX, float sizeY) {
        super(game, world,xPos,yPos,sizeX,sizeY);
        sprite = new Sprite(new Texture(Gdx.files.internal("graphics/gluewall.png")));
        sprite.setSize(sizeX,sizeY);
        this.height = this.sprite.getHeight();
        this.width = this.sprite.getWidth();
        body.getFixtureList().peek().setRestitution(0f);
        body.getFixtureList().peek().setFriction(1f);
    }

    @Override
    public void handleCollision() {
    }
}
