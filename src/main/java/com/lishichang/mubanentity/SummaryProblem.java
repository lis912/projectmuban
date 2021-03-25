package com.lishichang.mubanentity;

// 问题汇总输出数据结构
public class SummaryProblem {
    private int sumid;
    private String sumDescribe;      // 问题描述
    private String sumAssociateDev;  // 关联资产
    private String sumComment;       // 备注

    public SummaryProblem(int sumid, String sumDescribe, String sumAssociateDev,String sumComment) {
        this.sumid = sumid;
        this.sumAssociateDev = sumAssociateDev;
        this.sumDescribe = sumDescribe;
        this.sumComment = sumComment;
    }

    public int getSumid() {
        return sumid;
    }

    public void setSumid(int sumid) {
        this.sumid = sumid;
    }

    public String getSumAssociateDev() {
        return sumAssociateDev;
    }

    public void setSumAssociateDev(String sumAssociateDev) {
        this.sumAssociateDev = sumAssociateDev;
    }

    public String getSumDescribe() {
        return sumDescribe;
    }

    public void setSumDescribe(String sumDescribe) {
        this.sumDescribe = sumDescribe;
    }

    public String getSumComment() {
        return sumComment;
    }

    public void setSumComment(String sumComment) {
        this.sumComment = sumComment;
    }
}
