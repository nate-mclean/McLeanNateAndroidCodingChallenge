package com.example.mcleannateandroidcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.dezlum.codelabs.getjson.GetJson;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> titles = new ArrayList<>();
    ArrayList<Integer> images = new ArrayList<>();
    ArrayList<String> authors = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get JSON
        try {
            String jsonString = new GetJson().AsString("http://de-coding-test.s3.amazonaws.com/books.json");

            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < 3 ; i++){ //jsonArray.length(); i++) {
                JSONObject jsonobject = jsonArray.getJSONObject(i);

                String title = jsonobject.getString("title");
                titles.add(title);

                String imgURL = jsonobject.getString("imageURL");

                //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);

                try {
                    String author = jsonobject.getString("author");
                    authors.add(author);
                }
                catch (JSONException e){
                    authors.add("");
                }
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //titles.add("test 1 book");
        //titles.add("test 2 book");
        //titles.add("test 3 book");

        //authors.add("test 1 author");
        //authors.add("test 2 author");
        //authors.add("test 3 book");

        images.add(R.drawable.test1);
        images.add(R.drawable.test2);
        images.add(R.drawable.test3);

        CustomAdapter adapter=new CustomAdapter(this, titles, authors, images);
        ListView list=(ListView)findViewById(R.id.listview);
        list.setAdapter(adapter);

    }
}
