package com.example.project1;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MentorAdapter extends BaseAdapter {

    Context rContext = null;
    LayoutInflater rLayoutInflater = null;
    ArrayList<Mentor> mentorList;

    public MentorAdapter(Context context, ArrayList<Mentor> data) {
        rContext = context;
        mentorList = data;
        rLayoutInflater = LayoutInflater.from(rContext);
    }

    @Override
    public int getCount() {
        return mentorList.size();
    }

    @Override
    public Object getItem(int position) {
        return mentorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View view = rLayoutInflater.inflate(R.layout.chat_item, null);

        ImageView image = (ImageView)view.findViewById(R.id.mentor_image);
        image.setBackground(new ShapeDrawable(new OvalShape()));
        TextView name = (TextView)view.findViewById(R.id.mentor_name);
        TextView spec = (TextView)view.findViewById(R.id.mentor_spec);

        int crown = mentorList.get(position).getImage();
        if(crown == 1)
            image.setImageResource(R.drawable.crown_128_1);
        else if(crown == 2)
            image.setImageResource(R.drawable.crown_128_2);
        else if(crown == 3)
            image.setImageResource(R.drawable.crown_128_3);
        name.setText(mentorList.get(position).getName());
        spec.setText(mentorList.get(position).getSpec());

        return view;
    }
}
