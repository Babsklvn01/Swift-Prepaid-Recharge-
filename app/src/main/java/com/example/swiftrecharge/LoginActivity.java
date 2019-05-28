package com.example.swiftrecharge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import model.LoginImpl;
import presenter.LoginPresenter;
import view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private static final String LOGIN_URL ="https://ancient-plateau-79488.herokuapp.com/users/sign_in";

    private SharedPreferences sharedPreferences;

    private TextInputEditText email,password;

    private String userEmail,userPassword;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        email=findViewById(R.id.textEmail);
        password=findViewById(R.id.textPassword);
        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEmail = email.getText().toString();
                userPassword =password.getText().toString();
                loginPresenter.performLogin(userEmail,userPassword);
            }
        });
        loginPresenter =new LoginImpl(LoginActivity.this);
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    public void loginFailed() {
        Toast.makeText(getApplicationContext(), "Sorry, login failed. Try again", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginInvalid() {
        Toast.makeText(getApplicationContext(), "Sorry invalid login, try again", Toast.LENGTH_SHORT).show();

    }
}
