package com.example.javaallegroapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProductInfoActivity extends AppCompatActivity {

    Product product;

    private TextView TVmaxPrice;
    private TextView TVminPrice;
    private TextView TVaveragePrice;
    private TextView TVcount;
    private TextView TVinfo1;
    private TextView TVinfo2;

    int count;
    Double maxPrice;
    Double minPrice;
    Double averagePrice;
    Double sum;
    Double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        TVmaxPrice = (TextView) findViewById(R.id.textViewMostPrice);
        TVminPrice = (TextView) findViewById(R.id.textViewLessPrice);
        TVaveragePrice = (TextView) findViewById(R.id.textViewAverage);
        TVcount = (TextView) findViewById(R.id.textViewCount);
        TVinfo1 = (TextView) findViewById(R.id.textViewinfo1);
        TVinfo2 = (TextView) findViewById(R.id.textViewinfo2);

        product = GetProducts();

        count = 0;
        maxPrice = 0d;
        minPrice = 0d;
        averagePrice = 0d;
        sum = 0d;
        price = 0d;

        for (Product.ItemsBean.RegularBean item: product.items.regular)
        {
            price = Double.valueOf(item.sellingMode.price.amount);
            if(count == 0)
            {
                maxPrice = price;
                minPrice = price;
            }
            if(price > maxPrice)
            {
                maxPrice = price;
            }
            if(price < minPrice)
            {
                minPrice = price;
            }
            count++;
            sum += price;
        }
        averagePrice = sum/count;
        averagePrice = Math.floor(averagePrice * 100) / 100;

        TVmaxPrice.setText(maxPrice.toString());
        TVminPrice.setText(minPrice.toString());
        TVaveragePrice.setText(averagePrice.toString());
        TVcount.setText(String.valueOf(count));
        TVinfo1.setText("Wyszukujesz: " + MainToken.searchingName);
        TVinfo2.setText("Kategoria: " + MainToken.categoryName);
    }

    public Product GetProducts()
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
            Product product = gson.fromJson(bodyStr, Product.class);
            return product;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            Product product = new Product();
            return product;
        }
    }
}
