package com.example.mcleannateandroidcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> titles = new ArrayList<>();
    ArrayList<Integer> images = new ArrayList<>();
    ArrayList<String> authors = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titles.add("test 1 book");
        titles.add("test 2 book");
        titles.add("test 3 book");

        authors.add("test 1 author");
        authors.add("test 2 author");
        authors.add("test 3 book");

        images.add(R.drawable.test1);
        images.add(R.drawable.test2);
        images.add(R.drawable.test3);

        CustomAdapter adapter=new CustomAdapter(this, titles, authors, images);
        ListView list=(ListView)findViewById(R.id.listview);
        list.setAdapter(adapter);

    }
}
