package com.ld34.buttongame.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.ld34.buttongame.ButtonGame;
import com.ld34.buttongame.Resources;
import com.ld34.buttongame.objects.Button;
import com.ld34.buttongame.objects.GameObject;
import com.ld34.buttongame.objects.Laser;
import com.ld34.buttongame.objects.Obstacle;

import java.util.ArrayList;

public abstract class Level {
    public ArrayList<GameObject> objects;
    public World world;
    public Button buttonRed;
    public ButtonGame game;
    public ArrayList<Laser> laserList;

    public static Level get(ButtonGame game, int i){
        switch (i) {
            case 1:
                return new Level1(game);
            case 2:
                return new Level2(game);
            case 3:
                return new Level3(game);
            case 4:
                return new Level4(game);
            case 5:
                return new Level5(game);
            case 6:
                return new Level6(game);
            case 7:
                return new Level7(game);
            case 8:
                return new Level8(game);
            case 9:
                return new Level9(game);
            default:
                Gdx.app.log("Error", "Level" + Integer.toString(i) + " not found!");
        }
        return null;
    }

    public Level(ButtonGame game) {
        this.game = game;
    }

    public abstract Level getNextLevel();

    public void init(){
        world = new World(new Vector2(0, 0f), true);
        world.setContactListener(new ContactListener() {

            @Override
            public void beginContact(Contact contact) {
                GameObject objectA = (GameObject) contact.getFixtureA().getBody().getUserData();
                GameObject objectB = (GameObject) contact.getFixtureB().getBody().getUserData();
                objectA.handleCollision();
                objectB.handleCollision();
            }

            @Override
            public void endContact(Contact contact) {
                GameObject objectA = (GameObject) contact.getFixtureA().getBody().getUserData();
                GameObject objectB = (GameObject) contact.getFixtureB().getBody().getUserData();
                objectA.handleLeave();
                objectB.handleLeave();
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });
        objects = new ArrayList<GameObject>();
        laserList = new ArrayList<Laser>();
    }
}
