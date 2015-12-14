package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.Laser;
import com.ld34.buttongame.objects.LongVerticalObstacle;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;

public class Level1 extends com.ld34.buttongame.level.Level {

    private Target target;

    public Level1(ButtonGame game) {
        super(game);
    }

    @Override
    public com.ld34.buttongame.level.Level getNextLevel() {
        return new Level2(game);
    }

    @Override
    public void init() {
        super.init();
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game, world,Gdx.graphics.getWidth()/2,600);
        Obstacle wall1 = new LongVerticalObstacle(game,world,150,0,50,700);
        Obstacle wall2 = new LongVerticalObstacle(game,world,600,0,50,700);
        Laser laser = new Laser(game, 0, 300, 0f);
        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(wall1);
        objects.add(wall2);
        objects.add(buttonRed);
        laserList.add(laser);
    }
}
