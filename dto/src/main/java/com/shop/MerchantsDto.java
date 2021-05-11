package com.shop;

public class MerchantsDto {
    private String search_shname;
    private String search_shaddress;
    private String search_shstate;

    public String getSearch_shstate() {
        return search_shstate;
    }

    public void setSearch_shstate(String search_shstate) {
        this.search_shstate = search_shstate;
    }

    public String getSearch_shname() {
        return search_shname;
    }

    public void setSearch_shname(String search_shname) {
        this.search_shname = search_shname;
    }

    public String getSearch_shaddress() {
        return search_shaddress;
    }

    public void setSearch_shaddress(String search_shaddress) {
        this.search_shaddress = search_shaddress;
    }
}
