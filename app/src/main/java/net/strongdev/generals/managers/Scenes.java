package net.strongdev.generals.managers;

import net.strongdev.generals.scenes.Base;
import net.strongdev.generals.scenes.MenuScene;
import net.strongdev.generals.scenes.SplashScene;

import org.andengine.engine.Engine;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.IGameInterface;

/**
 * Created by oleg on 14.09.16.
 */
public class Scenes {
    private Base splashScene, menuScene, loadingScene, settingsScene, gameScene, chatScene,
        currentScene;

    private static final Scenes instance = new Scenes();

    private SceneType currentSceneType = SceneType.SCENE_SPLASH;

    private Engine engine = Resources.getInstance().engine;


    public enum SceneType {
        SCENE_SPLASH, SCENE_MENU, SCENE_LOADING, SCENE_SETTINGS, SCENE_GAME, SCENE_CHAT;
    }

    public void setScene(Base scene) {
        engine.setScene(scene);
        currentScene = scene;
        currentSceneType = scene.getSceneType();
    }

    public static Scenes getInstance() {
        return instance;
    }

    public SceneType getCurrentSceneType() {
        return currentSceneType;
    }

    public Base getCurrentScene() {
        return currentScene;
    }

    public void setScene(SceneType sceneType) {
        switch (sceneType) {
            case SCENE_SPLASH: setScene(splashScene); break;
            case SCENE_MENU: setScene(menuScene); break;
            case SCENE_LOADING: setScene(loadingScene); break;
            case SCENE_SETTINGS: setScene(settingsScene); break;
            case SCENE_GAME: setScene(gameScene); break;
            case SCENE_CHAT: setScene(chatScene); break;
            default: break;
        }
    }

    public void createSplashScene(IGameInterface.OnCreateSceneCallback onCreateSceneCallback) {
        Resources.getInstance().createSplashResources();
        splashScene = new SplashScene();
        currentScene = splashScene;
        onCreateSceneCallback.onCreateSceneFinished(splashScene);
    }

    public void createMenuScene() {
        if (splashScene != null) {
            Resources.getInstance().destroySplashResources();
        }
        if (loadingScene != null) {
            Resources.getInstance().destroyLoadingResources();
        }
        if (settingsScene != null) {
            Resources.getInstance().destroySettingsResources();
        }
        if (gameScene != null) {
            Resources.getInstance().destroyGameResources();
        }
        if (chatScene != null) {
            Resources.getInstance().destroyChatResources();
        }
        Resources.getInstance().createMenuResources();
        menuScene = new MenuScene();
        setScene(menuScene);
    }

    public void createLoadingScene() {

    }

    public void createSettingsScene() {

    }


    public void createGameScene() {

    }

    public void createChatScene() {

    }



}
