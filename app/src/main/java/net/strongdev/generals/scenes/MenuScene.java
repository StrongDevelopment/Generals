package net.strongdev.generals.scenes;

import android.graphics.Color;

import net.strongdev.generals.managers.Resources;
import net.strongdev.generals.managers.Scenes;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnAreaTouchListener;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

/**
 * Created by oleg on 14.09.16.
 */
public class MenuScene extends Base implements IOnSceneTouchListener, IOnAreaTouchListener {
    @Override
    public void createScene() {
        Sprite menuBackgroundSprite = new Sprite(0, 0, Resources.getInstance().menuBackgroundRegion,
                Resources.getInstance().vbom);

        SpriteBackground menuBackground = new SpriteBackground(0,0,0,menuBackgroundSprite);

        setBackground(menuBackground);

        setBackgroundEnabled(true);
    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public Scenes.SceneType getSceneType() {
        return Scenes.SceneType.SCENE_MENU;
    }

    @Override
    public void disposeScene() {
        this.detachSelf();
        this.dispose();
    }

    @Override
    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        return false;
    }

    @Override
    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, ITouchArea pTouchArea, float pTouchAreaLocalX, float pTouchAreaLocalY) {
        return false;
    }
}
