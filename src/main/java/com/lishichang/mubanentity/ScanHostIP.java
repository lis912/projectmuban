package com.lishichang.mubanentity;

public class ScanHostIP extends ScanHost{
    private String ipAddr;

    public ScanHostIP(int index, String hostName, String osName, String ipAddr) {
        super(index, hostName, osName);
        this.ipAddr = ipAddr;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
}
