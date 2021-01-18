package com.example.shoppingcartbun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class DatabaseHelper extends DatabaseOpenHelper {
    public static final String DATABASE_NAME = "produse.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "produs";
    public static final String COL1 = "ID";
    public static final String COL2 = "NUME_PRODUS";
    public static final String COL3 = "CATEGORIE_PRODUS";
    public static final String COL4 = "CANTITATE_PRODUS";
    public static final String COL5 = "COD_PRODUS";


    public DatabaseHelper(@Nullable Context context) {
        super(context);
    }

    /*@Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NUME_PRODUS TEXT, CATEGORIE_PRODUS TEXT, CANTITATE_PRODUS INTEGER, COD_PRODUS INTEGER)";
        db.execSQL(createTable);
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean addData(String nume_produs, String categorie_produs, int cantitate_produs, int cod_produs){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, nume_produs);
        contentValues.put(COL3, categorie_produs);
        contentValues.put(COL4, cantitate_produs);
        contentValues.put(COL5, cod_produs);

        long result = db.insert(TABLE_NAME, null, contentValues);

        return result != -1;
    }

    /*public void insertIntoDatabase(String nume_produs, String categorie_produs, int cantitate_produs, int cod_produs) {
        String insertQuery = "INSERT INTO " + TABLE_NAME + "(NUME_PRODUS, CATEGORIE_PRODUS, CANTITATE_PRODUS, COD_PRODUS) VALUES (?. ?. ?. ?)";

        try (Connection conn = this.connect(); PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, nume_produs);
            preparedStatement.setString(2, categorie_produs);
            preparedStatement.setInt(3, cantitate_produs);
            preparedStatement.setInt(4, cod_produs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/



    /*public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\alexa\\Desktop\\ShoppingDB\\produse.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }*/

    /*public Cursor getListContents(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null );
    }*/

    public ArrayList<ProductModel> getProducts(){
        ArrayList<ProductModel> returnList = new ArrayList<>();

        String queryAll = "SELECT * FROM produs";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryAll, null);


        if(cursor.moveToFirst()){
            //loop through cursor and create a new object and put it in the list
            do{
               /* System.out.println("Am ajuns la un item din resultSet acum il pun in lista");*/
                int productID = cursor.getInt(0);
                String product_name = cursor.getString(1);
                String categorie_produs = cursor.getString(2);
                String cantitate_produs = cursor.getString(3);
                String cod_produs = cursor.getString(4);
                ProductModel product = new ProductModel(productID, product_name, categorie_produs, cantitate_produs, cod_produs);
                returnList.add(product);
            }while(cursor.moveToNext());
            System.out.println(returnList);
        }else{
            //lista e goala
            System.out.println("Lista e goala");
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
