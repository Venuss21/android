package com.study.ctruyntranh;

public class TruyenTranhTC {
    private String id;
    private String tenTruyen;
    private String img;



    public TruyenTranhTC(String id, String tenTruyen, String img) {
        this.id = id;
        this.tenTruyen = tenTruyen;
        this.img = img;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
