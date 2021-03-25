package com.lishichang.entity;

public class JobEleven {
    private int jId;
    private String jpaltName;
    private String jName;
    private String jobName;
    private String jphone;

    public JobEleven(String jpaltName, String jName, String jobName, String jphone) {
        this.jpaltName = jpaltName;
        this.jName = jName;
        this.jobName = jobName;
        this.jphone = jphone;
    }

    public int getjId() {
        return jId;
    }

    public void setjId(int jId) {
        this.jId = jId;
    }

    public String getJpaltName() {
        return jpaltName;
    }

    public void setJpaltName(String jpaltName) {
        this.jpaltName = jpaltName;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJphone() {
        return jphone;
    }

    public void setJphone(String jphone) {
        this.jphone = jphone;
    }
}
