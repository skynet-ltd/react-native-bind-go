package com.testgo;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import greeting.Greeting;

/**
 * Created by phuonglam on 11/8/17.
 */

public class GreetingModule extends ReactContextBaseJavaModule {
    public GreetingModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "Greeting";
    }

    @ReactMethod
    public void english(String name, Callback callback) {
        if (callback != null) {
            callback.invoke(Greeting.english(name));
        }
    }

    @ReactMethod
    public void stock(Callback callback) {
        if (callback != null) {
            callback.invoke(Greeting.stock());
        }
    }
}