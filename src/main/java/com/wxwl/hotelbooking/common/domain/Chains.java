package com.wxwl.hotelbooking.common.domain;

public class Chains {
    private String chainid;

    private String chainname;

    public String getChainid() {
        return chainid;
    }

    public void setChainid(String chainid) {
        this.chainid = chainid == null ? null : chainid.trim();
    }

    public String getChainname() {
        return chainname;
    }

    public void setChainname(String chainname) {
        this.chainname = chainname == null ? null : chainname.trim();
    }
}