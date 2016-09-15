package net.strongdev.generals.scenes;

import net.strongdev.generals.managers.Resources;
import net.strongdev.generals.managers.Scenes;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.color.Color;
import org.andengine.util.modifier.IModifier;

/**
 * Created by oleg on 14.09.16.
 */
public class SplashScene extends Base {
    @Override
    public void createScene() {
        /*final Rectangle redRect = new Rectangle(0, 0, 1280, 720, Resources.getInstance().vbom);
        redRect.setColor(Color.RED);
        attachChild(redRect);*/

        Sprite splashScreenSprite = new Sprite(0, 0, Resources.getInstance().splashScreenRegion,
                Resources.getInstance().vbom);

        SpriteBackground splashBackground = new SpriteBackground(0,0,0,splashScreenSprite);

        setBackground(splashBackground);
        setBackgroundEnabled(true);

    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public Scenes.SceneType getSceneType() {
        return Scenes.SceneType.SCENE_SPLASH;
    }

    @Override
    public void disposeScene() {
        this.detachSelf();
        this.dispose();
    }
}
