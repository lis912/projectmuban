package com.lishichang.mubanentity;

public class SafeManageCenter {
    private String SafeDescribe;      // 问题描述;

    public SafeManageCenter(String safeDescribe) {
        SafeDescribe = safeDescribe;
    }

    public String getSafeDescribe() {
        return SafeDescribe;
    }

    public void setSafeDescribe(String safeDescribe) {
        SafeDescribe = safeDescribe;
    }
}
