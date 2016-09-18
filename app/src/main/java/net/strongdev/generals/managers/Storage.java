package net.strongdev.generals.managers;

import android.content.Context;
import android.content.SharedPreferences;

import net.strongdev.generals.game.objects.General;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by oleg on 14.09.16.
 */
public class Storage {

    private static final Storage instance = new Storage();

    public static final String storageName = "Generals";

    private static final String GENERALS_KEY = "generals";
    private static final String PASS_KEY = "pass";



    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;




    public Storage() {
        settings = Resources.getInstance().generalsActivity.getPreferences(Context.MODE_PRIVATE);
        editor = settings.edit();
    }

    public static Storage getInstance() {
        return instance;
    }

    public static void loadGenerals() {
        //Получение списка логинов и паролей в формате Имя|Пароль|Уровень
        /*Set<String> generals = settings.getStringSet(GENERALS_KEY, new HashSet<String>());
        //Получение итератора для обхода списка
        Iterator<String> iterator = generals.iterator();
        //Создание списка ключ - имя, значение объект класса General
        Resources.getInstance().generals = new HashMap<String, General>();
        while(iterator.hasNext()) {
            //Получение строки из списка  в формате Имя|Пароль|Уровень
            String generalString = iterator.next();
            //Расщепление строки на куски по разделителю |
            StringTokenizer stringTokenizer = new StringTokenizer(generalString, "|");
            //Имя
            String generalName = stringTokenizer.nextToken();
            //Пароль
            String generalPass = stringTokenizer.nextToken();
            //Уровень
            int generalLevel = Integer.getInteger(stringTokenizer.nextToken());

            General general = new General(0, generalName, generalPass, generalLevel);
            Resources.getInstance().generals.put(generalName, general);
        }*/
    }

    public static void saveGenerals() {
        //Получение итератора для обхода списка гернералов для сохранения
        Iterator<Map.Entry<String, General>> iterator = Resources.getInstance().generals.entrySet().iterator();
        //Создание списка генералов в формате Имя|Пароль|Уровень
        Set<String> generals = new HashSet<String>();
        while(iterator.hasNext()) {
            Map.Entry<String, General> entry = iterator.next();
            String generalName = entry.getKey();
            General general = entry.getValue();
            String generalString = generalName + "|" + general.getPass() + "|" + general.getLevel();
            generals.add(generalString);
        }
        //Сохранение списка генералов
        editor.putStringSet(GENERALS_KEY, generals);
    }

    public static void addGeneral(String login, String pass) {
        Set<String> logins = settings.getStringSet("login", new HashSet<String>());
    }

    //public static void removeGeneral(String)


    public static void add(String key, int value) {

        editor.putInt(key, value);
        editor.commit();

    }

    public static int get(String key) {

        return settings.getInt(key, 0);
    }
}
