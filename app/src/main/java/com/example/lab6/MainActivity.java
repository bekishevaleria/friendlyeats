package com.example.lab6;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainActivity extends AppCompatActivity {

    private TextView kitten_info;
    private View kitten_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kitten_info = findViewById(R.id.kitten);
        kitten_color = findViewById(R.id.kitten_color);

        Cat cat1 = new Cat();
        cat1.name = "Васька";
        cat1.age = 5;
        cat1.color = Color.MAGENTA;


        Gson gson = new Gson();
        Log.i("GSON", gson.toJson(cat1));

        String jsontext = gson.toJson(cat1);
        GsonBuilder builder = new GsonBuilder();
        Gson gson2 = builder.create();
        Cat cat2 = gson.fromJson(jsontext, Cat.class);
        kitten_info.setText("Кот "+ cat2.name + ", " + cat2.age + " лет, цвет : ");
        kitten_color.setBackgroundColor(cat2.color);
    }




}
