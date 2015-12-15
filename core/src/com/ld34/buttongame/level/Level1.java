package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.Laser;
import com.ld34.buttongame.objects.MovingCaptain;
import com.ld34.buttongame.objects.Obstacle;
import com.ld34.buttongame.objects.Target;

public class Level1 extends com.ld34.buttongame.level.Level {

    private Target target;
	private MovingCaptain captain;

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
        captain = new MovingCaptain(game, world, 200, 200, new Vector2(1,1));
        
        Laser laser = new Laser(game, 0, 300, 0f);
        objects.add(new Floor(game,world));
        objects.add(target);
        objects.add(buttonRed);
        //objects.add(captain);
        laserList.add(laser);
    }
}
