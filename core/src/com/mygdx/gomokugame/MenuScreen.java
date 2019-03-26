package com.mygdx.gomokugame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.lwjgl.util.Rectangle;

public class MenuScreen implements Screen {
    final GomokuGame game;

    Stage stage;
    Texture background1;
    BitmapFont font;
    TextButton tbStart, tbSettings, tbStatistics, tbExit;
    TextButton.TextButtonStyle tbsBlack, tbsWhite;
    Skin buttonSkin;
    TextureAtlas MenuAtlas;

    static float bW, bH, pX, pY;
    boolean was_t;

    public MenuScreen(final GomokuGame gam){
        this.game = gam;
        game.batch = new SpriteBatch();

        stage = new Stage(new ScreenViewport(), game.batch);
        Gdx.input.setInputProcessor(stage);

        background1 = new Texture("bckpln5.png");
        bW = 200;
        bH = 200;
        pX = (Gdx.graphics.getWidth()/2) - bW/2;
        pY = Gdx.graphics.getHeight()/2;
        MenuAtlas = new TextureAtlas(Gdx.files.internal("bmenu.pack"));
        buttonSkin = new Skin();
        buttonSkin.addRegions(MenuAtlas);
    }


    @Override
    public void show() {
        //button style
        tbsBlack = new TextButton.TextButtonStyle();
        tbsBlack.font = new BitmapFont(Gdx.files.internal("menuf.fnt"));
        tbsBlack.up = buttonSkin.getDrawable("black-circle-200");
        tbsBlack.over = buttonSkin.getDrawable("black-circle-p-200");
        //tbsBlack.down = buttonSkin.getDrawable("black-circle");
        //tbsBlack.checked = buttonSkin.getDrawable("white-circle");
        tbsWhite = new TextButton.TextButtonStyle();
        tbsWhite.font = new BitmapFont(Gdx.files.internal("menufb.fnt"));
        tbsWhite.up = buttonSkin.getDrawable("white-circle-200");
        tbsWhite.over = buttonSkin.getDrawable("white-circle-over-200");

        //tb start
        tbStart = new TextButton("Start", tbsBlack);
        tbStart.setPosition(pX, pY + 170);
        tbStart.setSize(bW, bH);
        stage.addActor(tbStart);
        tbStart.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game));
                dispose();
                return true;
            }
        });

        //tb statistics
        tbStatistics = new TextButton("Statistics", tbsWhite);
        tbStatistics.setPosition(pX, pY);
        tbStatistics.setSize(bW, bH);
        stage.addActor(tbStatistics);

        //tb settings
        tbSettings = new TextButton("Settings", tbsBlack);
        tbSettings.setPosition(pX, pY - 170);
        tbSettings.setSize(bW, bH);
        stage.addActor(tbSettings);

        //tb exit
        tbExit = new TextButton("Exit", tbsWhite);
        tbExit.setPosition(pX, pY - 170*2);
        tbExit.setSize(bW, bH);
        stage.addActor(tbExit);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.getBatch().begin(); //начать отрисовку
        stage.getBatch().draw(background1, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // растягивает текстуру до границ экрана
        stage.getBatch().end(); //закончить отрисовку
        stage.draw();
        /*if (Gdx.input.justTouched()) {
            if (Tbounds.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
                game.setScreen(new GameScreen(game));
                dispose();
            }
        }*/
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
