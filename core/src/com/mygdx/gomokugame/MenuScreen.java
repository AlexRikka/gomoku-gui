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
import org.lwjgl.util.Rectangle;

public class MenuScreen implements Screen {
    final GomokuGame game;

    //SpriteBatch batch;
    Texture img, img2;
    Sprite sprite;
    OrthographicCamera cam;
    Rectangle Tbounds, Inbounds;

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
        //cam = new OrthographicCamera(400, 400);
        //cam.position.set(200, 200, 0);
        img2 = new Texture("yungi.jpg");
        Tbounds = new Rectangle((int) pX, (int) pY, (int) W, (int) H);
        was_t = false;
    }

    @Override
    public void show() {}


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //cam.update();
        //batch.setProjectionMatrix(cam.combined);
        game.batch.begin(); //начать отрисовку
     /*   batch.disableBlending();
        sprite.draw(batch);
        batch.enableBlending();*/
        //batch.draw(img, W, H);
        game.batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // растягивает текстуру до границ экрана
        game.batch.draw(img2, pX, pY, W, H);
        game.batch.end(); //закончить отрисовку
        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
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
