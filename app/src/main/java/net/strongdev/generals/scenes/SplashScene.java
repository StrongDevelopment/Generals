package net.strongdev.generals.scenes;

import net.strongdev.generals.R;
import net.strongdev.generals.managers.Resources;
import net.strongdev.generals.managers.Scenes;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
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
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;
import org.andengine.util.modifier.IModifier;



/**
 * Created by oleg on 14.09.16.
 */
public class SplashScene extends Base implements Runnable {

    private BuildableBitmapTextureAtlas bbtaSplash;
    private ITextureRegion splashScreenRegion;
    private ITextureRegion splashScreenStrongdev;
    private Font splashScreenFont;
    private String strTabToContinue;

    private Text textTapToContinue;

    @Override
    public void createScene() {
        setTouchAreaBindingOnActionDownEnabled(true);

        Sprite splashScreenSprite = new Sprite(0, 0, splashScreenRegion, vbom);

        SpriteBackground splashBackground = new SpriteBackground(splashScreenSprite);

        setBackground(splashBackground);
        setBackgroundEnabled(true);

        Sprite splashScreenStrongDevSprite = new Sprite(
                boundCamera.getWidth() - splashScreenStrongdev.getWidth() - 20,
                boundCamera.getHeight() - splashScreenStrongdev.getHeight() - 20,
                splashScreenStrongdev, vbom
        );

        attachChild(splashScreenStrongDevSprite);


        textTapToContinue = new Text(0, 0, splashScreenFont, strTabToContinue,
                new TextOptions(HorizontalAlign.CENTER), vbom) {
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX,
                                         float pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                    Scenes.getInstance().setScene(Scenes.SceneType.SCENE_MAIN_MENU);
                }
                return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
            }
        };

        textTapToContinue.setPosition(boundCamera.getWidth()/2 - textTapToContinue.getWidth()/2, 450);

        attachChild(textTapToContinue);

        registerTouchArea(textTapToContinue);

        Thread t = new Thread(this);
        t.start();

    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public Scenes.SceneType getSceneType() {
        return Scenes.SceneType.SCENE_SPLASH;
    }

    @Override
    public void disposeScene() {
        this.detachSelf();
        this.dispose();
    }

    @Override
    public void createResources() {

        //Создание экземляра собираемого атласа
        bbtaSplash = new BuildableBitmapTextureAtlas(engine.getTextureManager(), 2048, 2048);
        //Создание области с фоном загрузочного экрана
        splashScreenRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaSplash,
                generalsActivity, "splash/splash.png");
        //Создание области с логотипом StrongDev
        splashScreenStrongdev = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbtaSplash,
                generalsActivity, "splash/strongdev.png");
        //Попытка построения атласа с областями
        try {
            bbtaSplash.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
                    BitmapTextureAtlas>(0, 1, 1));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            e.printStackTrace();
        }
        //Загрузка атласа
        bbtaSplash.load();
        //Создание шрифта для надписи "Нажмите, чтобы продолжить"
        splashScreenFont = FontFactory.createFromAsset(generalsActivity.getFontManager(),
                generalsActivity.getTextureManager(),
                256, 256, generalsActivity.getAssets(), "Jura-Medium.ttf", 48, true,
                android.graphics.Color.WHITE);
        //Загрузка шрифта
        splashScreenFont.load();
        //Получение строки из xml файла
        strTabToContinue = generalsActivity.getString(R.string.tap_to_continue);

    }

    @Override
    public void destroyResources() {
        //Уничтожение атласа и ресурсов
        bbtaSplash.unload();
        bbtaSplash = null;
        splashScreenRegion = null;
        splashScreenStrongdev = null;
        splashScreenFont.unload();
        splashScreenFont = null;
    }


    @Override
    public void run() {
        while (true) {
            textTapToContinue.setVisible(!textTapToContinue.isVisible());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
