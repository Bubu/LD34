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
        target = new Target(game, world,Gdx.graphics.getWidth()/2,600);
        final MovingObstacle obstacle1 = new MovingObstacle(game,world,50,500,175,50, new Vector2(2,0), 0);
        final MovingObstacle obstacle2 = new MovingObstacle(game,world,250,400,175,50, new Vector2(4,0), 0);
        final MovingObstacle obstacle3 = new MovingObstacle(game,world,450,300,175,50, new Vector2(6,0), 0);
        Obstacle wall1 = new LongVerticalObstacle(game,world,0,0,50,700);
        Obstacle wall2 = new LongVerticalObstacle(game,world,750,0,50,700);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                obstacle1.turn();
            }
        },2.5f,2.5f);
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                obstacle2.turn();
            }
        },0.8f,1.3f);
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                obstacle3.turn();
            }
        },0.18f,0.9f);

        objects.add(new Floor(game, world));
        objects.add(target);
        objects.add(wall1);
        objects.add(wall2);
        objects.add(obstacle1);
        objects.add(obstacle2);
        objects.add(obstacle3);
        objects.add(buttonRed);
        Laser laser = new Laser(game, -7, 200, 0f);
        laserList.add(laser);
    }
}
