package com.example.mcleannateandroidcodingchallenge;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> title;
    private final ArrayList<String> author;
    private final ArrayList<Integer> image;

    public CustomAdapter(Activity context, ArrayList<String> title, ArrayList<String> author, ArrayList<Integer> image) {
        super(context, R.layout.list_item, title);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.title=title;
        this.author=author;
        this.image=image;

        return;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView authorText = (TextView) rowView.findViewById(R.id.author);

        titleText.setText(title.get(position));
        imageView.setImageResource(image.get(position));
        authorText.setText(author.get(position));

        return rowView;

    };
}
