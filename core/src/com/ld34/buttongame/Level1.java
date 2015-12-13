package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;

public class Level1 extends Level{

    private final Target target;

    public Level1() {
        if(Resources.DEBUG){
            new Obstacle(world,0,0,5, Gdx.graphics.getHeight());
            new Obstacle(world,0,Gdx.graphics.getHeight()-5,Gdx.graphics.getWidth(),5);
            new Obstacle(world,Gdx.graphics.getWidth()-5,0,5,Gdx.graphics.getHeight());
            new Obstacle(world,0,0,Gdx.graphics.getWidth(), 5);
        }
        buttonRed = new Button(world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(world,Gdx.graphics.getWidth()/2,600);

        objects.add(target);
        objects.add(buttonRed);
    }
}
