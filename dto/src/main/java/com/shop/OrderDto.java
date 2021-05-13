package com.shop;

public class OrderDto {
    private String search_ordstate;
    private String search_ordname;
    private String s_merid;

    public String getS_merid() {
        return s_merid;
    }

    public void setS_merid(String s_merid) {
        this.s_merid = s_merid;
    }

    public String getSearch_ordname() {
        return search_ordname;
    }

    public void setSearch_ordname(String search_ordname) {
        this.search_ordname = search_ordname;
    }

    public String getSearch_ordstate() {
        return search_ordstate;
    }

    public void setSearch_ordstate(String search_ordstate) {
        this.search_ordstate = search_ordstate;
    }
}
