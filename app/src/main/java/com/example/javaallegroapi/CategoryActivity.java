package com.example.javaallegroapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CategoryActivity extends AppCompatActivity {

    String token;
    SearchView mySearchView;
    ListView myList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        //token = getIntent().getExtras().getString("token");
        category = getCategories();

        mySearchView = (SearchView) findViewById(R.id.searchView);
        myList = (ListView) findViewById(R.id.myList);

        list = new ArrayList<String>();

        for (Category.CategoriesBean item: category.getCategories())
        {
            list.add(item.name);
        }

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }
        });
    }

    public Category getCategories()
    {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.allegro.pl.allegrosandbox.pl/sale/categories")
                .method("GET", null)
                .addHeader("Accept", "application/vnd.allegro.public.v1+json")
                .addHeader("Authorization", "Bearer " + MainToken.token.access_token)
                .build();
        try
        {
            Response response = client.newCall(request).execute();
            String bodyStr = response.body().string();

            Gson gson = new Gson();
            Category category = gson.fromJson(bodyStr, Category.class);
            return category;
        }
        catch (Exception e)
        {
            System.out.println(e.toString()); 
            Category category = new Category();
            return category;
        }

    }

}
