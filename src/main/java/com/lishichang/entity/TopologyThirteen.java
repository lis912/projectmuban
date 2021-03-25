package com.lishichang.entity;

public class TopologyThirteen {
    private int tpid;
    private String tpaltName;  // 系统名称
    private String tPathName;   // 图片相对路径
    private String tNetworkDescription;  // 网络拓扑描述

    public TopologyThirteen(String tpaltName, String tPathName, String tNetworkDescription) {
        this.tpaltName = tpaltName;
        this.tPathName = tPathName;
        this.tNetworkDescription = tNetworkDescription;
    }

    public int getTpid() {
        return tpid;
    }

    public void setTpid(int tpid) {
        this.tpid = tpid;
    }

    public String getTpaltName() {
        return tpaltName;
    }

    public void setTpaltName(String tpaltName) {
        this.tpaltName = tpaltName;
    }

    public String gettPathName() {
        return tPathName;
    }

    public void settPathName(String tPathName) {
        this.tPathName = tPathName;
    }

    public String gettNetworkDescription() {
        return tNetworkDescription;
    }

    public void settNetworkDescription(String tNetworkDescription) {
        this.tNetworkDescription = tNetworkDescription;
    }
}
