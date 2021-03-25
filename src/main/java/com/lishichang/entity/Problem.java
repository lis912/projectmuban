package com.lishichang.entity;

// 问题汇总数据源
public class Problem {
    private int Proid;
    private String proBigLay;   // 层面
    private String proMinLay;  // 安全层面
    private String proPoint ;   // 控制点
    private String proItem ;    // 控制项
    private String proItemDegree ;    // 控制项等级
    private String proDescribe;      // 问题描述
    private String proAnalyse;      // 问题分析
    private String proaThret;      // 关联威胁
    private String proaThretDegree;      // 原始风险值
    private String proaThretAnalyse;      // 危害分析
    private String proaRecommendations;      // 整改建议
    private String proDev;  // 关联软硬件设备
    private String proComment ;  // 备注

    public Problem(int Proid, String proBigLay, String proMinLay, String proPoint, String proItem, String proItemDegree, String proDescribe, String proAnalyse, String proaThret, String proaThretDegree, String proaThretAnalyse, String proaRecommendations, String proDev, String proComment) {
        this.Proid = Proid;
        this.proBigLay = proBigLay;
        this.proMinLay = proMinLay;
        this.proPoint = proPoint;
        this.proItem = proItem;
        this.proItemDegree = proItemDegree;
        this.proDescribe = proDescribe;
        this.proAnalyse = proAnalyse;
        this.proaThret = proaThret;
        this.proaThretDegree = proaThretDegree;
        this.proaThretAnalyse = proaThretAnalyse;
        this.proaRecommendations = proaRecommendations;
        this.proDev = proDev;
        this.proComment = proComment;
    }

    public int getProid() {
        return Proid;
    }

    public void setProid(int proid) {
        Proid = proid;
    }

    public String getProBigLay() {
        return proBigLay;
    }

    public void setProBigLay(String proBigLay) {
        this.proBigLay = proBigLay;
    }

    public String getProMinLay() {
        return proMinLay;
    }

    public void setProMinLay(String proMinLay) {
        this.proMinLay = proMinLay;
    }

    public String getProPoint() {
        return proPoint;
    }

    public void setProPoint(String proPoint) {
        this.proPoint = proPoint;
    }

    public String getProItem() {
        return proItem;
    }

    public void setProItem(String proItem) {
        this.proItem = proItem;
    }

    public String getProItemDegree() {
        return proItemDegree;
    }

    public void setProItemDegree(String proItemDegree) {
        this.proItemDegree = proItemDegree;
    }

    public String getProDescribe() {
        return proDescribe;
    }

    public void setProDescribe(String proDescribe) {
        this.proDescribe = proDescribe;
    }

    public String getProAnalyse() {
        return proAnalyse;
    }

    public void setProAnalyse(String proAnalyse) {
        this.proAnalyse = proAnalyse;
    }

    public String getProaThret() {
        return proaThret;
    }

    public void setProaThret(String proaThret) {
        this.proaThret = proaThret;
    }

    public String getProaThretDegree() {
        return proaThretDegree;
    }

    public void setProaThretDegree(String proaThretDegree) {
        this.proaThretDegree = proaThretDegree;
    }

    public String getProaThretAnalyse() {
        return proaThretAnalyse;
    }

    public void setProaThretAnalyse(String proaThretAnalyse) {
        this.proaThretAnalyse = proaThretAnalyse;
    }

    public String getProaRecommendations() {
        return proaRecommendations;
    }

    public void setProaRecommendations(String proaRecommendations) {
        this.proaRecommendations = proaRecommendations;
    }

    public String getProDev() {
        return proDev;
    }

    public void setProDev(String proDev) {
        this.proDev = proDev;
    }

    public String getProComment() {
        return proComment;
    }

    public void setProComment(String proComment) {
        this.proComment = proComment;
    }
}
