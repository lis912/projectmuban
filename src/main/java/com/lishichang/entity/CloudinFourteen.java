package com.lishichang.entity;

public class CloudinFourteen {
    private int cid;
    private String cpaltName;
    private String cloudPlatName;
    private String cloudLesseeName;
    private String cloudServerDetail;

    public CloudinFourteen(String cpaltName, String cloudPlatName, String cloudLesseeName, String cloudServerDetail) {
        this.cpaltName = cpaltName;
        this.cloudPlatName = cloudPlatName;
        this.cloudLesseeName = cloudLesseeName;
        this.cloudServerDetail = cloudServerDetail;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCpaltName() {
        return cpaltName;
    }

    public void setCpaltName(String cpaltName) {
        this.cpaltName = cpaltName;
    }

    public String getCloudPlatName() {
        return cloudPlatName;
    }

    public void setCloudPlatName(String cloudPlatName) {
        this.cloudPlatName = cloudPlatName;
    }

    public String getCloudLesseeName() {
        return cloudLesseeName;
    }

    public void setCloudLesseeName(String cloudLesseeName) {
        this.cloudLesseeName = cloudLesseeName;
    }

    public String getCloudServerDetail() {
        return cloudServerDetail;
    }

    public void setCloudServerDetail(String cloudServerDetail) {
        this.cloudServerDetail = cloudServerDetail;
    }
}
