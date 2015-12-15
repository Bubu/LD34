package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.objects.Attractor;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.GlueObstacle;
import com.ld34.buttongame.objects.HorGlueObstacle;
import com.ld34.buttongame.objects.Laser;
import com.ld34.buttongame.objects.LongVerticalObstacle;
import com.ld34.buttongame.objects.MovingObstacle;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;

public class Level6 extends Level {

    private Target target;

    public Level6(ButtonGame game) {
        super(game);
    }

    @Override
    public Level getNextLevel() {
        return new Level7(game);
    }
    @Override
    public void init() {
        super.init();
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game, world,55,620);
        Obstacle obstacle = new GlueObstacle(game,world,100,100,50,400);
        Obstacle obstacle2 = new HorGlueObstacle(game,world,0,500,150,50);
        Attractor attractor = new Attractor(game, world, 50, 450, 15f);

        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(obstacle);
        objects.add(obstacle2);

        objects.add(attractor);
        objects.add(buttonRed);
        Laser laser = new Laser(game, -7, 150, 0f);
        laserList.add(laser);
    }

}
