package com.example.javaallegroapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProductInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
    }

    public void GetProducts()
    {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.allegro.pl.allegrosandbox.pl/offers/listing?category.id=" + MainToken.categoryId + "&phrase=" + MainToken.searchingName)
                .method("GET", null)
                .addHeader("Accept", "application/vnd.allegro.public.v1+json")
                .addHeader("Authorization", "Bearer " + MainToken.token.access_token)
                .build();

        try
        {
            Response response = client.newCall(request).execute();
            String bodyStr = response.body().string();

            Gson gson = new Gson();
            //Category category = gson.fromJson(bodyStr, Category.class);
            //return category;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            //Category category = new Category();
           // return category;
        }
    }
}
