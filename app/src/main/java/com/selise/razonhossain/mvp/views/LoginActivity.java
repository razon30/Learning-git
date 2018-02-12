package com.selise.razonhossain.mvp.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.selise.razonhossain.MyApplication;
import com.selise.razonhossain.eventbus.R;
import com.selise.razonhossain.mvp.presenter.ILoginCredentialPresenter;
import com.selise.razonhossain.mvp.presenter.ILoginPresenter;
import com.selise.razonhossain.mvp.presenter.LoginPresenter;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.Module;
import dagger.Provides;

public class LoginActivity extends AppCompatActivity implements ILoginPresenter, Validator.ValidationListener {

    ILoginCredentialPresenter iLoginCredentialPresenter;

    @Inject LoginPresenter loginPresenter;


    @NotEmpty(message = "This field is required")
    @BindView(R.id.firstName) EditText firstName;

    @Password(min = 2, scheme = Password.Scheme.ANY)
    @BindView(R.id.lastName) EditText lastName;

    @OnClick(R.id.btn)
    void onClick(){
        Toast.makeText(this, "Btnclicked", Toast.LENGTH_SHORT).show();
        validator.validate();
    }

    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        MyApplication.getInstance().getComponent().inject(this);
        initView();
    }


    @Override
    public int showError(String errorMessage) {

        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();

        return 0;

    }


    @Override
    public int showMessage(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        return 0;

    }

    private void initView() {

        ButterKnife.bind(this);
        iLoginCredentialPresenter = new LoginPresenter(this);
        validator = new Validator(this);
        validator.setValidationListener(this);

     //   btn.setOnClickListener(this);

    }



    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "onvalidation", Toast.LENGTH_SHORT).show();
        iLoginCredentialPresenter.userCredentials(firstName.getText().toString(), lastName.getText().toString());
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
