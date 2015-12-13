package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public abstract class Level {
    ArrayList<GameObject> objects;
    final World world;
    Button buttonRed;
    public ButtonGame game;

    public static Level get(ButtonGame game, int i){
        try {
            Class c = Class.forName("com.ld34.buttongame.Level" + Integer.toString(i));
            Class[] types = {game.getClass()};
            Constructor constructor = c.getConstructor(types);
            Object[] parameters = {game};

            return (Level)constructor.newInstance(parameters);
        }catch (Exception e){
            Gdx.app.log("Error", "Level" + Integer.toString(i) + " not found!");
        }
        return null;
    }

    public Level(ButtonGame game) {
        this.game = game;
        objects = new ArrayList<GameObject>();
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

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });
    }

    abstract Level getNextLevel();
}
