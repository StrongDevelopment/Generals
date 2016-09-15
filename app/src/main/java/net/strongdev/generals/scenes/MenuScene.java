package net.strongdev.generals.scenes;

import android.graphics.Color;
import android.widget.Toast;

import net.strongdev.generals.managers.Resources;
import net.strongdev.generals.managers.Scenes;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnAreaTouchListener;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

/**
 * Created by oleg on 14.09.16.
 */
public class MenuScene extends Base implements IOnSceneTouchListener, IOnAreaTouchListener {
    @Override
    public void createScene() {
        //Включает обработку касаний для сцены
        setTouchAreaBindingOnActionDownEnabled(true);
        //Фоновое изображение
        Sprite menuBackgroundSprite = new Sprite(0, 0, Resources.getInstance().menuBackgroundRegion,
                Resources.getInstance().vbom);
        //Оверлей (розовые линии)
        Sprite menuOverlaySprite = new Sprite(0, 0, Resources.getInstance().menuOverlayRegion,
                Resources.getInstance().vbom);
        //Логотип
        Sprite menuLogoSprite = new Sprite((Resources.getInstance().boundCamera.getWidth()
                - Resources.getInstance().menuLogoRegion.getWidth())/2, 100,
                Resources.getInstance().menuLogoRegion,
                Resources.getInstance().vbom);

        float logoXRight = menuLogoSprite.getX() + menuLogoSprite.getWidth();

        //Кнопка "Старт"
        ButtonSprite btnStartSprite = new ButtonSprite(logoXRight -
                Resources.getInstance().menuBtnStart.getWidth(0), menuLogoSprite.getHeight() + 100 + 30,
                Resources.getInstance().menuBtnStart.getTextureRegion(0),
                Resources.getInstance().menuBtnStart.getTextureRegion(2),
                Resources.getInstance().vbom) {

            //Обработчик касания кнопки "Старт"
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        //Кнопка "Об игре"
        ButtonSprite btnAboutSprite = new ButtonSprite(logoXRight -
                Resources.getInstance().menuBtnAbout.getWidth(0), btnStartSprite.getY() +
                btnStartSprite.getHeight() + 30,
                Resources.getInstance().menuBtnAbout.getTextureRegion(0),
                Resources.getInstance().menuBtnAbout.getTextureRegion(2),
                Resources.getInstance().vbom) {

            //Обработчик касания кнопки "Об игре"
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };



        //Кнопка "Выход"
        ButtonSprite btnExitSprite = new ButtonSprite(logoXRight -
                Resources.getInstance().menuBtnExit.getWidth(0), btnAboutSprite.getY() +
                btnAboutSprite.getHeight() + 30,
                Resources.getInstance().menuBtnExit.getTextureRegion(0),
                Resources.getInstance().menuBtnExit.getTextureRegion(2),
                Resources.getInstance().vbom) {

            //Обработчик касания кнопки "Выход"
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };



        //Создание спрайта с фоном
        SpriteBackground menuBackground = new SpriteBackground(0,0,0,menuBackgroundSprite);
        //Установка спрайта на фон
        setBackground(menuBackground);
        //Включение фона
        setBackgroundEnabled(true);
        //Добавление в сцену оверлея
        attachChild(menuOverlaySprite);
        //Установка логотипа по центру экрана
        //menuLogoSprite.setPosition((Resources.getInstance().boundCamera.getWidth() - menuLogoSprite.getWidth())/2,
        //        (Resources.getInstance().boundCamera.getHeight()/2 - menuLogoSprite.getHeight())/2);
        //Добавление в сцену логотипа
        attachChild(menuLogoSprite);
        //Регистрация области кнопки "Об игре" для отслеживания касания
        registerTouchArea(btnAboutSprite);
        //Добавление в сцену кнопки "Об игре"
        attachChild(btnAboutSprite);
        //Регистрация области кнопки "Выход" для отслеживания касания
        registerTouchArea(btnExitSprite);
        //Добавление в сцену кнопки "Выход"
        attachChild(btnExitSprite);
        //Регистрация области кнопки "Об игре" для отслеживания касания
        registerTouchArea(btnStartSprite);
        //Добавление в сцену кнопки "Об игре"
        attachChild(btnStartSprite);

    }

    @Override
    public void onBackKeyPressed() {
        generalsActivity.finish();
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
