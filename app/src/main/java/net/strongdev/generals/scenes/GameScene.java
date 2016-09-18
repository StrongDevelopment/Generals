package net.strongdev.generals.scenes;

import net.strongdev.generals.managers.Resources;
import net.strongdev.generals.managers.Scenes;

/**
 * Created by oleg on 14.09.16.
 */
public class GameScene extends Base {
    @Override
    public void createScene() {

    }

    @Override
    public void onBackKeyPressed() {
        Scenes.getInstance().setScene(Scenes.SceneType.SCENE_MAIN_MENU);
    }

    @Override
    public Scenes.SceneType getSceneType() {
        return Scenes.SceneType.SCENE_GAME;
    }

    @Override
    public void disposeScene() {
        this.detachSelf();
        this.dispose();
    }

    @Override
    public void createResources() {

    }

    @Override
    public void destroyResources() {

    }
}
