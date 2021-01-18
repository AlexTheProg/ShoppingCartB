package com.example.shoppingcartbun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<ProductModel> {
    private final LayoutInflater mInflater;
    private final ArrayList<ProductModel> products;
    private final int mViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<ProductModel> products){
        super(context, textViewResourceId, products);
        this.products = products;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parents){
        convertView = mInflater.inflate(mViewResourceId, null);

        ProductModel product = products.get(position);

        if(product != null){
            TextView nume_produs = (TextView) convertView.findViewById(R.id.nume_produs);
            TextView categorie_produs = (TextView) convertView.findViewById(R.id.categorie_produs);
            TextView cantitate_produs = (TextView) convertView.findViewById(R.id.cantitate_produs);

            if(nume_produs != null){
                nume_produs.setText(product.getNume_produs());
            }

            if(categorie_produs != null){
                categorie_produs.setText(product.getCategorie_produs());
            }

            if(cantitate_produs != null){
                cantitate_produs.setText(product.getCantitate_produs());
            }
        }
        return convertView;
    }

}
