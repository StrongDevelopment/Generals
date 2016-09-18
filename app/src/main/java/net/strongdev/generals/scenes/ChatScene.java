package net.strongdev.generals.scenes;

import net.strongdev.generals.managers.Scenes;

/**
 * Created by oleg on 14.09.16.
 */
public class ChatScene extends Base {
    @Override
    public void createScene() {

    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public Scenes.SceneType getSceneType() {
        return Scenes.SceneType.SCENE_CHAT;
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
