package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.ld34.buttongame.*;
import com.ld34.buttongame.objects.Attractor;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.HorizontalObstacle;
import com.ld34.buttongame.objects.LongVerticalObstacle;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;
import com.ld34.buttongame.objects.VerticalObstacle;

public class Level5 extends com.ld34.buttongame.level.Level {

    private Target target;

    public Level5(ButtonGame game) {
        super(game);
    }

    @Override
    public com.ld34.buttongame.level.Level getNextLevel() {
        return new Level6(game);
    }

    @Override
    public void init() {
        super.init();
        buttonRed = new Button(game, world, Gdx.graphics.getWidth()/2, 100);
        target = new Target(game,world, 125,125);

        Obstacle wall1 = new LongVerticalObstacle(game,world,0,0,50,700);
        Obstacle wall2 = new LongVerticalObstacle(game,world,750,0,50,700);
        Obstacle wall3 = new LongVerticalObstacle(game,world,200,0,50,500);
        Obstacle wall4 = new HorizontalObstacle(game,world,0,650,800,50);
        Obstacle wall5 = new HorizontalObstacle(game,world,0,0,250,50);

        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(wall4);
        objects.add(wall1);
        objects.add(wall2);
        objects.add(wall3);
        objects.add(wall5);
        objects.add(buttonRed);
        
        
    }
}
