package com.lishichang.mubanentity;


/**
 * 安全管理人员 Job
 *
 */
public class Job {
    private int jindex;
    private String jpaltName;
    private String jName;
    private String jobName;
    private String jphone;

    public Job(int jindex, String jName, String jobName, String jphone) {
        this.jindex = jindex;
        this.jName = jName;
        this.jobName = jobName;
        this.jphone = jphone;
    }

    public int getJindex() {
        return jindex;
    }

    public void setJindex(int jindex) {
        this.jindex = jindex;
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
