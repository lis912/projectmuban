package com.lishichang.mubanentity;

public class WordChange {
    private int dindex;
    private String documenName;


    public WordChange(int dindex, String documenName) {
        this.dindex = dindex;
        this.documenName = documenName;
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
}
