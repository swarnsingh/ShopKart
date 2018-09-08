package com.arya.cart;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author Swarn Singh.
 */
public class ShoppingApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
