package com.lishichang.entity;

import java.util.List;

public class Archived {
    private int id;
    private String organName;
    private String platName;
    private String isExport;

    public Archived() {
    }

    public Archived(int id, String organName, String platName,String isExport) {
        this.id = id;
        this.organName = organName;
        this.platName = platName;
        this.isExport =isExport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getIsExport() {
        return isExport;
    }

    public void setIsExport(String isExport) {
        this.isExport = isExport;
    }

    @Override
    public String toString() {
        return organName;
    }
}


