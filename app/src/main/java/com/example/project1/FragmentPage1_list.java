package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentPage1_list extends Fragment {

    ArrayList<Mentor> mentorDataList;

    public static FragmentPage1_list newInstance() {
        return new FragmentPage1_list();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = (View) inflater.inflate(R.layout.fragment_page_1_list, container, false);

        this.InitializeRanking();

        ListView listView = (ListView) view.findViewById(R.id.mentor_list);
        final MentorAdapter cAdapter = new MentorAdapter(getContext(), mentorDataList);
        listView.setAdapter(cAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Mentor m = (Mentor)parent.getItemAtPosition(position);

                Fragment fragment = new FragmentPage1_chat();
                Bundle bundle = new Bundle(1);
                bundle.putInt("mentor_id", m.getId());
                fragment.setArguments(bundle);

                ((MainActivity)getActivity()).replaceFragment(fragment);
            }
        });

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void InitializeRanking() {
        mentorDataList = new ArrayList<Mentor>();

        mentorDataList.add(new Mentor("김지선", 0,"전자공학과 전자기기연구원 8년","노력은 배신하지 않는다.",3,"이윤하","진실된 답변 감사합니다!","5.0","정은지","작은 질문에도 정성스럽게 답변해주시는 모습 감동입니다~","5.0","4.8"));
        mentorDataList.add(new Mentor("최정선", 1,"바이오공학과 바이오공학자 13년","우리 학생들 화이팅^^",3,"김소담","진로고민때문에 걱정이 많았는데 감사합니다!","4.5","서은비","제가 원하던 과에 대해 알 수 있는 좋은 시간이었어요.","4.5","4.6"));
        mentorDataList.add(new Mentor("박민주", 2,"자동차공학과 엔진설계사 3년","오늘도 신나게 달려봅시다!",2,"박소라","요즘 자꾸 진로가 바뀌었는데 멘토님 덕분에 진로를 찾았어요!","4.5","김지원","멘토님 사랑합니당ㅎㅎ","5.0","4.3"));
        mentorDataList.add(new Mentor("이윤지", 3,"컴퓨터공학과 프로그래머 4년","내일의 행복을 위해 오늘도 화이팅~",2,"양다인","완전 우리 멘토님이 짱!","4.5","도민서","원하는 정보만 알려주시네요~","4.0","4.2"));
        mentorDataList.add(new Mentor("황선아", 4,"소프트웨어공학과 기계시스템설비사 7년","꿈은 바뀔 수 있다.",3,"이서진","멘토님 덕분에 자신감을 충전!!","5.0","최은솔","멘토님이 최고! 열심히 할게요!","4.0","4.1"));


    }
}
