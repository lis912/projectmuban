package com.lishichang.entity;

import java.util.Date;

public class HostInfSix {
    //    public static final int MALE = 1;
    private int Hostid;
    private String FplatName;
    private String hostName;         // 设备名称
    private String appSystemName;   // 应用平台
    private String isVMhost;     // 是否虚拟机
    private String area;         // 网络区域
    private String osName;       // OS版本
    private String dataOSname;   // 数据库版本
    private String bitName;      // 中间件版本
    private String amount;       // 数量
    private String ipAddr;       // IP地址
    private String hostDegree;   // 重要程度  这个要做判断转换
    private String isSample;     // 是否抽选

    public HostInfSix(int hostid, String FplatName, String hostName, String appSystemName, String isVMhost, String area, String osName, String dataOSname, String bitName, String amount, String ipAddr, String hostDegree, String isSample) {
        this.Hostid = hostid;
        this.FplatName = FplatName;
        this.hostName = hostName;
        this.appSystemName = appSystemName;
        this.isVMhost = isVMhost;
        this.area = area;
        this.osName = osName;
        this.dataOSname = dataOSname;
        this.bitName = bitName;
        this.amount = amount;
        this.ipAddr = ipAddr;
        this.hostDegree = hostDegree;
        this.isSample = isSample;
    }


    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getAppSystemName() {
        return appSystemName;
    }

    public void setAppSystemName(String appSystemName) {
        this.appSystemName = appSystemName;
    }

    public String getIsVMhost() {
        return isVMhost;
    }

    public void setIsVMhost(String isVMhost) {
        this.isVMhost = isVMhost;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String geOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getDataOSname() {
        return dataOSname;
    }

    public void setDataOSname(String dataOSname) {
        this.dataOSname = dataOSname;
    }


    public String getBitName() {
        return bitName;
    }

    public void setBitName(String bitName) {
        this.bitName = bitName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getHostDegree() {
        return hostDegree;
    }

    public void setHostDegreer(String hostDegree) {
        this.hostDegree = hostDegree;
    }

    public String getIsSample() {
        return isSample;
    }

    public void setIpsSample(String isSample) {
        this.isSample = isSample;
    }




    public int getHostid() {
        return Hostid;
    }

    public void setHostid(int hostid) {
        Hostid = hostid;
    }

    public String getFplatName() {
        return FplatName;
    }

    public void setFplatName(String fplatName) {
        FplatName = fplatName;
    }
}
