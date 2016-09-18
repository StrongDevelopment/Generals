package net.strongdev.generals.managers;

import net.strongdev.generals.scenes.AboutPopupScene;
import net.strongdev.generals.scenes.AddPopupScene;
import net.strongdev.generals.scenes.Base;
import net.strongdev.generals.scenes.ChatScene;
import net.strongdev.generals.scenes.GameScene;
import net.strongdev.generals.scenes.LoadingScene;
import net.strongdev.generals.scenes.LoginScene;
import net.strongdev.generals.scenes.MainMenuScene;

import net.strongdev.generals.scenes.Popup;
import net.strongdev.generals.scenes.SettingsScene;
import net.strongdev.generals.scenes.SplashScene;

import org.andengine.engine.Engine;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.IGameInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oleg on 14.09.16.
 */
public class Scenes {

    private Base splashScene, mainMenuScene, loginScene, loadingScene, settingsScene, gameScene, chatScene,
        currentScene;
    private Popup aboutPopup, currentPopup;


    private static final Scenes instance = new Scenes();

    private SceneType currentSceneType = SceneType.SCENE_SPLASH;

    private Engine engine = Resources.getInstance().engine;

    public enum SceneType {
        SCENE_SPLASH, SCENE_MAIN_MENU, SCENE_LOGIN, SCENE_LOADING, SCENE_SETTINGS, SCENE_GAME, SCENE_CHAT;
    }

    public enum PopupType {
        POPUP_ABOUT, POPUP_ADD, POPUP_LOADING;
    }

    public void setScene(Base scene) {
        engine.setScene(scene);
        if (currentScene != null) {
            currentScene.destroyResources();
        }
        currentScene = scene;
        currentSceneType = scene.getSceneType();
    }

    public Base setScene(SceneType sceneType) {
        Base scene = null;
        switch (sceneType) {
            case SCENE_SPLASH: {
                scene = new SplashScene();
                setScene(scene);
                break;
            }
            case SCENE_MAIN_MENU: {
                scene = new MainMenuScene();
                setScene(scene);
                break;
            }
            case SCENE_LOGIN: {
                scene = new LoginScene();
                setScene(scene);
                break;
            }
            case SCENE_SETTINGS: setScene(settingsScene); break;
            case SCENE_GAME: setScene(gameScene); break;
            case SCENE_CHAT: setScene(chatScene); break;
            default: break;
        }
        return scene;
    }

    public void showPopup(Popup popup) {
        currentScene.setChildScene(popup, false, true, true);
        currentPopup = popup;
    }

    public void showPopup(Scenes.PopupType popupType) {
        Popup popup = null;
        switch (popupType) {
            case POPUP_ABOUT: {
                popup = new AboutPopupScene();
                showPopup(popup);
                break;
            }
            case POPUP_ADD: {
                popup = new AddPopupScene();
                showPopup(popup);
                break;
            }
        }
    }

    public void closePopup() {
        currentScene.clearChildScene();
        currentPopup.destroyResources();
        currentPopup = null;
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

}
