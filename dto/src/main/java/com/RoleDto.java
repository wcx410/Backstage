package com;

public class RoleDto {
    private String searchStr;

    public RoleDto() {
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "searchStr='" + searchStr + '\'' +
                '}';
    }

    public RoleDto(String searchStr) {
        this.searchStr = searchStr;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }
}
