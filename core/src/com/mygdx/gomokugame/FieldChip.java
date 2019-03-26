package com.mygdx.gomokugame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class FieldChip {
    ImageButton chip;
    ImageButton.ImageButtonStyle imageButtonStyle;
    ImageButton.ImageButtonStyle chipStyle;
    TextureAtlas MenuAtlas;
    Skin buttonSkin;
    float xx, yy;

    public FieldChip() {
        MenuAtlas = new TextureAtlas(Gdx.files.internal("bmenu.pack"));
        buttonSkin = new Skin();
        buttonSkin.addRegions(MenuAtlas);
        this.chipStyle = new ImageButton.ImageButtonStyle();
        //chipStyle.up = buttonSkin.getDrawable("black-circle-p-200"); //когда ничего не далаешь
        //this.chipStyle.down = buttonSkin.getDrawable("black-circle-200"); //мигает при нажатии
        this.chipStyle.checked = buttonSkin.getDrawable("black-circle-200"); //после нажатия
        this.chip = new ImageButton(chipStyle);
        this.chip.setSize(30, 30);
    }

    public FieldChip(float x, float y) {
        MenuAtlas = new TextureAtlas(Gdx.files.internal("bmenu.pack"));
        buttonSkin = new Skin();
        buttonSkin.addRegions(MenuAtlas);
        this.chipStyle = new ImageButton.ImageButtonStyle();
        //chipStyle.up = buttonSkin.getDrawable("black-circle-p-200"); //когда ничего не далаешь
        //this.chipStyle.down = buttonSkin.getDrawable("black-circle-200"); //мигает при нажатии
        this.chipStyle.checked = buttonSkin.getDrawable("black-circle-200"); //после нажатия
        this.chip = new ImageButton(chipStyle);
        this.chip.setSize(30, 30);
        this.chip.setPosition(x,y);
        xx = x;
        yy = y;
    }

    public ImageButton getChip() {
        return chip;
    }

    public void setChipColor(int color){
        if (color ==  1) {
            this.chipStyle.down = buttonSkin.getDrawable("white-circle-200"); //мигает при нажатии
            this.chipStyle.checked = buttonSkin.getDrawable("white-circle-200"); //после нажатия
        }else{
            this.chipStyle.down = buttonSkin.getDrawable("black-circle-200"); //мигает при нажатии
            this.chipStyle.checked = buttonSkin.getDrawable("black-circle-200"); //после нажатия
        }
    }

    public void setChipXY(float x, float y) {
        this.chip.setPosition(x,y);
        xx = x;
        yy = y;
    }
}
