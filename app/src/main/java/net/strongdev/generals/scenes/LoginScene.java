package net.strongdev.generals.scenes;

import net.strongdev.generals.managers.Resources;
import net.strongdev.generals.managers.Scenes;

import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

/**
 * Created by oleg on 17.09.16.
 */
public class LoginScene extends Base {

    private BuildableBitmapTextureAtlas bbtaLoginScene;
    private ITextureRegion loginSceneBackgroundRegion;
    private ITextureRegion loginSceneOverlayRegion;
    private ITextureRegion loginSceneListRegion;
    private ITextureRegion loginSceneLogoRegion;
    private ITiledTextureRegion loginSceneBtnAdd;
    private ITiledTextureRegion loginSceneBtnEnter;
    private ITiledTextureRegion loginSceneBtnCancel;
    private ITiledTextureRegion loginSceneBtnReg;

    private Sprite loginSceneBackgroundSprite;
    private Sprite loginSceneOverlaySprite;
    private Sprite loginSceneLogoSprite;
    private Sprite loginSceneListSprite;

    private float logoXRight;

    private ButtonSprite btnAddSprite, btnEnterSprite, btnCancelSprite, btnRegSprite;

    public void setBackground() {

        //Фоновое изображение
        loginSceneBackgroundSprite = new Sprite(0, 0, loginSceneBackgroundRegion, vbom);
        //Оверлей (розовые линии)
        loginSceneOverlaySprite = new Sprite(0, 0, loginSceneOverlayRegion, vbom);
        loginSceneListSprite = new Sprite(0, 0, loginSceneListRegion, vbom);
        //Логотип
        loginSceneLogoSprite = new Sprite((Resources.getInstance().boundCamera.getWidth()
                - loginSceneLogoRegion.getWidth())/2, 20, loginSceneLogoRegion, vbom);

        logoXRight = loginSceneLogoSprite.getX() + loginSceneLogoSprite.getWidth();

        //Создание спрайта с фоном
        SpriteBackground loginSceneBackground = new SpriteBackground(0,0,0,loginSceneBackgroundSprite);
        //Установка спрайта на фон
        setBackground(loginSceneBackground);
        //Включение фона
        setBackgroundEnabled(true);
        //Добавление в сцену оверлея
        attachChild(loginSceneOverlaySprite);
        attachChild(loginSceneListSprite);

        attachChild(loginSceneLogoSprite);
        //Регистрация области кнопки "Об игре" для отслеживания касания
    }

    public void setButtons() {
        //Кнопка "Старт"
        btnAddSprite = new ButtonSprite(loginSceneBackgroundSprite.getWidth()/2+5, 517,
                loginSceneBtnAdd.getTextureRegion(0), loginSceneBtnAdd.getTextureRegion(2), vbom) {

            //Обработчик касания кнопки "Старт"
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {
                    Scenes.getInstance().showPopup(Scenes.PopupType.POPUP_ADD);
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        //Кнопка "Об игре"
        btnEnterSprite = new ButtonSprite(loginSceneBackgroundSprite.getWidth()/2 -
                loginSceneBtnEnter.getWidth()-5, 517, loginSceneBtnEnter.getTextureRegion(0),
                loginSceneBtnEnter.getTextureRegion(2), vbom) {

            //Обработчик касания кнопки "Об игре"
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };



        //Кнопка "Выход"
        btnCancelSprite = new ButtonSprite(loginSceneBackgroundSprite.getWidth()/2+5,630,
                loginSceneBtnCancel.getTextureRegion(0), loginSceneBtnCancel.getTextureRegion(2), vbom) {

            //Обработчик касания кнопки "Выход"
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        //Кнопка "Выход"
        btnRegSprite = new ButtonSprite(loginSceneBackgroundSprite.getWidth()/2 -
                loginSceneBtnReg.getWidth()-5,630, loginSceneBtnReg.getTextureRegion(0),
                loginSceneBtnReg.getTextureRegion(2), vbom) {

            //Обработчик касания кнопки "Выход"
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {

                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        /*TiledSprite btnSoundSprite = new TiledSprite(30, 30, Resources.getInstance().menuBtnSound,
                vbom) {

            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

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
        };*/

        //btnSoundSprite.setScale(2);

        registerTouchArea(btnAddSprite);

        attachChild(btnAddSprite);

        registerTouchArea(btnEnterSprite);

        attachChild(btnEnterSprite);

        registerTouchArea(btnCancelSprite);

        attachChild(btnCancelSprite);

        registerTouchArea(btnRegSprite);

        attachChild(btnRegSprite);

        //Регистрация области кнопки звука
        //registerTouchArea(btnSoundSprite);
        //Добавление в сцену кнопки звука
        //attachChild(btnSoundSprite);
    }

    @Override
    public void createScene() {
        setBackground();
        setButtons();
    }

    @Override
    public void onBackKeyPressed() {
        Scenes.getInstance().setScene(Scenes.SceneType.SCENE_MAIN_MENU);
    }

    @Override
    public Scenes.SceneType getSceneType() {
        return Scenes.SceneType.SCENE_LOGIN;
    }

    @Override
    public void disposeScene() {
        this.detachSelf();
        this.dispose();
    }

    @Override
    public void createResources() {
        //Создание экземпляра собираемого атласа
        bbtaLoginScene = new BuildableBitmapTextureAtlas(generalsActivity.getTextureManager(), 4096, 4096);
        //Создание регионов
        loginSceneBackgroundRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaLoginScene,
                generalsActivity, "loginmenu/background.png");
        loginSceneOverlayRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaLoginScene,
                generalsActivity, "loginmenu/overlay.png");
        loginSceneListRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaLoginScene,
                generalsActivity, "loginmenu/list.png");
        loginSceneLogoRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaLoginScene,
                generalsActivity, "loginmenu/logo.png");
        loginSceneBtnAdd = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbtaLoginScene,
                generalsActivity, "loginmenu/btn-add.png", 3, 1);
        loginSceneBtnEnter = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbtaLoginScene,
                generalsActivity, "loginmenu/btn-enter.png", 3, 1);;
        loginSceneBtnCancel = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbtaLoginScene,
                generalsActivity, "loginmenu/btn-cancel.png", 3, 1);;
        loginSceneBtnReg = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bbtaLoginScene,
                generalsActivity, "loginmenu/btn-reg.png", 3, 1);;

        try {
            bbtaLoginScene.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0,1,1));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            e.printStackTrace();
        }

        bbtaLoginScene.load();
    }

    @Override
    public void destroyResources() {

    }
}
