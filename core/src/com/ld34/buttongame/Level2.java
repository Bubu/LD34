package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;

public class Level2 extends Level{

    private final Target target;

    public Level2(ButtonGame game) {
        super(game);
        if(Resources.DEBUG){
            new Obstacle(game, world,0,0,5, Gdx.graphics.getHeight(),0);
            new Obstacle(game, world,0,Gdx.graphics.getHeight()-5,Gdx.graphics.getWidth(),5,0);
            new Obstacle(game, world,Gdx.graphics.getWidth()-5,0,5,Gdx.graphics.getHeight(),0);
            new Obstacle(game, world,0,0,Gdx.graphics.getWidth(), 5,0);
        }
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game, world, 650,500);
        Obstacle obstacle = new Obstacle(game,world,100,200,50,250,1);
        Obstacle obstacle2 = new Obstacle(game,world,600,300,250,50,2);

        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(obstacle);
        objects.add(obstacle2);
        objects.add(buttonRed);
    }

    @Override
    Level getNextLevel() {
        return new Level3(game);
    }

    @Override
    int getNumber() {
        return 2;
    }
}
