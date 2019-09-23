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


    //arraylists to hold parsed JSON data
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> images = new ArrayList<>();
    ArrayList<String> authors = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get JSON
        try {

            //use library to get json
            
            Log.d("a", "before");
            String jsonString = new GetJson().AsString("http://de-coding-test.s3.amazonaws.com/books.json");
            Log.d("a", "after");

            //format as json array



            JSONArray jsonArray = new JSONArray(jsonString);

            //get each title, author, and image one by one
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonobject = jsonArray.getJSONObject(i);

                //title
                String title = jsonobject.getString("title");
                titles.add(title);


                //Image, try/catch in case there is no image for that json element
                try {
                    String imgURL = jsonobject.getString("imageURL");
                    images.add(imgURL);
                }
                catch (JSONException e){
                images.add("");
                }


                //author, try/catch in case there is no author for that json element
                try {
                    String author = jsonobject.getString("author");
                    authors.add("Author: " + author);
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



        //custom listview adapter instantiation
        CustomAdapter adapter=new CustomAdapter(this, titles, authors, images);
        ListView list=(ListView)findViewById(R.id.listview);
        list.setAdapter(adapter);

    }
}
