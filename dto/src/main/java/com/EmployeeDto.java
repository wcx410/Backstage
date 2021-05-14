package com;

public class EmployeeDto {
    private String searchStr;
    private String searchSate;
    private String searchSex;

    public EmployeeDto() {
        super();
    }

    public EmployeeDto(String searchStr, String searchSate, String searchSex) {
        this.searchStr = searchStr;
        this.searchSate = searchSate;
        this.searchSex = searchSex;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public String getSearchSate() {
        return searchSate;
    }

    public void setSearchSate(String searchSate) {
        this.searchSate = searchSate;
    }

    public String getSearchSex() {
        return searchSex;
    }

    public void setSearchSex(String searchSex) {
        this.searchSex = searchSex;
    }
}
