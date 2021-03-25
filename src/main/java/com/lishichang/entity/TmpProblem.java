package com.lishichang.entity;

public class TmpProblem {
    private int tmpid;
    private String tmpAssociateDev;  // 关联资产
    private String tmpBigLay;   // 层面
    private String tmpItem ;    // 控制项


    public TmpProblem(int tmpid, String tmpAssociateDev, String tmpBigLay, String tmpItem) {
        this.tmpid = tmpid;
        this.tmpAssociateDev = tmpAssociateDev;
        this.tmpBigLay = tmpBigLay;
        this.tmpItem = tmpItem;
    }

    public int getTmpid() {
        return tmpid;
    }

    public void setTmpid(int tmpid) {
        this.tmpid = tmpid;
    }

    public String getTmpAssociateDev() {
        return tmpAssociateDev;
    }

    public void setTmpAssociateDev(String tmpAssociateDev) {
        this.tmpAssociateDev = tmpAssociateDev;
    }

    public String getTmpBigLay() {
        return tmpBigLay;
    }

    public void setTmpBigLay(String tmpBigLay) {
        this.tmpBigLay = tmpBigLay;
    }

    public String getTmpItem() {
        return tmpItem;
    }

    public void setTmpItem(String tmpItem) {
        this.tmpItem = tmpItem;
    }
}
