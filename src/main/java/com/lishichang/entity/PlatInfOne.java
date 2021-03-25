package com.lishichang.entity;

public class PlatInfOne {
    private int pid;
    public static String platName = "信息系统";       // 系统名称
    private String protectClass;   // 保护等级
    private String number;         // 备案编号
    private String describe;      // 系统描述
    private String organName;   // 单位名称
    private String organAddr;    // 单位地址
    private String postNum;      //  邮箱编码
    private String principal;   // 负责人姓名
    private String department;   // 所属部门
    private String job;         // 岗位
    private String telNum;     // 座机
    private String phoneNum;   // 手机
    private String mail;      // 邮箱

    public PlatInfOne(String platName, String protectClass, String number, String describe, String organName, String organAddr, String postNum, String principal,String department, String job,String telNum,String phoneNum,String mail) {
        this.platName = platName;
        this.protectClass = protectClass;
        this.number = number;
        this.describe = describe;
        this.organName = organName;
        this.organAddr = organAddr;
        this.postNum = postNum;
        this.principal = principal;
        this.department = department;
        this.job = job;
        this.telNum = telNum;
        this.phoneNum = phoneNum;
        this.mail = mail;
    }



    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getProtectClass() {
        return protectClass;
    }

    public void setProtectClass(String protectClass) {
        this.protectClass = protectClass;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOrganAddr() {
        return organAddr;
    }

    public void setOrganAddr(String organAddr) {
        this.organAddr = organAddr;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
