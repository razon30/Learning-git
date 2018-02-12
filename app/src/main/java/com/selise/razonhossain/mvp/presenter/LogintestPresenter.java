package com.selise.razonhossain.mvp.presenter;

import android.widget.Toast;

import com.selise.razonhossain.MyApplication;

/**
 * Created by razon.hossain on 2/7/2018.
 */

public class LogintestPresenter implements ILoginCredentialPresenter {


    String message;
   private ILoginPresenter iLoginPresenter;

   public LogintestPresenter(ILoginPresenter iLoginPresenter){
       this.iLoginPresenter = iLoginPresenter;
   }


    @Override
    public int userCredentials(String name, String pass) {

       if (name.isEmpty()){
           iLoginPresenter.showError("Name is empty.");
           Toast.makeText(MyApplication.getInstance(), "Dekhi ki hoy", Toast.LENGTH_SHORT).show();
       }else if (pass.isEmpty()){
           iLoginPresenter.showError("Pass is empty.");
       }else  {

           iLoginPresenter.showMessage("Successful operation.");

        }

        return 0;

    }

}
