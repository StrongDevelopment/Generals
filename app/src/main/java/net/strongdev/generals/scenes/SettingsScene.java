package net.strongdev.generals.scenes;

import net.strongdev.generals.managers.Resources;
import net.strongdev.generals.managers.Scenes;

/**
 * Created by oleg on 14.09.16.
 */
public class SettingsScene extends Base {
    @Override
    public void createScene() {

    }

    @Override
    public void onBackKeyPressed() {
        Scenes.getInstance().createMenuScene();
    }

    @Override
    public Scenes.SceneType getSceneType() {
        return Scenes.SceneType.SCENE_SETTINGS;
    }

    @Override
    public void disposeScene() {
        this.detachSelf();
        this.dispose();
    }
}
