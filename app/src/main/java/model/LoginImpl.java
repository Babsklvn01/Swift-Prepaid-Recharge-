package model;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import presenter.LoginPresenter;
import view.LoginView;


public class LoginImpl implements LoginPresenter {

    LoginView loginView;

    public LoginImpl(LoginView loginView) {
        this.loginView=loginView;
    }

    @Override
    public void performLogin(String mobile, String password) {
        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(mobile)){
            loginView.loginInvalid();
        }
        else {
            loginView.loginSuccess();
        }


    }

    }

