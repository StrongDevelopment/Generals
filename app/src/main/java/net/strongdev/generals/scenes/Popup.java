package net.strongdev.generals.scenes;

import net.strongdev.generals.GeneralsActivity;
import net.strongdev.generals.managers.Resources;
import net.strongdev.generals.managers.Scenes;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.CameraScene;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by oleg on 16.09.16.
 */
public abstract class Popup extends Scene {

    protected Engine engine;
    protected GeneralsActivity generalsActivity;
    protected Camera camera;
    protected BoundCamera boundCamera;
    protected Resources resources;
    protected VertexBufferObjectManager vbom;
    protected Scene parentScene;

    public Popup() {

        this.resources = Resources.getInstance();
        this.engine = resources.engine;
        this.camera = resources.camera;
        this.boundCamera = resources.boundCamera;
        this.vbom = resources.vbom;
        this.generalsActivity = resources.generalsActivity;
        //this.parentScene = scene;
        createResources();
        createPopup();
    }

    public abstract void createPopup();
    public abstract void onBackKeyPressed();
    public abstract Scenes.PopupType getPopupType();
    public abstract void disposeScene();
    public abstract void createResources();
    public abstract void destroyResources();

}
