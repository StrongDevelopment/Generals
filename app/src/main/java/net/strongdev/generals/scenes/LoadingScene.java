package net.strongdev.generals.scenes;

import net.strongdev.generals.managers.Scenes;

/**
 * Created by oleg on 14.09.16.
 */
public class LoadingScene extends Popup {
    @Override
    public void createPopup() {

    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public Scenes.PopupType getPopupType() {
        return Scenes.PopupType.POPUP_LOADING;
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
