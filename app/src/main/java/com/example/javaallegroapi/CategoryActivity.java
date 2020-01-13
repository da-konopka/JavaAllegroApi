package com.example.javaallegroapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import com.google.gson.Gson;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CategoryActivity extends AppCompatActivity {

    String pom;

    private Button buttonAccept;

    SearchView mySearchView;
    ListView myList;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Category category;
    String listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        buttonAccept = (Button) findViewById(R.id.buttonAccept);
        buttonAccept.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                MainToken.categoryId = pom;
                MainToken.categoryName = listItem;
                OpenMainActivity();
            }
        });
        category = getCategories();
        mySearchView = (SearchView) findViewById(R.id.searchView);
        myList = (ListView) findViewById(R.id.myList);
        list = new ArrayList<String>();

        for (Category.CategoriesBean item: category.getCategories())
        {
            list.add(item.name);
        }

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listItem = list.get(position);

                for (Category.CategoriesBean item: category.getCategories())
                {
                    if(listItem == item.name)
                    {
                        pom = item.id;
                    }
                }

                list.clear();

                category = new Category();
                category = getCategoryChildren(pom);

                for (Category.CategoriesBean item: category.getCategories())
                {
                    list.add(item.name);
                }

                if(list.isEmpty())
                {
                    MainToken.categoryId = pom;
                    MainToken.categoryName = listItem;
                    OpenMainActivity();
                }

                myList.setAdapter(adapter);
            }
        });

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

    public Category getCategoryChildren(String id)
    {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.allegro.pl.allegrosandbox.pl/sale/categories/?parent.id="+id)
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

    public void OpenMainActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
