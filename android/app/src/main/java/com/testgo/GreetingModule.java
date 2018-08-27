package com.testgo;

import java.nio.channels.WritableByteChannel;
import java.util.HashMap;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

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
    @ReactMethod
    public void testFail(Boolean flag,Callback success,Callback error) throws Exception {
        try {
            greeting.Person result = Greeting.mustFail(flag);
            WritableMap obj = Arguments.createMap();
            obj.putString("name", result.getName());
            obj.putDouble("age", result.getAge());
            success.invoke(obj);
        } catch (Exception e) {
            error.invoke(e.getMessage());
        }
    }
}