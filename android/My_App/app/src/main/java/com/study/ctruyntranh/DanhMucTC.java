package com.study.ctruyntranh;

import android.widget.GridView;

public class DanhMucTC {
    private String id;
    private String tieuDe;
    private String imgTruyenTranh;

    public DanhMucTC(String id, String tieuDe, String imgTruyenTranh) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.imgTruyenTranh = imgTruyenTranh;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setImgTruyenTranh(String imgTruyenTranh) {
        this.imgTruyenTranh = imgTruyenTranh;
    }

    public String getId() {
        return id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getImgTruyenTranh() {
        return imgTruyenTranh;
    }
}
