package com.lishichang.entity;


// 机房数据库实体类
public class PsychzInfTwo {
    private  int PsychzId;
    private String PpaltName; // 平台名称
    private String PsychzName; // 物理机房名称
    private String PsychzAddr; // 位置
    private String PsychzDegree;  //重要程度
    private String PisSample;     // 是否抽选

    public PsychzInfTwo(String ppaltName, String psychzName, String psychzAddr, String psychzDegree, String pisSample) {
        PpaltName = ppaltName;
        PsychzName = psychzName;
        PsychzAddr = psychzAddr;
        PsychzDegree = psychzDegree;
        PisSample = pisSample;
    }


    public String getPsychzName() {
        return PsychzName;
    }

    public void setPsychzName(String psychzName) {
        PsychzName = psychzName;
    }

    public String getPsychzAddr() {
        return PsychzAddr;
    }

    public void setPsychzAddr(String psychzAddr) {
        PsychzAddr = psychzAddr;
    }

    public String getPsychzDegree() {
        return PsychzDegree;
    }

    public void setPsychzDegree(String psychzDegree) {
        PsychzDegree = psychzDegree;
    }

    public String getPisSample() {
        return PisSample;
    }

    public void setPisSample(String pisSample) {
        PisSample = pisSample;
    }

    public String getPpaltName() {
        return PpaltName;
    }

    public void setPpaltName(String ppaltName) {
        PpaltName = ppaltName;
    }

    public int getPsychzId() {
        return PsychzId;
    }

    public void setPsychzId(int psychzId) {
        PsychzId = psychzId;
    }
}
