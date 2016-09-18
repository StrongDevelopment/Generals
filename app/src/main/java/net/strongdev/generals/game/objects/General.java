package net.strongdev.generals.game.objects;

/**
 * Created by oleg on 18.09.16.
 */
public class General extends GameObject {

    private String pass;
    private int level;

    public General(int id, String name, String pass, int level) {
        super(id, name);
        this.pass = pass;
        this.level = level;
    }

    public String getPass() {
        return this.pass;
    }

    public int getLevel() {
        return this.level;
    }


}
