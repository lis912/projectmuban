package com.lishichang.entity;


public class NetDeviceThree {
    private int Nid;    // 序号
    private String NplatName;  // 外键系统名称
    private String NdeviceName;  // 设备名称
    private String NisVMhost;  // 是否虚拟设备
    private String NosName;   // 系统及版本
    private String Nmodel;   // 品牌型号
    private String Ndescribe;  // 用途
    private String NipAddr;   // IP地址
    private String Namount;   // 数量（台/套）
    private String NDegree;   // 重要程度
    private String NisSample;  // 是否抽选

    public NetDeviceThree(String nplatName, String ndeviceName, String nisVMhost, String nosName, String nmodel, String ndescribe, String nipAddr, String namount, String NDegree, String nisSample) {
        this.NplatName = nplatName;
        this.NdeviceName = ndeviceName;
        this.NisVMhost = nisVMhost;
        this.NosName = nosName;
        this.Nmodel = nmodel;
        this.Ndescribe = ndescribe;
        this.NipAddr = nipAddr;
        this.Namount = namount;
        this.NDegree = NDegree;
        this.NisSample = nisSample;
    }

    public int getNid() {
        return Nid;
    }

    public void setNid(int nid) {
        Nid = nid;
    }

    public String getNplatName() {
        return NplatName;
    }

    public void setNplatName(String nplatName) {
        NplatName = nplatName;
    }

    public String getNdeviceName() {
        return NdeviceName;
    }

    public void setNdeviceName(String ndeviceName) {
        NdeviceName = ndeviceName;
    }

    public String getNisVMhost() {
        return NisVMhost;
    }

    public void setNisVMhost(String nisVMhost) {
        NisVMhost = nisVMhost;
    }

    public String getNosName() {
        return NosName;
    }

    public void setNosName(String nosName) {
        NosName = nosName;
    }

    public String getNmodel() {
        return Nmodel;
    }

    public void setNmodel(String nmodel) {
        Nmodel = nmodel;
    }

    public String getNdescribe() {
        return Ndescribe;
    }

    public void setNdescribe(String ndescribe) {
        Ndescribe = ndescribe;
    }

    public String getNipAddr() {
        return NipAddr;
    }

    public void setNipAddr(String nipAddr) {
        NipAddr = nipAddr;
    }

    public String getNamount() {
        return Namount;
    }

    public void setNamount(String namount) {
        Namount = namount;
    }

    public String getNDegree() {
        return NDegree;
    }

    public void setNDegree(String NDegree) {
        this.NDegree = NDegree;
    }

    public String getNisSample() {
        return NisSample;
    }

    public void setNisSample(String nisSample) {
        NisSample = nisSample;
    }
}
