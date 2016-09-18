package net.strongdev.generals.scenes;

import android.graphics.Color;
import android.widget.Toast;

import net.strongdev.generals.managers.Resources;
import net.strongdev.generals.managers.Scenes;

import org.andengine.audio.music.MusicFactory;
import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnAreaTouchListener;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import java.io.IOException;

/**
 * Created by oleg on 14.09.16.
 */
public class MainMenuScene extends Base implements IOnSceneTouchListener, IOnAreaTouchListener {

    private BuildableBitmapTextureAtlas bbtaMainMenu;
    private ITextureRegion menuBackgroundRegion;
    private ITextureRegion menuOverlayRegion;
    private ITextureRegion menuLogoRegion;
    private ITiledTextureRegion menuBtnAbout;
    private ITiledTextureRegion menuBtnExit;
    private ITiledTextureRegion menuBtnStart;
    private ITiledTextureRegion menuBtnSound;

    private float logoXRight;
    private Sprite menuLogoSprite;
    private Sprite menuOverlaySprite;
    private Sprite menuBackgroundSprite;

    private ButtonSprite btnAboutSprite;
    private ButtonSprite btnExitSprite;
    private ButtonSprite btnStartSprite;

    public void setBackground() {

        //Фоновое изображение
        menuBackgroundSprite = new Sprite(0, 0, menuBackgroundRegion, vbom);
        //Оверлей (розовые линии)
        menuOverlaySprite = new Sprite(0, 0, menuOverlayRegion, vbom);
        //Логотип
        menuLogoSprite = new Sprite((Resources.getInstance().boundCamera.getWidth()
                - menuLogoRegion.getWidth())/2, 100, menuLogoRegion, vbom);

        logoXRight = menuLogoSprite.getX() + menuLogoSprite.getWidth();

        //Создание спрайта с фоном
        SpriteBackground menuBackground = new SpriteBackground(0,0,0,menuBackgroundSprite);
        //Установка спрайта на фон
        setBackground(menuBackground);
        //Включение фона
        setBackgroundEnabled(true);
        //Добавление в сцену оверлея
        attachChild(menuOverlaySprite);
        //Установка логотипа по центру экрана
        attachChild(menuLogoSprite);
        //Регистрация области кнопки "Об игре" для отслеживания касания
    }

    public void setButtons() {
        //Кнопка "Старт"
        btnStartSprite = new ButtonSprite(logoXRight - menuBtnStart.getWidth(0),
                menuLogoSprite.getHeight() + 100 + 30, menuBtnStart.getTextureRegion(0),
                menuBtnStart.getTextureRegion(2), vbom) {

            //Обработчик касания кнопки "Старт"
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX,
                                         float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {
                    Scenes.getInstance().setScene(Scenes.SceneType.SCENE_LOGIN);
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        //Кнопка "Об игре"
        btnAboutSprite = new ButtonSprite(logoXRight - menuBtnAbout.getWidth(0),
                btnStartSprite.getY() + btnStartSprite.getHeight() + 30,
                menuBtnAbout.getTextureRegion(0), menuBtnAbout.getTextureRegion(2), vbom) {

            //Обработчик касания кнопки "Об игре"
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX,
                                         float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {
                    Scenes.getInstance().showPopup(Scenes.PopupType.POPUP_ABOUT);
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };



        //Кнопка "Выход"
        btnExitSprite = new ButtonSprite(logoXRight - menuBtnExit.getWidth(0),
                btnAboutSprite.getY() + btnAboutSprite.getHeight() + 30,
                menuBtnExit.getTextureRegion(0), menuBtnExit.getTextureRegion(2), vbom) {

            //Обработчик касания кнопки "Выход"
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX,
                                         float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        TiledSprite btnSoundSprite = new TiledSprite(30, 30, menuBtnSound, vbom) {

            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX,
                                         float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {
                    if (this.getCurrentTileIndex() == 0) {
                        this.setCurrentTileIndex(1);
                    } else {
                        this.setCurrentTileIndex(0);
                    }
                    if (resources.mainMusic.isPlaying()) {
                        //pauseMusic();

                    } else {
                        //resumeMusic();
                    }
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        btnSoundSprite.setScale(2);

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
        //Регистрация области кнопки звука
        registerTouchArea(btnSoundSprite);
        //Добавление в сцену кнопки звука
        attachChild(btnSoundSprite);
    }

    public void setMusic() {
        resources.mainMusic.play();
    }

    public void pauseMusic() {
        resources.mainMusic.pause();
    }

    public void resumeMusic() {
        resources.mainMusic.resume();
    }

    @Override
    public void createScene() {

        setBackground();
        setButtons();
        //setMusic();
        //Включает обработку касаний для сцены
        setTouchAreaBindingOnActionDownEnabled(true);
    }



    @Override
    public void onBackKeyPressed() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    public Scenes.SceneType getSceneType() {
        return Scenes.SceneType.SCENE_MAIN_MENU;
    }

    @Override
    public void disposeScene() {
        this.detachSelf();
        this.dispose();
    }

    @Override
    public void createResources() {
        //Создание экземпляра собираемого атласа
        bbtaMainMenu = new BuildableBitmapTextureAtlas(engine.getTextureManager(), 4048, 4048);
        //Создание области с фоном главного меню
        menuBackgroundRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaMainMenu,
                generalsActivity, "mainmenu/background.png");
        //Создание области с оверлеем
        menuOverlayRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaMainMenu,
                generalsActivity, "mainmenu/overlay.png");
        //Создание области с логотипом
        menuLogoRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaMainMenu,
                generalsActivity, "mainmenu/logo.png");
        //Создание областей с кнопками главного меню
        menuBtnAbout = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbtaMainMenu,
                generalsActivity, "mainmenu/btn-about.png", 3, 1);
        menuBtnExit = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbtaMainMenu,
                generalsActivity, "mainmenu/btn-exit.png", 3, 1);
        menuBtnStart = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbtaMainMenu,
                generalsActivity, "mainmenu/btn-start.png", 3, 1);
        //Создание области с кнопкой звука
        menuBtnSound = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbtaMainMenu,
                generalsActivity, "mainmenu/btn-sound.png", 2, 1);
        //Построение атласа
        try {
            bbtaMainMenu.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 1));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            e.printStackTrace();
        }
        //Загрузка атласа
        bbtaMainMenu.load();

        try {
            Resources.getInstance().mainMusic = MusicFactory.createMusicFromAsset(generalsActivity.getMusicManager(),
                    generalsActivity, "main.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroyResources() {
        bbtaMainMenu.unload();
        bbtaMainMenu = null;
        menuBackgroundRegion = null;
        menuOverlayRegion = null;
        menuLogoRegion = null;
        menuBtnAbout = null;
        menuBtnExit = null;
        menuBtnStart = null;
        menuBtnSound = null;
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
