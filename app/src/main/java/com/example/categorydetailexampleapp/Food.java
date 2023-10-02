package com.example.categorydetailexampleapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
// Cheat sheet to make object parcelable:
// 1. implements Parcelable on class header
//2. default constructor (no params)
// 3. constructor that tells Java how to read a Parcel to create an object
//4. writeToParcel method tells Java how to send the Parcel
//5. Create method: Just replace class name
//6. Discriminant
public class Food implements Parcelable {
    private String name;
    private double price;
    private String desc;
    private int imageResourceID;

    public Food(String name, double price, String desc, int imageResourceID) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.imageResourceID = imageResourceID;
    }
    // A default constructor is required for the Parceable interface to work. Need this whether or not you use it.
    public Food() {
        name = "";
        price = 0;
        desc = "";
        imageResourceID = 0;
    }
    public static final Food[] myBreakfast = {
            new Food("Pancakes", 10.99, "four Old Fashioned Maple Syrup pancakes", R.drawable.pancake),
            new Food("Waffles", 7.99, "two Crispy Golden Brown", R.drawable.waffles),
            new Food("Donut", 2.99, "Chocolate/Strawberry with Sprinkles", R.drawable.donut)

    };
    public static final Food[] myLunch = {
            new Food("Sandwich", 8.99, "The Original/ Fresh Veggie", R.drawable.sandwich),
            new Food("Pasta", 12.99, "Traditional Italian Pasta", R.drawable.pasta),
            new Food("Pie", 5.99, "Blueberry Flavored", R.drawable.pie)

    };
    public static final Food[] myDinner = {
            new Food("Rice", 11.99, "spicy and flavorful", R.drawable.rice),
            new Food("Taco", 3.99, "Big, crunchy", R.drawable.taco),
            new Food("Salad", 6.99, "Seasoned Caesar Salad", R.drawable.salad)
    };




    // this code is needed for the Food class to work with Parcelable
    // this code needs no changes other than replacing the word food with another word for new project.
    public static final Parcelable.Creator<Food> CREATOR = new
            Parcelable.Creator<Food>() {

                @Override
                public Food createFromParcel(Parcel parcel) {
                    return new Food(parcel);
                }

                @Override
                public Food[] newArray(int size) {
                    return new Food[0];
                }
            };

    /** This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Food object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     * if the instance variables were objects themselves you would need to do more complex * code.  We need to read in the String, double, and int data.
     *
     * The order of read and write methods matters
     *
     * @param parcel    the parcel that is received from the intent
     */

    public Food(Parcel parcel) {
        name = parcel.readString();
        price = parcel.readDouble();
        desc = parcel.readString();
        imageResourceID = parcel.readInt();
    }

    public String toString() {
        return name;
    }
        /**
         * This is what is used when we send the Food object through an intent
         * It is also a method that is part of the Parceable interface and is needed
         * to set up the object that is being sent.  Then, when it is received, the
         * other Food constructor that accepts a Parcel reference can "unpack it"
         *
         * Has to be consistent with read and write order
         */
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeDouble(price);
            dest.writeString(desc);
            dest.writeInt(imageResourceID);
        }

        /**
         * This method is required for the Parceable interface.  As of now, this method * is in the default state and doesn't really do anything.
         *
         * If your Parcelable class will have child classes, you'll need to
         * take some extra care with the describeContents() method. This would
         * let you identify the specific child class that should be created by
         * the Parcelable.Creator. You can read more about how this works on
         *  Stack Overflow with this link.
         *           https://stackoverflow.com/questions/4778834/purpose-of-describecontents-of-parcelable-interface
         * @return
         */



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    }

