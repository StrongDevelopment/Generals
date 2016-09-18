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
 * Created by oleg on 18.09.16.
 */
public class AddPopupScene extends Popup {

    private BuildableBitmapTextureAtlas bbtaAdd;
    private ITextureRegion addPopupBackGround;
    private ITextureRegion addPopupField;
    private ITiledTextureRegion addPopupBtnEnter;
    private ITiledTextureRegion addPopupBtnCancel;
    private Font addPopupHeaderFont;
    private Font addPopupLabelFont;

    private String textName;
    private String textPass;

    private Sprite background;
    private float backgroundX = 0, backgroundY = 0;

    private void setBackground() {
        backgroundX = (boundCamera.getWidth() - addPopupBackGround.getWidth()) / 2;
        backgroundY = (boundCamera.getHeight() - addPopupBackGround.getHeight()) / 2;
        background = new Sprite(backgroundX, backgroundY, addPopupBackGround, vbom);
        background.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);

        SpriteBackground spriteBackground = new SpriteBackground(background);
        spriteBackground.setColorEnabled(false);

        setBackground(spriteBackground);
        setBackgroundEnabled(true);
    }

    private void setFields() {
        Sprite fieldLoginSprite = new Sprite(backgroundX + 165, backgroundY + 90,
                addPopupField, vbom) {
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        fieldLoginSprite.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
        Sprite fieldPassSprite = new Sprite(backgroundX + 165, backgroundY + 150,
                addPopupField, vbom) {
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };
        fieldPassSprite.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);

        registerTouchArea(fieldLoginSprite);
        registerTouchArea(fieldPassSprite);

        Text labelName = new Text(0, 0, addPopupLabelFont, textName, vbom);
        Text labelPass = new Text(0, 0, addPopupLabelFont, textPass, vbom);

        labelName.setPosition(fieldLoginSprite.getX() - labelName.getWidth() - 10, 100);
        labelPass.setPosition(fieldPassSprite.getX() - labelName.getWidth() - 10, 160);

        attachChild(fieldLoginSprite);
        attachChild(fieldPassSprite);
        attachChild(labelName);
        attachChild(labelPass);
    }

    private void setButtons() {
        ButtonSprite btnEnter = new ButtonSprite(backgroundX + 65, backgroundY + 290,
                addPopupBtnEnter, vbom) {
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX,
                                         float pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    Scenes.getInstance().closePopup();
                }
                //return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
                return false;
            }
        };

        ButtonSprite btnCancel = new ButtonSprite(backgroundX + 320, backgroundY + 290,
                addPopupBtnCancel, vbom) {
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX,
                                         float pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    Scenes.getInstance().closePopup();
                }
                //return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
                return false;
            }
        };

        btnEnter.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);
        //btnEnter.setBlendFunction(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);

        registerTouchArea(btnEnter);
        registerTouchArea(btnCancel);
        attachChild(btnEnter);
        attachChild(btnCancel);
    }


    @Override
    public void createPopup() {

        setBackground();
        setFields();
    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public Scenes.PopupType getPopupType() {
        return Scenes.PopupType.POPUP_ADD;
    }

    @Override
    public void disposeScene() {

    }

    @Override
    public void createResources() {
        bbtaAdd = new BuildableBitmapTextureAtlas(resources.generalsActivity.getTextureManager(), 2048, 2048);
        addPopupBackGround = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaAdd, resources.generalsActivity,
                "popup/add/background.png");
        addPopupField = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaAdd, resources.generalsActivity,
                "popup/add/field.png");
        addPopupBtnEnter = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbtaAdd,
                resources.generalsActivity, "popup/add/btn-enter.png", 2, 1);
        addPopupBtnCancel = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbtaAdd,
                resources.generalsActivity, "popup/add/btn-cancel.png", 2, 1);
        addPopupHeaderFont = FontFactory.createFromAsset(resources.generalsActivity.getFontManager(),
                resources.generalsActivity.getTextureManager(), 256, 256,
                resources.generalsActivity.getAssets(), "Jura-Medium.ttf", 30, true, Color.rgb(255, 255, 255));
        addPopupLabelFont = FontFactory.createFromAsset(resources.generalsActivity.getFontManager(),
                resources.generalsActivity.getTextureManager(), 256, 256,
                resources.generalsActivity.getAssets(), "Jura-Medium.ttf", 24, true, Color.rgb(255, 255, 255));

        try {
            bbtaAdd.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,1,1));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            e.printStackTrace();
        }

        textName = resources.generalsActivity.getString(R.string.text_field_name);
        textPass = resources.generalsActivity.getString(R.string.text_field_pass);

        bbtaAdd.load();
    }

    @Override
    public void destroyResources() {
        bbtaAdd.unload();
        bbtaAdd = null;
        addPopupBackGround = null;
        addPopupField = null;
        addPopupBtnEnter = null;
        addPopupBtnCancel = null;
        addPopupHeaderFont = null;
        addPopupLabelFont = null;
    }
}
