package com.example.javaallegroapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Base64;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MainActivity extends AppCompatActivity
{

    private Button buttonSearch;
    private Button buttonCategory;
    String token1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSearch = (Button) findViewById(R.id.searchButton);
        buttonSearch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OpenProductInfoActivity();
            }
        });

        buttonCategory = (Button) findViewById(R.id.CategoryButton);
        buttonCategory.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                OpenCategoryActivity();
            }
        });

        token1 = GetToken();
    }


    public void OpenProductInfoActivity()
    {
        Intent intent = new Intent(this, ProductInfoActivity.class);
        startActivity(intent);
    }

    public void OpenCategoryActivity()
    {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("token", token1);
        startActivity(intent);
    }

    public String GetToken()
    {
        //sluzy, do synchronicznego odpytania api, inaczej jest blad
        //domyslnie api w androidzie jest odpytywane asynchronicznie i tak powinnno byc, bo wtedy UI nie bedzie blokowany dla usera
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String clientId = "cb957f2dd62349a2896b45e8dfb39072";
        String secureId = "yEZBDuKixZQuQ7Ge5n5Ydz1B3kZIbR81ad9r5qDzgj7HU1qdfCtxjoHIkq0aVqPe";
        String toEncode = clientId + ":" + secureId;
        String encodedBase64 = Base64.getEncoder().encodeToString(toEncode.getBytes());

        //zewnetrzna bibloteka do odpytywania api
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://allegro.pl.allegrosandbox.pl/auth/oauth/token?grant_type=client_credentials")
                .method("POST", body)
                .addHeader("Authorization", "Basic " + encodedBase64)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String bodyStr = response.body().string();

            //1 opcja
            //JSONObject json = new JSONObject(bodyStr);
            ////json.getString("access_token");

            //2 opcja lepsza
            //biblioteka do serializowania jsona na obiekt
            Gson gson = new Gson();
            Token token = gson.fromJson(bodyStr, Token.class);
            return token.access_token;

        }
        catch (Exception e) {
            System.out.println(e.toString());
            return "";
            // Do something here
        }
    }
}
