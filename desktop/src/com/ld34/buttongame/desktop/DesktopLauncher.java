package com.ld34.buttongame.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ld34.buttongame.ButtonGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		//cfg.addIcon("icon128.png", FileType.Internal);
		//cfg.addIcon("icon32.png", FileType.Internal);
		//cfg.addIcon("icon32.png", FileType.Internal);
		cfg.title = "Button Sniper";
		cfg.height = 700;
		cfg.width = 800;
		cfg.resizable = false;
		new LwjglApplication(new ButtonGame(), cfg);
	}
}
