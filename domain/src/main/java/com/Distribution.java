package com;

public class Distribution {
    String id;
    String ordernumber;
    String ordstate;
    String id1;
    String name;
    String specification;
    String number;

    public Distribution() {
    }

    public Distribution(String id, String ordernumber, String ordstate, String id1, String name, String specification, String number) {
        this.id = id;
        this.ordernumber = ordernumber;
        this.ordstate = ordstate;
        this.id1 = id1;
        this.name = name;
        this.specification = specification;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getOrdstate() {
        return ordstate;
    }

    public void setOrdstate(String ordstate) {
        this.ordstate = ordstate;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "id='" + id + '\'' +
                ", ordernumber='" + ordernumber + '\'' +
                ", ordstate='" + ordstate + '\'' +
                ", id1='" + id1 + '\'' +
                ", name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
