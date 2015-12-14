package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.MovingObstacle;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;

public class Level4 extends com.ld34.buttongame.level.Level {

    private final Target target;

    public Level4(ButtonGame game) {
        super(game);
        if(Resources.DEBUG){
            new Obstacle(game, world,0,0,5, Gdx.graphics.getHeight(),0);
            new Obstacle(game, world,0,Gdx.graphics.getHeight()-5,Gdx.graphics.getWidth(),5,0);
            new Obstacle(game, world,Gdx.graphics.getWidth()-5,0,5,Gdx.graphics.getHeight(),0);
            new Obstacle(game, world,0,0,Gdx.graphics.getWidth(), 5,0);
        }
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game, world,Gdx.graphics.getWidth()/2,600);
        final MovingObstacle obstacle2 = new MovingObstacle(game,world,200,500,250,50, new Vector2(4,0));

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                obstacle2.turn();
            }
        },1f,1f);

        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(obstacle2);
        objects.add(buttonRed);
    }

    @Override
    public com.ld34.buttongame.level.Level getNextLevel() {
        return new Level5(game);
    }

    @Override
    public int getNumber() {
        return 4;
    }
}
