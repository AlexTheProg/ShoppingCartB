package com.example.shoppingcartbun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    ArrayList<ProductModel> productList;
    ListView listView;
    Button viewAllBtn;
    ProductModel productModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.productList);
        viewAllBtn = findViewById(R.id.searchAllButton);



        viewAllBtn.setOnClickListener(v -> {
         Intent viewAll = new Intent(MainActivity.this, AllProducts.class);
         startActivity(viewAll);
        });



    }
}