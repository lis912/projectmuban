package com.lishichang.mubanentity;

public class NewPro {
    private String organName;   // 单位名称
    private String platName;       // 系统名称

    public NewPro(String organName, String platName) {
        this.platName = platName;
        this.organName = organName;
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
}
