package com.lishichang.mubanentity;


/**
 * 管理文档 Document
 *
 */
public class Document {
    private int dindex;
    private String documenName;
    private String details;

    public Document(int dindex, String documenName, String details) {
        this.dindex = dindex;
        this.documenName = documenName;
        this.details = details;
    }

    public int getDindex() {
        return dindex;
    }

    public void setDindex(int dindex) {
        this.dindex = dindex;
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
