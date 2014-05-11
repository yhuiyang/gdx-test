package com.yhsoftlab.gdxtest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MyGdxTestGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;

    TextureAtlas packedAtlas;
    TextureAtlas.AtlasRegion region1;
    TextureAtlas.AtlasRegion region2;
    Sprite sprite;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        packedAtlas = new TextureAtlas(Gdx.files.internal("pack.atlas"));
        region1 = packedAtlas.findRegion("zh_TW/menuitem_play");
        region2 = packedAtlas.findRegion("en_US/menuitem_play");
        sprite = packedAtlas.createSprite("zh_TW/adv_btn");
        sprite.setX(img.getWidth());
        sprite.setY(img.getHeight() + region1.getRegionHeight() + region2.getRegionHeight());
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.draw(region1, img.getWidth(), img.getHeight());
        batch.draw(region2, img.getWidth() - region1.getRegionWidth(), img.getHeight() + region1.getRegionHeight());
        sprite.draw(batch);
        batch.end();
    }
}
