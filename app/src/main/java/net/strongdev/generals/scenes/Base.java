package net.strongdev.generals.scenes;

import net.strongdev.generals.GeneralsActivity;
import net.strongdev.generals.managers.Resources;
import net.strongdev.generals.managers.Scenes;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by oleg on 14.09.16.
 */
public abstract class Base extends Scene {

    protected Engine engine;
    protected GeneralsActivity generalsActivity;
    protected Camera camera;
    protected BoundCamera boundCamera;
    protected Resources resources;
    protected VertexBufferObjectManager vbom;

    public Base() {
        this.resources = Resources.getInstance();
        this.engine = resources.engine;
        this.camera = resources.camera;
        this.boundCamera = resources.boundCamera;
        this.vbom = resources.vbom;
        createScene();

    }

    public abstract void createScene();
    public abstract void onBackKeyPressed();
    public abstract Scenes.SceneType getSceneType();
    public abstract void disposeScene();


}
