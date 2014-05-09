package com.yhsoftlab.gdxtest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class MyGdxTestGame extends ApplicationAdapter {
    SpriteBatch batch;
    BitmapFont font;

    @Override
    public void create () {
        batch = new SpriteBatch();

        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("WCL-10.ttf"));
        gen.setMaxTextureSize(512);
        FreeTypeFontParameter fontParam = new FreeTypeFontParameter();
        fontParam.size = 38;
        fontParam.characters = "ABCDE Libgdx事先預備好的中文！等一下來使用，沒有就是看不見。";
        fontParam.flip = false;
        font = gen.generateFont(fontParam);
        gen.dispose();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //batch.draw(font.getRegion(), 0, 0);
        font.draw(batch, "Libgdx是可以使用中文的！", 50, 350);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        font.dispose();
    }
}
