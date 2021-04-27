package com;

public class CommodityDto {
    //商品名
    private String name;
    //商品类型
    private int com_type;
    //商品状态
    private String state;

    public CommodityDto(String name, int com_type, String state) {
        this.name = name;
        this.com_type = com_type;
        this.state = state;
    }

    public CommodityDto() {
        super();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCom_type() {
        return com_type;
    }

    public void setCom_type(int com_type) {
        this.com_type = com_type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CommodityDto{" +
                "name='" + name + '\'' +
                ", com_type=" + com_type +
                ", state='" + state + '\'' +
                '}';
    }
}
