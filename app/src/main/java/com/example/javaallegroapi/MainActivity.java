package com.example.javaallegroapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    private EditText searchingText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchingText = (EditText) findViewById(R.id.productName);
        buttonSearch = (Button) findViewById(R.id.searchButton);
        buttonSearch.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(searchingText.getText() != null)
                {
                    MainToken.searchingName = searchingText.getText().toString();
                }
                if(MainToken.categoryId != null && MainToken.searchingName != null)
                {
                    OpenProductInfoActivity();
                }

            }
        });

        buttonCategory = (Button) findViewById(R.id.CategoryButton);
        buttonCategory.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(searchingText.getText() != null)
                {
                    MainToken.searchingName = searchingText.getText().toString();
                }
                OpenCategoryActivity();
            }
        });
        GetToken();
        GetCategory();
    }


    public void OpenProductInfoActivity()
    {
        Intent intent = new Intent(this, ProductInfoActivity.class);
        startActivity(intent);
    }

    public void OpenCategoryActivity()
    {
        Intent intent = new Intent(this, CategoryActivity.class);
        //intent.putExtra("token", token1);
        startActivity(intent);
    }

    public void GetToken()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String clientId = "cb957f2dd62349a2896b45e8dfb39072";
        String secureId = "yEZBDuKixZQuQ7Ge5n5Ydz1B3kZIbR81ad9r5qDzgj7HU1qdfCtxjoHIkq0aVqPe";
        String toEncode = clientId + ":" + secureId;
        String encodedBase64 = Base64.getEncoder().encodeToString(toEncode.getBytes());

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
            Gson gson = new Gson();
            Token token = gson.fromJson(bodyStr, Token.class);
            String accessToken = token.access_token;
            MainToken.token = token;
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void GetCategory()
    {
        if(MainToken.categoryName != null)
        {
            buttonCategory.setText(MainToken.categoryName);
        }
    }
}
