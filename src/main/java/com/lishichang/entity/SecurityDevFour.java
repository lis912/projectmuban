package com.lishichang.entity;

public class SecurityDevFour {
    private int sid;
    private String splatName;
    private String sdeviceName;
    private String sisVMhost;
    private String sosName;
    private String smodel;
    private String sdescribe;
    private String sipAddr;
    private String samount;
    private String sDegree;
    private String sisSample;

    public SecurityDevFour(String splatName, String sdeviceName, String sisVMhost, String sosName, String smodel, String sdescribe, String sipAddr, String samount, String sDegree, String sisSample) {
        this.splatName = splatName;
        this.sdeviceName = sdeviceName;
        this.sisVMhost = sisVMhost;
        this.sosName = sosName;
        this.smodel = smodel;
        this.sdescribe = sdescribe;
        this.sipAddr = sipAddr;
        this.samount = samount;
        this.sDegree = sDegree;
        this.sisSample = sisSample;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSplatName() {
        return splatName;
    }

    public void setSplatName(String splatName) {
        this.splatName = splatName;
    }

    public String getSdeviceName() {
        return sdeviceName;
    }

    public void setSdeviceName(String sdeviceName) {
        this.sdeviceName = sdeviceName;
    }

    public String getSisVMhost() {
        return sisVMhost;
    }

    public void setSisVMhost(String sisVMhost) {
        this.sisVMhost = sisVMhost;
    }

    public String getSosName() {
        return sosName;
    }

    public void setSosName(String sosName) {
        this.sosName = sosName;
    }

    public String getSmodel() {
        return smodel;
    }

    public void setSmodel(String smodel) {
        this.smodel = smodel;
    }

    public String getSdescribe() {
        return sdescribe;
    }

    public void setSdescribe(String sdescribe) {
        this.sdescribe = sdescribe;
    }

    public String getSipAddr() {
        return sipAddr;
    }

    public void setSipAddr(String sipAddr) {
        this.sipAddr = sipAddr;
    }

    public String getSamount() {
        return samount;
    }

    public void setSamount(String samount) {
        this.samount = samount;
    }

    public String getsDegree() {
        return sDegree;
    }

    public void setsDegree(String sDegree) {
        this.sDegree = sDegree;
    }

    public String getSisSample() {
        return sisSample;
    }

    public void setSisSample(String sisSample) {
        this.sisSample = sisSample;
    }
}
