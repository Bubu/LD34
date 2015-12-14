package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;

public class Level1 extends com.ld34.buttongame.level.Level {

    private final Target target;

    @Override
    public int getNumber() {
        return 1;
    }

    public Level1(ButtonGame game) {
        super(game);
        if(Resources.DEBUG){
            new Obstacle(game, world,0,0,5, Gdx.graphics.getHeight(),0);
            new Obstacle(game, world,0,Gdx.graphics.getHeight()-5,Gdx.graphics.getWidth(),5,0);
            new Obstacle(game, world,Gdx.graphics.getWidth()-5,0,5,Gdx.graphics.getHeight(),0);
            new Obstacle(game, world,0,0,Gdx.graphics.getWidth(), 5,0);
        }
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game, world,Gdx.graphics.getWidth()/2,600);

        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(buttonRed);
    }

    @Override
    public com.ld34.buttongame.level.Level getNextLevel() {
        return new Level2(game);
    }

}
