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
import com.ld34.buttongame.objects.MovingCaptain;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;
import com.ld34.buttongame.objects.VerticalObstacle;

public class Level10 extends Level {

    private Target target;
    private MovingCaptain captain;

    public Level10(ButtonGame game) {
        super(game);
    }

    @Override
    public Level getNextLevel() {
        return new LevelEpi(game);
    }

    @Override
    public void init() {
        super.init();
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        Obstacle wall1 = new LongVerticalObstacle(game,world,0,0,50,700);
        Obstacle wall2 = new LongVerticalObstacle(game,world,750,0,50,700);
        Obstacle wall4 = new HorizontalObstacle(game,world,0,650,800,50);
        captain = new MovingCaptain(game, world, Gdx.graphics.getWidth()/2, 550, new Vector2(3,0));
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                captain.turn();
            }
        }, 0.8f, 1.5f);

        objects.add(new Floor(game,world));

        objects.add(wall4);
        objects.add(wall1);
        objects.add(wall2);
        objects.add(captain);

        objects.add(buttonRed);
    }
}
