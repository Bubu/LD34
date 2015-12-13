package com.ld34.buttongame;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

public class Level {
    ArrayList<GameObject> objects;
    final World world;
    Button buttonRed;
    public Level() {
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
}
