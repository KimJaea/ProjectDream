package com.example.project1;

public class Mentor {

    private int id;
    private int image;
    private String name;
    private String spec;
    private String intro;
    private String score;
    private String menteename1;
    private String menteename2;
    private String menteecomment1;
    private String menteecomment2;
    private String menteescore1;
    private String menteescore2;

    public Mentor(String name, int id) {
        this.name = name;
        this.id = id;
        this.spec = "스펙이 없습니다.";
        this.intro = "설명이 없습니다.";
        this.image = 1;
        this.score="5.0";
        this.menteename1 = "멘티1이름";
        this.menteename2 = "멘티2이름";
        this.menteecomment1 = "멘티1코멘트";
        this.menteecomment2 = "멘티2코멘트";
        this.menteescore1 = "별점1";
        this.menteescore2 = "별점2";
    }

    public Mentor(String name, int id, String spec, String intro, int image, String menteename1, String menteecomment1, String menteescore1, String menteename2, String menteecomment2, String menteescore2, String score) {
        this.name = name;
        this.id = id;
        this.spec = spec;
        this.intro = intro;
        this.image = 1;
        this.score = score;
        this.menteename1 = menteename1;
        this.menteename2 = menteename2;
        this.menteecomment1 = menteecomment1;
        this.menteecomment2 = menteecomment2;
        this.menteescore1 = menteescore1;
        this.menteescore2 = menteescore2;
    }



    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public int getImage() {
        return this.image;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
    public String getSpec() {
        return this.spec;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
    public String getIntro() {
        return this.intro;
    }

    public void setMenteename1(String menteename1) {this.menteename1 = menteename1;}
    public String getMenteename1() { return this.menteename1;}

    public void setMenteename2(String menteename2) {this.menteename2=menteename2;}
    public String getMenteename2() {return this.menteename2;}

    public void setMenteecomment1(String menteecomment1) {this.menteecomment1=menteecomment1;}
    public String getMenteecomment1() {return this.menteecomment1;}

    public void setMenteecomment2(String menteecomment2) {this.menteecomment2=menteecomment2;}
    public String getMenteecomment2() {return this.menteecomment2;}

    public void setMenteescore1(String menteename1) {this.menteescore1=menteename1;}
    public String getMenteescore1() {return this.menteescore1;}

    public void setMenteescore2(String menteescore2) {this.menteescore2=menteescore2;}
    public String getMenteescore2() {return this.menteescore2;}

    public void setScore(String score) {this.score=score;}
    public String getScore() {return this.score;}
}
