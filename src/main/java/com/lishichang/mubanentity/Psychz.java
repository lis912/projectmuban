package com.lishichang.mubanentity;

public class Psychz {
    private int index;
    private String PsychzName;
    private String PsychzAddr;
    private String PsychzDegree;

    public Psychz(int index, String psychzName, String psychzAddr, String psychzDegree) {
        this.index = index;
        this.PsychzName = psychzName;
        this.PsychzAddr = psychzAddr;
        this.PsychzDegree = psychzDegree;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
}
