package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;

public class Level2 extends Level{

    public Level2(ButtonGame game) {
        super(game);
        if(Resources.DEBUG){
            new Obstacle(game, world,0,0,5, Gdx.graphics.getHeight());
            new Obstacle(game, world,0,Gdx.graphics.getHeight()-5,Gdx.graphics.getWidth(),5);
            new Obstacle(game, world,Gdx.graphics.getWidth()-5,0,5,Gdx.graphics.getHeight());
            new Obstacle(game, world,0,0,Gdx.graphics.getWidth(), 5);
        }
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        objects.add(buttonRed);
    }

    @Override
    Level getNextLevel() {
        return new Level3(game);
    }
}
