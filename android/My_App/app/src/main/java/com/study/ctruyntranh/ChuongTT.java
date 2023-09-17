package com.study.ctruyntranh;

public class ChuongTT {

    private String id;
    private String tenChuong;
    private String thoiGian;
    private String tentruyen;
    private String idTruyen;


    public ChuongTT(String id, String tenChuong, String thoiGian, String tentruyen, String idTruyen) {
        this.id = id;
        this.tenChuong = tenChuong;
        this.thoiGian = thoiGian;
        this.tentruyen = tentruyen;
        this.idTruyen = idTruyen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenChuong() {
        return tenChuong;
    }

    public void setTenChuong(String tenChuong) {
        this.tenChuong = tenChuong;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public String getIdTruyen() {
        return idTruyen;
    }

    public void setIdTruyen(String idTruyen) {
        this.idTruyen = idTruyen;
    }
}
