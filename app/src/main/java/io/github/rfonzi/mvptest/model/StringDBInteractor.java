package io.github.rfonzi.mvptest.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by ryan on 11/28/16.
 */

public class StringDBInteractor {
    ArrayList<StringDB> strings;

    public StringDBInteractor(){
        strings = new ArrayList<>();
    }

    public void addString(String string){
        StringDB stringdb = new StringDB();
        stringdb.id = strings.size();
        stringdb.string = string;
        strings.add(stringdb);
    }

    public String getString(int id){
        return strings.get(id).string;
    }

    public int getNumStrings(){
        return strings.size();
    }
}
