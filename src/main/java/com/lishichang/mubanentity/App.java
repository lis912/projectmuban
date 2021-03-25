package com.lishichang.mubanentity;

/**
 * 应用类 App
 *
 */
public class App {
    // 序号	所属定级系统	业务应用系统/平台名称	主要功能	业务应用软件及版本	开发厂商	重要程度
    private int aindex;
    private String aplatName;
    private String appName;
    private String aFunction;
    private String aVersion;
    private String aDevelopName;
    private String aDegree;


    public App(int aindex, String aplatName, String appName, String aFunction, String aVersion, String aDevelopName, String aDegree) {
        this.aindex = aindex;
        this.aplatName = aplatName;
        this.appName = appName;
        this.aFunction = aFunction;
        this.aVersion = aVersion;
        this.aDevelopName = aDevelopName;
        this.aDegree = aDegree;

    }

    public int getAindex() {
        return aindex;
    }

    public void setAindex(int aindex) {
        this.aindex = aindex;
    }

    public String getAplatName() {
        return aplatName;
    }

    public void setAplatName(String aplatName) {
        this.aplatName = aplatName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getaFunction() {
        return aFunction;
    }

    public void setaFunction(String aFunction) {
        this.aFunction = aFunction;
    }

    public String getaVersion() {
        return aVersion;
    }

    public void setaVersion(String aVersion) {
        this.aVersion = aVersion;
    }

    public String getaDevelopName() {
        return aDevelopName;
    }

    public void setaDevelopName(String aDevelopName) {
        this.aDevelopName = aDevelopName;
    }

    public String getaDegree() {
        return aDegree;
    }

    public void setaDegree(String aDegree) {
        this.aDegree = aDegree;
    }


}
