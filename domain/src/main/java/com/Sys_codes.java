package com;

public class Sys_codes {
    private Integer ID;

    private Integer PARENT_ID;

    private String CODE_ID;

    private String NAME;

    private String STATUS;

    private String DEF_VALUE;

    private String DESCN;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPARENT_ID() {
        return PARENT_ID;
    }

    public void setPARENT_ID(Integer PARENT_ID) {
        this.PARENT_ID = PARENT_ID;
    }

    public String getCODE_ID() {
        return CODE_ID;
    }

    public void setCODE_ID(String CODE_ID) {
        this.CODE_ID = CODE_ID == null ? null : CODE_ID.trim();
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME == null ? null : NAME.trim();
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    public String getDEF_VALUE() {
        return DEF_VALUE;
    }

    public void setDEF_VALUE(String DEF_VALUE) {
        this.DEF_VALUE = DEF_VALUE == null ? null : DEF_VALUE.trim();
    }

    public String getDESCN() {
        return DESCN;
    }

    public void setDESCN(String DESCN) {
        this.DESCN = DESCN == null ? null : DESCN.trim();
    }
}