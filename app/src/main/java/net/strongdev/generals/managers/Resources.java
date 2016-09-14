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
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
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

    public BitmapTexture bitmapTexture;

    public ITextureRegion textureRegion;

    public TiledTextureRegion tiledTextureRegion;

    public Font font;

    public Sound sound;

    public Music music;

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

    }

    public void destroySplashResources() {

    }

    public void createMenuResources() {

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


