package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitexample.api.ApiService;
import com.example.retrofitexample.model.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private TextView price;
    private TextView category;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        category = findViewById(R.id.category);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    public void callApi() {
        ApiService.apiService.getProduct(2).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Toast.makeText(MainActivity.this, "Call api success", Toast.LENGTH_SHORT).show();

                Product product = response.body();
                title.setText(product.getTitle());
                price.setText(String.valueOf(product.getPrice()));
                category.setText(product.getCategory());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}