package net.strongdev.generals.managers;

import net.strongdev.generals.GeneralsActivity;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.BuildableTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by oleg on 14.09.16.
 */
public class Resources {

    private static final Resources instance = new Resources();

    public Engine engine;
    public GeneralsActivity generalsActivity;
    public Camera camera;
    public BoundCamera boundCamera;
    public VertexBufferObjectManager vbom;

    public BitmapTextureAtlas bitmapTextureAtlas;

    public BuildableBitmapTextureAtlas bbta;

    public BitmapTextureAtlas bta;

    public BitmapTexture bitmapTexture;

    public ITextureRegion textureRegion;

    public ITextureRegion splashScreenRegion;

    //MainMenu
    public ITextureRegion menuBackgroundRegion;
    public ITextureRegion menuOverlayRegion;
    public ITextureRegion menuLogoRegion;


    //end MainMenu



    public TiledTextureRegion tiledTextureRegion;

    public Font font;

    public Sound sound;

    public Music music;

    public BitmapTextureAtlas controlAtlas;

    public ITextureRegion joyBase, joy;

    public static Resources getInstance() {
        return instance;
    }

    public void resourcesPathsInitialize() {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("graphics/");

        FontFactory.setAssetBasePath("fonts/");
        SoundFactory.setAssetBasePath("sound/");
        MusicFactory.setAssetBasePath("music/");
    }

    public void createSplashResources() {

        bta = new BitmapTextureAtlas(engine.getTextureManager(), 2048, 2048, TextureOptions.BILINEAR);
        splashScreenRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bta, generalsActivity,
                "splash/splash.png",0,0);



        bta.load();

    }

    public void destroySplashResources() {
        bta.unload();
        bta = null;
        splashScreenRegion = null;
    }

    public void createMenuResources() {

        bbta = new BuildableBitmapTextureAtlas(engine.getTextureManager(), 4048, 4048);
        menuBackgroundRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbta, generalsActivity,
                "mainmenu/background.png");
        menuOverlayRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbta, generalsActivity,
                "mainmenu/overlay.png");
        menuLogoRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bbta, generalsActivity,
                "mainmenu/logo.png");

        try {
            bbta.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 1));
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            e.printStackTrace();
        }

        bbta.load();
    }

    public void destroyMenuResources() {

    }

    public void createLoadingResources() {

    }

    public void destroyLoadingResources() {

    }

    public void createSettingsResources() {

    }

    public void destroySettingsResources() {

    }

    public void createGameResources() {

    }

    public void destroyGameResources() {

    }

    public void createChatResources() {

    }

    public void destroyChatResources() {

    }

    public static void prepareManager(Engine engine, GeneralsActivity generalsActivity,
                                      Camera camera, BoundCamera boundCamera,
                                      VertexBufferObjectManager vbom) {
        getInstance().engine = engine;
        getInstance().generalsActivity = generalsActivity;
        getInstance().camera = camera;
        getInstance().boundCamera = boundCamera;
        getInstance().vbom = vbom;
    }
}


