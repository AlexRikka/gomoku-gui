package com.mygdx.gomokugame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.gomokugame.GomokuGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Gomoku";
		config.width = 800;
		config.height = 800;
		new LwjglApplication(new GomokuGame(), config);
	}
}
