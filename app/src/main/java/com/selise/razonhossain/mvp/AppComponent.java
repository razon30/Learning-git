package com.selise.razonhossain.mvp;

import com.selise.razonhossain.mvp.model.User;
import com.selise.razonhossain.mvp.presenter.LoginPresenter;
import com.selise.razonhossain.mvp.views.LoginActivity;

import dagger.Component;

/**
 * Created by razon.hossain on 2/7/2018.
 */

//@Component(modules = {LoginActivity.class, LoginPresenter.class, User.class})
public interface AppComponent {

    void inject(LoginActivity loginActivity);
    void inject(LoginPresenter loginPresenter);

}
