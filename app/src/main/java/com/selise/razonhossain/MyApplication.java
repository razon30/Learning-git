package com.selise.razonhossain;

import android.app.Application;
import com.orm.SugarContext;
import com.selise.razonhossain.mvp.AppComponent;
//import com.selise.razonhossain.mvp.DaggerAppComponent;


/**
 * Created by razon.hossain on 2/7/2018.
 */

public class MyApplication extends Application {

    AppComponent appComponent;
    static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
        sInstance = this;
       // appComponent = DaggerAppComponent.builder().build();

        //hello branch

    }

    public AppComponent getComponent(){
        return appComponent;
    }

    public static MyApplication getInstance(){
        return sInstance;
    }


}
