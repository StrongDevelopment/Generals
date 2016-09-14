package net.strongdev.generals.scenes;

import net.strongdev.generals.managers.Scenes;

/**
 * Created by oleg on 14.09.16.
 */
public class MenuScene extends Base {
    @Override
    public void createScene() {

    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public Scenes.SceneType getSceneType() {
        return Scenes.SceneType.SCENE_MENU;
    }

    @Override
    public void disposeScene() {
        this.detachSelf();
        this.dispose();
    }
}
