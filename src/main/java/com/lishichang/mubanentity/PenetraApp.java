package com.lishichang.mubanentity;

public class PenetraApp {
    private int aindex;
    private String appName;
    private String architecture;

    public PenetraApp(int aindex, String appName, String architecture) {
        this.aindex = aindex;
        this.appName = appName;
        this.architecture = architecture;
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

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }
}
