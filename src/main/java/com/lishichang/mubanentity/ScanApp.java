package com.lishichang.mubanentity;

public class ScanApp {
    private int aindex;
    private String appName;
    private String aurl;

    public ScanApp(int aindex, String appName, String aurl) {
        this.aindex = aindex;
        this.appName = appName;
        this.aurl = aurl;
    }

    public int getAindex() {
        return aindex;
    }

    public void setAindex(int aindex) {
        this.aindex = aindex;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }
}
