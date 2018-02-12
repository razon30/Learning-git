package com.selise.razonhossain.mvp.presenter;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by razon.hossain on 2/7/2018.
 */

@Module
public class LoginPresenter implements ILoginCredentialPresenter {


    String message;


   private ILoginPresenter iLoginPresenter;



   @Inject
   public LoginPresenter(ILoginPresenter iLoginPresenter){
       this.iLoginPresenter = iLoginPresenter;
   }


    public int userCredentials(String name, String pass) {

       if (name.isEmpty()){
           iLoginPresenter.showError("Name is empty.");
       }else if (pass.isEmpty()){
           iLoginPresenter.showError("Pass is empty.");
       }else  {

           iLoginPresenter.showMessage("Successful operation.");

        }

        return 0;

    }

}
