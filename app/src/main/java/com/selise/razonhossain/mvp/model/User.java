package com.selise.razonhossain.mvp.model;

import javax.inject.Singleton;

import dagger.Module;

/**
 * Created by razon.hossain on 2/7/2018.
 */

@Singleton
@Module
public class User {

    String name;
    String pass;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
