package com.mygdx.gomokugame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class GameScreen implements Screen {
    final GomokuGame game;


    Stage stage;
    Texture background1, TurnB, TurnW;
    ShapeRenderer lineRenderer, dotRenderer;
    BitmapFont font;
    FieldChip[][] FieldChips;
    TextureAtlas MenuAtlas;
    Skin buttonSkin;
    int turn;

    static final int CellSize = 33;
    public static int FieldSize;
    public static int FieldPosX = 11, FieldPosY = 3, mysteriousX = 400, mysteriousY = 100;

    public GameScreen(final GomokuGame gam) {
        this.game = gam;
        game.batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport(), game.batch);
        Gdx.input.setInputProcessor(stage);

        FieldSize = 19;
        lineRenderer = new ShapeRenderer();
        dotRenderer = new ShapeRenderer();
        lineRenderer.setAutoShapeType(true);
        dotRenderer.setAutoShapeType(true);

        font = new BitmapFont(Gdx.files.internal("menuf.fnt"));
        TurnB = new Texture("black-circle-200.png");
        TurnW = new Texture("white-circle-200.png");
        turn = -1; // черный
    }

    @Override
    public void show() {
        background1 = new Texture("bckpln5.png");
        FieldChips = new FieldChip[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                FieldChips[i][j] = new FieldChip(FieldPosX * CellSize - 15 + 33 * i, FieldPosY * CellSize - 15 + 33 * j);
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                stage.addActor(FieldChips[i][j].getChip());
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                final int finalI = i;
                final int finalJ = j;
                FieldChips[i][j].getChip().addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        if (turn == -1) {
                            FieldChips[finalI][finalJ].setChipColor(-1);
                            turn *= -1;
                        } else {
                            FieldChips[finalI][finalJ].setChipColor(1);
                            turn *= -1;
                        }
                        dispose();
                        return true;
                    }
                });
            }
        }


    }


    // method for whole grid
    public static void grid(ShapeRenderer lineRenderer, ShapeRenderer dotRenderer) {
        for (int x = FieldPosX; x < FieldSize + FieldPosX; x++) {
            for (int y = FieldPosY; y < FieldSize + FieldPosY; y++) {
                lineRenderer.line(x * CellSize, mysteriousY, x * CellSize, y * CellSize);
                lineRenderer.line(mysteriousX, y * CellSize, x * CellSize, y * CellSize);
            }
        }
        //lineRenderer.setColor(0, 1, 1, 1);
        dotRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //dotRenderer.setColor(0, 1, 1, 1);
        int pX = 363, pY = 100;
        dotRenderer.circle(9 * CellSize + pX, 9 * CellSize + pY, 5);
        dotRenderer.circle(4 * CellSize + pX, 4 * CellSize + pY, 5);
        dotRenderer.circle(4 * CellSize + pX, 14 * CellSize + pY, 5);
        dotRenderer.circle(14 * CellSize + pX, 4 * CellSize + pY, 5);
        dotRenderer.circle(14 * CellSize + pX, 14 * CellSize + pY, 5);
        dotRenderer.end();

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.getBatch().begin(); //начать отрисовку
        stage.getBatch().draw(background1, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        if(turn == -1){
            font.draw(stage.getBatch(), "Player 1", 100, 384);
            stage.getBatch().draw(TurnB, 125, 300,50,50);
            font.draw(stage.getBatch(), "Player 2", 1160, 384);
            stage.getBatch().draw(TurnW, 1185, 300,50,50);
        }
        else{
            font.draw(stage.getBatch(), "Player 1", 100, 384);
            stage.getBatch().draw(TurnB, 125, 300,50,50);
            font.draw(stage.getBatch(), "Player 2", 1160, 384);
            stage.getBatch().draw(TurnW, 1185, 300,50,50);
        }
        stage.getBatch().end(); //закончить отрисовку
        lineRenderer.begin(); // begin for field here!!
        grid(lineRenderer, dotRenderer);
        lineRenderer.end();
        stage.draw();
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
