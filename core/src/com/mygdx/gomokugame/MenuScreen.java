package com.mygdx.gomokugame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import org.lwjgl.util.Rectangle;

public class MenuScreen implements Screen {
    final GomokuGame game;

    //SpriteBatch batch;
    Texture img, img2;
    Sprite sprite;
    Rectangle Tbounds, Inbounds;
    TextButton tbStart;
    TextButton.TextButtonStyle tbsBlack, tbsWhite;
    Skin buttonSkin;
    TextureAtlas MenuAtlas;

    static float W, H, pX, pY;
    boolean was_t;

    public MenuScreen(final GomokuGame gam){
        this.game = gam;
        game.batch = new SpriteBatch();
        img = new Texture("crytae.jpg");
        W = 200;
        H = 200;
        pX = 300;
        pY = 300;
        img2 = new Texture("yungi.jpg");
        Tbounds = new Rectangle((int)pX, (int)pY, (int)W, (int)H);
        was_t = false;
        MenuAtlas = new TextureAtlas(Gdx.files.internal("gomoku.pack"));
        buttonSkin = new Skin(MenuAtlas);
        tbsBlack.over = buttonSkin.getDrawable("black_circle");
        tbStart = new TextButton("Start", tbsBlack);
        tbStart.setPosition(300, 300);
        tbStart.setSize(200, 200);
    }

    @Override
    public void show() {}


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin(); //начать отрисовку
        //game.batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // растягивает текстуру до границ экрана
        game.batch.draw(img2, pX, pY, W, H);
        tbStart.draw(game.batch, delta);
        game.batch.end(); //закончить отрисовку
        if (Gdx.input.justTouched()) {
            if (Tbounds.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
                game.setScreen(new GameScreen(game));
                dispose();
            }
        }
       /* if (Gdx.input.justTouched()) {

            if (was_t) {
                if (Tbounds.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    W -= 200;
                    H -= 200;
                    pX += 100;
                    pY += 100;
                    was_t = false;
                }
            } else {
                if (Tbounds.contains(Gdx.input.getX(), Gdx.input.getY())) {
                    was_t = true;
                    W += 200;
                    H += 200;
                    pX -= 100;
                    pY -= 100;
                }
            }
        }*/
        //if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) W = 0;
        //if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) W = 400;

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
