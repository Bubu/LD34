package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.HorizontalObstacle;
import com.ld34.buttongame.objects.Laser;
import com.ld34.buttongame.objects.LongVerticalObstacle;
import com.ld34.buttongame.objects.MovingObstacle;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;

public class Level7 extends Level {

    private Target target;

    public Level7(ButtonGame game) {
        super(game);
    }

    @Override
    public Level getNextLevel() {
        return new Level8(game);
    }

    @Override
    public void init() {
        super.init();
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game, world, 650,350);
        Obstacle wall1 = new LongVerticalObstacle(game,world,0,0,50,700);
        Obstacle obstacle1 = new HorizontalObstacle(game,world,250,550,250,50);
        Obstacle obstacle2 = new HorizontalObstacle(game,world,450,200,350,50);
        final MovingObstacle moving = new MovingObstacle(game,world,50,450,175,50, new Vector2(3,0), 0);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                moving.turn();
            }
        }, 1.9f, 1.9f);

        objects.add(new Floor(game, world));
        objects.add(target);
        objects.add(wall1);
        objects.add(obstacle1);
        objects.add(obstacle2);
        objects.add(moving);
        objects.add(buttonRed);
        Laser laser = new Laser(game, 55, -5, 45f);
        laserList.add(laser);
    }
}
