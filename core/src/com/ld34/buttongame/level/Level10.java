package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.HorizontalObstacle;
import com.ld34.buttongame.objects.Laser;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;
import com.ld34.buttongame.objects.VerticalObstacle;

public class Level10 extends Level {

    private Target target;

    public Level10(ButtonGame game) {
        super(game);
    }

    @Override
    public Level getNextLevel() {
        return new Level3(game);
    }

    @Override
    public void init() {
        super.init();
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game, world,Gdx.graphics.getWidth()/2,500);
        Obstacle obstacle = new VerticalObstacle(game,world,100,0,50,350);
        Obstacle obstacle3 = new VerticalObstacle(game,world,700,0,50,350);
        Obstacle obstacle2 = new HorizontalObstacle(game,world,275,650,250,50);

        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(obstacle);
        objects.add(obstacle2);
        objects.add(obstacle3);
        objects.add(buttonRed);
        Laser laser = new Laser(game, -7, 200, 25f);
        Laser laser2 = new Laser(game, -7, 450, -5f);
        laserList.add(laser);
        laserList.add(laser2);
    }
}
