package model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import presenter.UrlJsonAsyncTask;

public class RegisterTask extends UrlJsonAsyncTask {

    public RegisterTask(Context context) {
        super(context);
    }

    @Override
    protected JSONObject doInBackground(String... urls) {


        return super.doInBackground(urls);
    }

    @Override
    protected void onPostExecute(JSONObject json) {
        super.onPostExecute(json);
    }
}
