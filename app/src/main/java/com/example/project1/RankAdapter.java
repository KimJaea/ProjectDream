package com.example.project1;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RankAdapter extends BaseAdapter {

    Context rContext = null;
    LayoutInflater rLayoutInflater = null;
    ArrayList<Mentor> mentorList;

    public RankAdapter(Context context, ArrayList<Mentor> data) {
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
        View view = rLayoutInflater.inflate(R.layout.rank_item, null);

        ImageView image = (ImageView)view.findViewById(R.id.mentor_image);
        image.setBackground(new ShapeDrawable(new OvalShape()));
        TextView name = (TextView)view.findViewById(R.id.mentor_name);
        TextView spec = (TextView)view.findViewById(R.id.mentor_spec);
        TextView intro = (TextView)view.findViewById(R.id.intro);
        TextView score = (TextView)view.findViewById(R.id.mentor_score);

        ImageView menteeimage1=(ImageView) view.findViewById(R.id.mentee_image1);
        menteeimage1.setBackground(new ShapeDrawable(new OvalShape()));
        TextView menteename1 = (TextView)view.findViewById(R.id.mentee_name1);
        TextView menteecomment1 = (TextView)view.findViewById(R.id.mentee_comment1);
        TextView menteescore1 = (TextView)view.findViewById(R.id.mentee_score1);

        ImageView menteeimage2=(ImageView) view.findViewById(R.id.mentee_image2);
        menteeimage2.setBackground(new ShapeDrawable(new OvalShape()));
        TextView menteename2 = (TextView)view.findViewById(R.id.mentee_name2);
        TextView menteecomment2 = (TextView)view.findViewById(R.id.mentee_comment2);
        TextView menteescore2 = (TextView)view.findViewById(R.id.mentee_score2);


        int crown = mentorList.get(position).getImage();
        if(crown == 1)
            image.setImageResource(R.drawable.crown_128_1);
        else if(crown == 2)
            image.setImageResource(R.drawable.crown_128_2);
        else if(crown == 3)
            image.setImageResource(R.drawable.crown_128_3);
        name.setText(mentorList.get(position).getName());
        spec.setText(mentorList.get(position).getSpec());
        intro.setText(mentorList.get(position).getIntro());
        score.setText(mentorList.get(position).getScore());
        menteeimage1.setImageResource(R.drawable.leaf_128);
        menteename1.setText(mentorList.get(position).getMenteename1());
        menteecomment1.setText(mentorList.get(position).getMenteecomment1());
        menteescore1.setText(mentorList.get(position).getMenteescore1());
        menteeimage2.setImageResource(R.drawable.leaf_128);
        menteename2.setText(mentorList.get(position).getMenteename2());
        menteecomment2.setText(mentorList.get(position).getMenteecomment2());
        menteescore2.setText(mentorList.get(position).getMenteescore2());



        return view;
    }
}
