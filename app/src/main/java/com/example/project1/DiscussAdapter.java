package com.example.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DiscussAdapter extends BaseAdapter {

    Context rContext = null;
    LayoutInflater rLayoutInflater = null;
    ArrayList<String> chatList;
    ArrayList<String> chatInfo;
    // 0 for me, 1 for opponent

    public DiscussAdapter(Context context, ArrayList<String> data, ArrayList<String> info) {
        rContext = context;
        chatList = data;
        chatInfo = info;
        rLayoutInflater = LayoutInflater.from(rContext);
    }

    @Override
    public int getCount() {
        return chatList.size();
    }

    @Override
    public Object getItem(int position) {
        return chatList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View view = rLayoutInflater.inflate(R.layout.message_1, null);

        if(chatInfo.get(position).equals("0")) {
            view = rLayoutInflater.inflate(R.layout.message_1, null);
            TextView text = (TextView) view.findViewById(R.id.my_msg);
            text.setText(chatList.get(position));
        } else {
            view = rLayoutInflater.inflate(R.layout.message_2, null);
            TextView name = (TextView) view.findViewById(R.id.name);
            TextView text = (TextView) view.findViewById(R.id.mentor_msg);
            name.setText(chatInfo.get(position));
            text.setText(chatList.get(position));
        }

        return view;
    }
}
