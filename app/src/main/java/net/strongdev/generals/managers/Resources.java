package net.strongdev.generals.managers;

import net.strongdev.generals.GeneralsActivity;

import org.andengine.audio.music.Music;
import org.andengine.audio.sound.Sound;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
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

    public void resourcesPathsInitialize() {

    }
}


