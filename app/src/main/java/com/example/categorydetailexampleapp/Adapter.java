package com.example.categorydetailexampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Food> {
    public Adapter(Context context, ArrayList<Food> foodList) {
        super(context, 0, foodList);
    }
    // this method will tell us how to set up ONE row of ListView
    public View getView(int position, View convertView, ViewGroup parent) {
        Food myFood = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    // linking the custom food layout xml file HERE (this is essentially the new category activity)
                    .inflate(R.layout.item_food_row_layout, parent, false);
        }
        // Step 1: Connect XML references for YOUR custom view
        TextView name = convertView.findViewById(R.id.nameCategory);
        TextView price = convertView.findViewById(R.id.priceCategory);
        TextView desc = convertView.findViewById(R.id.descCategory);
        // Step 2: Populate the specific row data into the variables you made in step 1
        name.setText(myFood.getName());
        price.setText("$" + myFood.getPrice());
        desc.setText(myFood.getDesc());
        // Step 3: Return the completed view to render on screen
        return convertView;
    }
}

