package com.mygdx.gomokugame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuWindow extends ApplicationAdapter {
    SpriteBatch batch;  // типа область отрисовки
    //Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin(); //начать отрисовку
        batch.end(); //закончить отрисовку
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
