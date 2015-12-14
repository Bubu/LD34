package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;

public class Level3 extends com.ld34.buttongame.level.Level {

    private Target target;

    public Level3(ButtonGame game) {
        super(game);
    }

    @Override
    public com.ld34.buttongame.level.Level getNextLevel() {
        return new Level4(game);
    }

    @Override
    public void init() {
        super.init();
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game, world,Gdx.graphics.getWidth()/2,500);
        Obstacle obstacle = new Obstacle(game,world,100,200,50,350,1);
        Obstacle obstacle3 = new Obstacle(game,world,700,200,50,350,1);
        Obstacle obstacle2 = new Obstacle(game,world,400,700,250,50,2);

        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(obstacle);
        objects.add(obstacle2);
        objects.add(obstacle3);
        objects.add(buttonRed);
    }
}
