package net.strongdev.generals.managers;

import net.strongdev.generals.GeneralsActivity;
import net.strongdev.generals.game.objects.General;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import java.util.Map;

/**
 * Created by oleg on 14.09.16.
 */
public class Resources {

    private static final Resources instance = new Resources();

    public Map<String, General> generals;

    public Engine engine;
    public GeneralsActivity generalsActivity;
    public Camera camera;
    public BoundCamera boundCamera;
    public VertexBufferObjectManager vbom;


    public Music mainMusic;
    //end MainMenu

    public TiledTextureRegion tiledTextureRegion;

    public Font fontMicradi;
    public Font fontJura;
    ITexture fontJuraTexture;

    public Sound sound;

    public Music music;

    public BitmapTextureAtlas controlAtlas;

    public ITextureRegion joyBase, joy;

    public static Resources getInstance() {
        return instance;
    }

    public void resourcesPathsInitialize() {
        //Установка путей к ресурсам для фабрик графики, шрифтов, звуков
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("graphics/");
        FontFactory.setAssetBasePath("fonts/");
        SoundFactory.setAssetBasePath("sound/");
        MusicFactory.setAssetBasePath("music/");
    }


    public static void prepareManager(Engine engine, GeneralsActivity generalsActivity,
                                      Camera camera, BoundCamera boundCamera,
                                      VertexBufferObjectManager vbom) {
        getInstance().engine = engine;
        getInstance().generalsActivity = generalsActivity;
        getInstance().camera = camera;
        getInstance().boundCamera = boundCamera;
        getInstance().vbom = vbom;
        Storage.getInstance().loadGenerals();
    }


}


