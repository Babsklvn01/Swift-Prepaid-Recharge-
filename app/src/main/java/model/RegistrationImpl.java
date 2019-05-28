package model;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Patterns;

import presenter.RegistrationPresenter;
import view.RegisterView;

public class RegistrationImpl implements RegistrationPresenter {

    RegisterView registerView;

    public RegistrationImpl(RegisterView registerView) {
        this.registerView = registerView;
    }

    @Override
    public void registerUser(String email, String password,String passwordConfirm, String mobile) {

        if (TextUtils.isEmpty(email)||TextUtils.isEmpty(mobile)||TextUtils.isEmpty(passwordConfirm) || TextUtils.isEmpty(password)){
            registerView.registrationInvalid();
        }
        else if(Patterns.PHONE.matcher(mobile).matches() && password.equals(passwordConfirm) && Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            registerView.registrationSuccess();
        }

        else {
            registerView.registrationFailed();
        }

    }

}
