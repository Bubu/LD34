package com.ld34.buttongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FinalDialogueScreen extends ScreenAdapter {
	ButtonGame game;
	Stage stage;
	int count = 0;
	int maxCount = Resources.getInstance().prologueLength;
	Label dialogueLabel;
	Image leftPerson;
	Image rightPerson;

	public FinalDialogueScreen(final ButtonGame game) {
	        this.game = game;
	        stage = new Stage(new ScreenViewport());
	        
	        dialogueLabel = new Label("", Resources.Skin());
	        dialogueLabel.setWrap(true);
	        dialogueLabel.setColor(Color.CYAN);
	        
	        leftPerson = new Image(new Texture(Gdx.files.internal("graphics/CaptainCalamari.png")));
	        leftPerson.setVisible(false);
	        rightPerson = new Image(new Texture(Gdx.files.internal("graphics/JimmyTwoButton.png")));
	        leftPerson.setScaling(Scaling.none);
	        rightPerson.setScaling(Scaling.none);
	        stage.addListener(new InputListener() {
	            @Override
	            public boolean touchDown(InputEvent event, float screenX, float screenY, int pointer, int button) {
	            	
	            	if(count<maxCount){
	            		count = advanceDialogue(count);	            		
	            	}else{
	            		game.levelSelect();
	            	}
	            	return true;
	            }
	        });

	        Table table = new Table();
	        table.setFillParent(true);
	        table.align(Align.top);
	        table.add().height(50).colspan(3).center();
	        table.row();
	        table.add(leftPerson);
	        table.add();//.width(20);
	        table.add(rightPerson);
	        table.row();
	        table.add().colspan(3).height(50);
	        table.row();
	        table.add(dialogueLabel).width(600).colspan(3).center();
	        table.setDebug(true);
	        
	        stage.addActor(table);
	    }

	    @Override
	    public void show() {
	        Gdx.gl.glClearColor(0, 0, 0, 1);
	        Gdx.input.setInputProcessor(stage);
	    }
	    
	    public int advanceDialogue(int currCount) {
	    	dialogueLabel.setText(Resources.getInstance().finalDialogue[currCount]);
	    	dialogueLabel.setColor(Resources.getInstance().finalDialogueColor[currCount]);
    		dialogueLabel.setAlignment(Resources.getInstance().finalDialogueAlign[currCount]);
	    	if(currCount == 2){
	    		leftPerson.setVisible(true);
	    	}
	    	return count + 1;
	    }

	    public void render(float delta) {
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        stage.act(Gdx.graphics.getDeltaTime());
	        stage.draw();
	    }
	    public void resize (int width, int height) {
	        stage.getViewport().update(width, height, true);
	    }

	    public void dispose () {
	        stage.dispose();
	    }
	}