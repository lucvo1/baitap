package com.example.appngenhac.Nhac;

public class ListNhac {
    private int Id;
    private String TenBH;
    public ListNhac(int id,String tenBH){
        Id=id;
        TenBH = tenBH;
    }
    public int getId(){
        return Id;
    }
    public void setId(int id){
        Id = id;
    }
    public String getTenBH(){
        return TenBH;
    }
    public void setTenBH(String tenBH){
        TenBH = tenBH;
    }
}
