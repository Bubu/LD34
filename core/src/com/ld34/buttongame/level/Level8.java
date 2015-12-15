package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.objects.Attractor;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.GlueObstacle;
import com.ld34.buttongame.objects.HorizontalObstacle;
import com.ld34.buttongame.objects.LongVerticalObstacle;
import com.ld34.buttongame.objects.MovingObstacle;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;
import com.ld34.buttongame.objects.VerticalObstacle;

public class Level8 extends Level {

    private Target target;

    public Level8(ButtonGame game) {
        super(game);
    }

    @Override
    public Level getNextLevel() {
        return new Level9(game);
    }

    @Override
    public void init() {
        super.init();
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game, world,Gdx.graphics.getWidth()/2,550);
        Obstacle obstacle2 = new HorizontalObstacle(game,world,300,380,200,50);
        Obstacle obstacle = new GlueObstacle(game,world,100,200,50,400);
        final MovingObstacle obstacle3 = new MovingObstacle(game,world,600,300,175,50, new Vector2(0,4), 90);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                obstacle3.turn();
            }
        }, 0.8f, 1.5f);

        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(obstacle);
        objects.add(obstacle2);
        objects.add(obstacle3);

        objects.add(buttonRed);
        
        
    }
}
