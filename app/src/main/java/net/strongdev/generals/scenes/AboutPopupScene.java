package net.strongdev.generals.scenes;

import android.graphics.Color;
import android.opengl.GLES20;

import net.strongdev.generals.R;
import net.strongdev.generals.managers.Scenes;

import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.AutoWrap;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.util.HorizontalAlign;

/**
 * Created by oleg on 16.09.16.
 */
public class AboutPopupScene extends Popup {

    private BuildableBitmapTextureAtlas bbtaPopup;
    private ITextureRegion aboutPopupBackground;
    private ITiledTextureRegion aboutPopupButtonOK;
    private Font aboutTextFont;
    private String strAbout;

    Sprite background;

    public void setBackground() {
        background = new Sprite((boundCamera.getWidth() - aboutPopupBackground.getWidth()) / 2,
                (boundCamera.getHeight() - aboutPopupBackground.getHeight()) / 2,
                aboutPopupBackground, vbom);
        background.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);

        SpriteBackground spriteBackground = new SpriteBackground(background);
        spriteBackground.setColorEnabled(false);

        setBackground(spriteBackground);
        setBackgroundEnabled(true);
    }

    public void setButtons() {
        ButtonSprite btnOk = new ButtonSprite(background.getX() + background.getWidth()/2
                - aboutPopupButtonOK.getWidth()/2, background.getY() + background.getHeight()
                - aboutPopupButtonOK.getHeight() - 20, aboutPopupButtonOK, vbom) {
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX,
                                         float pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    Scenes.getInstance().closePopup();
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        btnOk.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);

        registerTouchArea(btnOk);
        attachChild(btnOk);
    }

    public void setText() {
        Text text = new Text(background.getX() + 20, background.getY() + 20, aboutTextFont, strAbout,
                new TextOptions(AutoWrap.WORDS, 530, HorizontalAlign.CENTER), vbom);
        attachChild(text);
    }


    @Override
    public void createPopup() {

        setBackground();
        setButtons();
        setText();

    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public Scenes.PopupType getPopupType() {
        return Scenes.PopupType.POPUP_ABOUT;
    }

    @Override
    public void disposeScene() {

    }

    @Override
    public void createResources() {
        bbtaPopup = new BuildableBitmapTextureAtlas(engine.getTextureManager(), 1024, 1024);
        aboutPopupBackground = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaPopup,
                generalsActivity, "popup/about/background.png");
        aboutPopupButtonOK = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
                bbtaPopup, generalsActivity, "popup/about/btn-ok.png", 2, 1
        );
        try {
            bbtaPopup.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,1,1));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            e.printStackTrace();
        }
        bbtaPopup.load();

        //Создание шрифта для надписи Об игре
        aboutTextFont = FontFactory.createFromAsset(generalsActivity.getFontManager(), generalsActivity.getTextureManager(),
                256, 256, generalsActivity.getAssets(), "Jura-Medium.ttf", 30, true, Color.WHITE);
        //Загрузка шрифта
        aboutTextFont.load();
        //Получение строки из xml файла
        strAbout = generalsActivity.getString(R.string.about_game);
    }

    @Override
    public void destroyResources() {
        bbtaPopup.unload();
        bbtaPopup = null;
        aboutPopupBackground = null;
        aboutPopupButtonOK = null;
    }
}
