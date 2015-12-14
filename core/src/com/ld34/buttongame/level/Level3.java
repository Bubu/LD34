package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.HorizontalObstacle;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;
import com.ld34.buttongame.objects.VerticalObstacle;

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
        target = new Target(game, world, 650,500);
        Obstacle obstacle = new VerticalObstacle(game,world,100,100,50,350);
        Obstacle obstacle2 = new HorizontalObstacle(game,world,450,300,250,50);

        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(obstacle);
        objects.add(obstacle2);
        objects.add(buttonRed);
    }
}
