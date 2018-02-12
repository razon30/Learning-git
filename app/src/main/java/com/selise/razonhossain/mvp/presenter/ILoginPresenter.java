package com.selise.razonhossain.mvp.presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by razon.hossain on 2/7/2018.
 */

public interface ILoginPresenter {

    public int showError(String errorMessage);

    public int showMessage(String message);

}
