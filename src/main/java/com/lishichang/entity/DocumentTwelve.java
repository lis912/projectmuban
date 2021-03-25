package com.lishichang.entity;

public class DocumentTwelve {
    private int dId;
    private String dpaltName;
    private String documenName;
    private String details;

    public DocumentTwelve(String dpaltName, String documenName, String details) {
        this.dpaltName = dpaltName;
        this.documenName = documenName;
        this.details = details;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getDpaltName() {
        return dpaltName;
    }

    public void setDpaltName(String dpaltName) {
        this.dpaltName = dpaltName;
    }

    public String getDocumenName() {
        return documenName;
    }

    public void setDocumenName(String documenName) {
        this.documenName = documenName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
