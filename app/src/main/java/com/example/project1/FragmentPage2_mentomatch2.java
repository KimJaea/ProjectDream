package com.example.project1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentPage2_mentomatch2 extends Fragment {

    Boolean ismajor;
    ArrayAdapter<String> adapter;

    public static FragmentPage2_mentomatch2 newInstance() {
        return new FragmentPage2_mentomatch2();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_page_2_mentomatch2, container, false);
        ListView majorjoblist = (ListView) rootview.findViewById(R.id.majorjob_list2);
        EditText searchtext = (EditText) rootview.findViewById(R.id.mjsearch_text);

        List<String> mlist = new ArrayList<>();
        mlist.add("전자공학과");
        mlist.add("자동차공학과");
        mlist.add("소프트웨어공학과");

        List<String> jlist = new ArrayList<>();
        jlist.add("프로그래머");
        jlist.add("엔진설계사");
        jlist.add("기계시스템설비사");
        jlist.add("바이오공학자");

        Bundle bundle = getArguments();
        if(bundle != null){
            ismajor = bundle.getBoolean("ismajor");
        }

        if(ismajor){
            adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mlist);
            majorjoblist.setAdapter(adapter);
        }
        else{
            adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, jlist);
            majorjoblist.setAdapter(adapter);
        }

        searchtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString() ;
                if (filterText.length() > 0) {
                    majorjoblist.setFilterText(filterText) ;
                } else {
                    majorjoblist.clearTextFilter() ;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        }) ;

        majorjoblist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String majorjobdata = (String) adapterView.getItemAtPosition(i);

                Fragment fragment = new FragmentPage2_mentomatch3();
                Bundle bundle = new Bundle(2);
                bundle.putBoolean("ismajor",ismajor);
                bundle.putString("majorjobdata",majorjobdata);
                fragment.setArguments(bundle);

                ((MainActivity)getActivity()).replaceFragment(fragment);
            }
        });

        return rootview;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
