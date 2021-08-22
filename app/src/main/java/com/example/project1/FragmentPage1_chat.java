package com.example.project1;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.net.Socket;

import java.util.ArrayList;

public class FragmentPage1_chat extends Fragment {

    int mentor_id;
    private ArrayList<String> message;
    private ArrayList<String> info;
    //private String ip = "203.252.223.250";

    ListView messages_view;
    EditText text;

    public static FragmentPage1_chat newInstance() {
        return new FragmentPage1_chat();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mentor_id = getArguments().getInt("mentor_id");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_page_1_chat, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        messages_view = (ListView) view.findViewById(R.id.messages_view);
        text = (EditText) view.findViewById(R.id.text);
        Button send = (Button) view.findViewById(R.id.send);

        message = new ArrayList<String>();
        info = new ArrayList<String>();
        final DiscussAdapter dAdapter = new DiscussAdapter(getContext(), message, info);
        messages_view.setAdapter(dAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text.getText().toString().length() > 0) {

                    sendMessage(text.getText().toString());
                    dAdapter.notifyDataSetChanged();
                    text.getText().clear();
                }
            }
        });

        return view;
    }

    public void sendMessage(String text) {
        message.add(text);
        info.add("0");
        return;
    }
    public void receiveMessage(String text) {
        message.add(text);
        info.add(Integer.toString(mentor_id));
        return;
    }

}
