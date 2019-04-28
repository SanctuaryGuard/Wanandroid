package com.example.asus.wanandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.asus.wanandroid.WanandroidApplication;

public class SharedPreferenceUtil {
    public static boolean putData(String filename, String key, String value) {
        SharedPreferences preferences = WanandroidApplication.getApplication().getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static boolean putData(String filename, String key, int value) {
        SharedPreferences preferences = WanandroidApplication.getApplication().getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static String loadString(String filename, String key) {
        SharedPreferences preferences = WanandroidApplication.getApplication().getSharedPreferences(filename, Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }

    public static int loadInt(String filename, String key) {
        SharedPreferences preferences = WanandroidApplication.getApplication().getSharedPreferences(filename, Context.MODE_PRIVATE);
        return preferences.getInt(key, 0);
    }

    public static boolean removeData(String filename, String key) {
        SharedPreferences preferences = WanandroidApplication.getApplication().getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        return editor.commit();
    }
}
