package com.example.user.game;

/**
 * Created by wanninayake on 3/21/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;



public class SaveGame {

    static SharedPreferences getSharedPreferences(Context ctx){
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }


    static void saveStat(Context context,String key,String value){
        SharedPreferences.Editor editor=getSharedPreferences(context).edit();
        editor.putString(key,value);
        editor.apply();
//        editor.commit();
    }


    static String getStat(Context context,String key){
        return getSharedPreferences(context).getString(key,"");
    }





}
