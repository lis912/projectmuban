package com.lishichang.entity;

public class AppInfNine {

    //序号	业务应用系统/平台名称	主要功能	业务应用软件及版本	开发厂商	"业务系统类型
    //B/S或C/S或APP"	业务应用访问连接地址	重要程度	是否抽选
    private int aid;
    private String aplatName;
    private String appName;
    private String aFunction;
    private String aVersion;
    private String aDevelopName;
    private String architecture;
    private String aurl;
    private String aDegree;
    private String aisSample;

    public AppInfNine(String aplatName, String appName, String aFunction, String aVersion, String aDevelopName, String architecture, String aurl, String aDegree, String aisSample) {
        this.aplatName = aplatName;
        this.appName = appName;
        this.aFunction = aFunction;
        this.aVersion = aVersion;
        this.aDevelopName = aDevelopName;
        this.architecture = architecture;
        this.aurl = aurl;
        this.aDegree = aDegree;
        this.aisSample = aisSample;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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



    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }


    public String getaDegree() {
        return aDegree;
    }

    public void setaDegree(String aDegree) {
        this.aDegree = aDegree;
    }

    public String getAisSample() {
        return aisSample;
    }

    public void setAisSample(String aisSample) {
        this.aisSample = aisSample;
    }
}
