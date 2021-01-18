package com.example.shoppingcartbun;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class AllProducts extends AppCompatActivity {
    DatabaseHelper myDB;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);

        myDB = new DatabaseHelper(AllProducts.this);
        ArrayList<ProductModel> allProducts = myDB.getProducts();
        System.out.println(allProducts);

        lista = findViewById(R.id.listaMea);

        ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(AllProducts.this, R.layout.list_view_adapter, allProducts);
        lista.setAdapter(adapter);
    }
}