package com.example.categorydetailexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        try {
            // This gets the particular Detailed object we are displaying
            // In this case, it is a Food object.
            Food myFood = intent.getParcelableExtra("Array Values");
            /** / This page will display the specific Detailed data for what your app is showing.
            // Get references to the xml views for name, price, desc, and photo
            // set values on the screen based on the object that was passed to this Detail activity **/



            TextView nameTV = findViewById(R.id.name);
            TextView priceTV = findViewById(R.id.price);
            ImageView picTV = findViewById(R.id.pic);
            TextView descTV = findViewById(R.id.desc);


            nameTV.setText(myFood.getName());
            priceTV.setText("$" + myFood.getPrice());
            descTV.setText(myFood.getDesc());


            if (myFood.getImageResourceID() == 0) {
                // set a default pic or decide what to do in this case.
            }
            else {
                /** Change photo to image id.*/
                picTV.setImageResource(myFood.getImageResourceID());
            }
        }
        catch (Exception e) {
            Log.i("Denna", "Food app not working!");
        }
    }
}
