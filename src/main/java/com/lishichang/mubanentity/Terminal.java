package com.lishichang.mubanentity;

public class Terminal {
    private int tindex;
    private String tplatName;
    private String tdeviceName;
    private String tisVMhost;
    private String tosName;
    private String tmodel;
    private String tdescribe;
    private String tamount;
    private String tipAddr;
    private String tDegree;

    public Terminal(int tindex, String tplatName, String tdeviceName, String tisVMhost, String tosName, String tmodel, String tdescribe, String tamount, String tipAddr, String tDegree) {
        this.tindex = tindex;
        this.tplatName = tplatName;
        this.tdeviceName = tdeviceName;
        this.tisVMhost = tisVMhost;
        this.tosName = tosName;
        this.tmodel = tmodel;
        this.tdescribe = tdescribe;
        this.tipAddr = tipAddr;
        this.tamount = tamount;
        this.tDegree = tDegree;
    }

    public int getTindex() {
        return tindex;
    }

    public void setTindex(int tindex) {
        this.tindex = tindex;
    }

    public String getTplatName() {
        return tplatName;
    }

    public void setTplatName(String tplatName) {
        this.tplatName = tplatName;
    }

    public String getTdeviceName() {
        return tdeviceName;
    }

    public void setTdeviceName(String tdeviceName) {
        this.tdeviceName = tdeviceName;
    }

    public String getTisVMhost() {
        return tisVMhost;
    }

    public void setTisVMhost(String tisVMhost) {
        this.tisVMhost = tisVMhost;
    }

    public String getTosName() {
        return tosName;
    }

    public void setTosName(String tosName) {
        this.tosName = tosName;
    }

    public String getTmodel() {
        return tmodel;
    }

    public void setTmodel(String tmodel) {
        this.tmodel = tmodel;
    }

    public String getTdescribe() {
        return tdescribe;
    }

    public void setTdescribe(String tdescribe) {
        this.tdescribe = tdescribe;
    }

    public String getTipAddr() {
        return tipAddr;
    }

    public void setTipAddr(String tipAddr) {
        this.tipAddr = tipAddr;
    }

    public String getTamount() {
        return tamount;
    }

    public void setTamount(String tamount) {
        this.tamount = tamount;
    }

    public String gettDegree() {
        return tDegree;
    }

    public void settDegree(String tDegree) {
        this.tDegree = tDegree;
    }
}
