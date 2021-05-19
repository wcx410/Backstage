package com;


public class UserDto {
    private String username;
    private String idCard;
    private String sex;
    private Integer state;
    private Integer isDelete;

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sex='" + sex + '\'' +
                ", state=" + state +
                ", isDelete=" + isDelete +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public UserDto() {
    }

    public UserDto(String username, String idCard, String sex, Integer state, Integer isDelete) {
        this.username = username;
        this.idCard = idCard;
        this.sex = sex;
        this.state = state;
        this.isDelete = isDelete;
    }
}
