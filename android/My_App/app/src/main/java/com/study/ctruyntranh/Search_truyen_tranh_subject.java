package com.study.ctruyntranh;

import java.nio.channels.Pipe;

public class Search_truyen_tranh_subject {
    private String id;
    private String name;
    private String img;
    private String thoiGian;
    private String tongChuong;

    public Search_truyen_tranh_subject(String id, String name, String img, String thoiGian, String tongChuong) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.thoiGian = thoiGian;
        this.tongChuong = tongChuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getTongChuong() {
        return tongChuong;
    }

    public void setTongChuong(String tongChuong) {
        this.tongChuong = tongChuong;
    }
}
