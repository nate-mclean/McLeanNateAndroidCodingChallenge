package com.example.mcleannateandroidcodingchallenge;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> title;
    private final ArrayList<String> author;
    private final ArrayList<String> image;


    //constructor, has 3 fields for title, author, and image
    public CustomAdapter(Activity context, ArrayList<String> title, ArrayList<String> author, ArrayList<String> image) {
        super(context, R.layout.list_item, title);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.title=title;
        this.author=author;
        this.image=image;

        return;

    }

    //method to update the view for a single cell of the listview
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView authorText = (TextView) rowView.findViewById(R.id.author);

        titleText.setText(title.get(position));
        authorText.setText(author.get(position));

        //for images, parse the URL using external Picasso library
        try {
            Picasso.get().load(image.get(position)).into(imageView);
        }
        catch(IllegalArgumentException e){

        }

        return rowView;

    };
}
