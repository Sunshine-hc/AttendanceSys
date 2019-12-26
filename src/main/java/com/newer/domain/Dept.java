package com.newer.domain;

import java.io.Serializable;

/**
 * @ClassName 部门实体
 * @Autho wangye
 **/
public class Dept implements Serializable{
    private Integer did;
    private String dname;
    private Integer dadminid;

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", dadminid=" + dadminid +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDadminid() {
        return dadminid;
    }

    public void setDadminid(Integer dadminid) {
        this.dadminid = dadminid;
    }
}
