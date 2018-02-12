package com.selise.razonhossain.mvp.views;

import com.selise.razonhossain.mvp.presenter.ILoginCredentialPresenter;
import com.selise.razonhossain.mvp.presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by razon.hossain on 2/8/2018.
 */

@Module
public class LoginActivityPresenterModule {

    ILoginCredentialPresenter iLoginCredentialPresenter;

    @Provides
    ILoginCredentialPresenter provideIloginCredentialPresenter(){
        return iLoginCredentialPresenter;
    }


}
