package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.LongVerticalObstacle;
import com.ld34.buttongame.objects.MovingObstacle;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;

public class Level4 extends com.ld34.buttongame.level.Level {

    private Target target;

    public Level4(ButtonGame game) {
        super(game);
    }

    @Override
    public com.ld34.buttongame.level.Level getNextLevel() {
        return new Level5(game);
    }

    @Override
    public void init() {
        super.init();
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game, world,Gdx.graphics.getWidth()/2,600);
        final MovingObstacle obstacle = new MovingObstacle(game,world,75,500,250,50, new Vector2(4,0));
        Obstacle wall1 = new LongVerticalObstacle(game,world,45,0,50,700);
        Obstacle wall2 = new LongVerticalObstacle(game,world,705,0,50,700);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                obstacle.turn();
            }
        },0.95f,0.95f);

        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(wall1);
        objects.add(wall2);
        objects.add(obstacle);
        objects.add(buttonRed);
    }
}
