package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.Floor;
import com.ld34.buttongame.objects.HorizontalObstacle;
import com.ld34.buttongame.objects.Laser;
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
        target = new Target(game, world,Gdx.graphics.getWidth()/2,500);
        Obstacle obstacle = new VerticalObstacle(game,world,100,0,50,350);
        Obstacle obstacle3 = new VerticalObstacle(game,world,700,0,50,350);
        Obstacle obstacle2 = new HorizontalObstacle(game,world,275,650,250,50);
        captain = new MovingCaptain(game, world, 200, 200, new Vector2(1,1));

        objects.add(captain);
    }
}
