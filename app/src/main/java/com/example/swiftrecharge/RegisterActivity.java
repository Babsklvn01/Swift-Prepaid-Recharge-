package com.example.swiftrecharge;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import model.RegistrationImpl;
import model.User;
import presenter.RegistrationPresenter;
import view.RegisterView;

public class RegisterActivity extends AppCompatActivity implements RegisterView {


    private static String REGISTER_URL = "https://ancient-plateau-79488.herokuapp.com/users/";

    Context context;
    private TextInputEditText email, mobile, password, passwordConfirm;
    private ProgressBar progressBar;
    private static final String SHARED_PREF_NAME ="swiftrecharge";
    private  static final String KEY_EMAIL ="keyemail";
    private static final String KEY_PASSWORD ="keypassword";
    private static final String KEY_MOBILE ="keymobile";
    private String emailAddress;
    private String tempMobile;
    private String userPassword;
    private String userPasswordConfirm;

    RegistrationPresenter registrationPresenter;

     ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_account_layout);

        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        passwordConfirm = findViewById(R.id.password_confirm);
        progressBar = findViewById(R.id.progressBar);
        progressDialog = new ProgressDialog(this);

        findViewById(R.id.registerBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailAddress = email.getText().toString();
                tempMobile = mobile.getText().toString();
                userPassword = password.getText().toString();
                userPasswordConfirm = passwordConfirm.getText().toString();

                registrationPresenter.registerUser(emailAddress, userPassword, userPasswordConfirm, tempMobile);
            }
        });
        registrationPresenter = new RegistrationImpl(RegisterActivity.this);
    }


    @Override
    public void registrationSuccess() {
        startActivityForResult(new Intent(this,LoginActivity.class),0);
    }
    @Override
     public void registrationFailed() {
        Toast.makeText(getApplicationContext(), "Sorry, registration failed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void registrationInvalid() {
        Toast.makeText(getApplicationContext(), "Please try again. Invalid information", Toast.LENGTH_SHORT).show();

    }

}

