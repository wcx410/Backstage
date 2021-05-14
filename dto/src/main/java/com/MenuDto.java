package com;

public class MenuDto {
    private String searchStr;

    @Override
    public String toString() {
        return "MenuDto{" +
                "searchStr='" + searchStr + '\'' +
                '}';
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public MenuDto() {
    }

    public MenuDto(String searchStr) {
        this.searchStr = searchStr;
    }
}
