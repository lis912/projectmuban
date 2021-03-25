package com.lishichang.mubanentity;

// 方案中漏扫主机清单
public class ScanHost {
    private int index;
    private String hostName;
    private String osName;       // OS版本

    public ScanHost(int index, String hostName, String osName) {
        this.index = index;
        this.hostName = hostName;
        this.osName = osName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }
}
