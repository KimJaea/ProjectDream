package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentPage2_mentomatch extends Fragment {
    Boolean ismajor = false;

    public static FragmentPage2_mentomatch newInstance() {
        return new FragmentPage2_mentomatch();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_page_2_mentomatch, container, false);
        ListView majorjoblist = (ListView) rootview.findViewById(R.id.majorjob_list);

        List<String> mjlist = new ArrayList<>();
        mjlist.add("전공");
        mjlist.add("직업");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mjlist);
        majorjoblist.setAdapter(adapter);

        majorjoblist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mjdata = (String) adapterView.getItemAtPosition(i);
                if(mjdata=="전공"){
                    ismajor=true;
                }
                else if(mjdata=="직업"){
                    ismajor=false;
                }

                Fragment fragment = new FragmentPage2_mentomatch2(); // Fragment 생성
                Bundle bundle = new Bundle(1); // 파라미터는 전달할 데이터 개수
                bundle.putBoolean("ismajor", ismajor); // key , value
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
