package com.lishichang.mubanentity;



public class NetDevice {
    private int Nindex;
    private String NplatName;
    private String NdeviceName;
    private String NisVMhost;
    private String NosName;
    private String Nmodel;
    private String Ndescribe;
    private String NipAddr;
    private String Namount;
    private String NDegree;

    public NetDevice(int nindex, String nplatName, String ndeviceName, String nisVMhost, String nosName, String nmodel, String ndescribe, String nipAddr, String namount, String NDegree) {
        Nindex = nindex;
        NplatName = nplatName;
        NdeviceName = ndeviceName;
        NisVMhost = nisVMhost;
        NosName = nosName;
        Nmodel = nmodel;
        Ndescribe = ndescribe;
        NipAddr = nipAddr;
        Namount = namount;
        this.NDegree = NDegree;
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

    public int getNindex() {
        return Nindex;
    }

    public void setNindex(int nindex) {
        Nindex = nindex;
    }
}


