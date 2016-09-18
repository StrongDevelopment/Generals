package net.strongdev.generals.game.objects;

import org.andengine.entity.sprite.TiledSprite;

/**
 * Created by oleg on 18.09.16.
 */
public class GameObject {

    private int id;
    private String name;
    private int position;
    private TiledSprite sprite;


    public GameObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setPosition(int position) {
        this.position = position;
    }


}
