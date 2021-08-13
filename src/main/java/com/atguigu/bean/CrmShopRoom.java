package com.atguigu.bean;

public class CrmShopRoom {
    private Integer shoproomId;

    private String shoproomName;

    private String shoproomCreatetime;

    private String shoproomMotifytime;

    public Integer getShoproomId() {
        return shoproomId;
    }

    public void setShoproomId(Integer shoproomId) {
        this.shoproomId = shoproomId;
    }

    public String getShoproomName() {
        return shoproomName;
    }

    public void setShoproomName(String shoproomName) {
        this.shoproomName = shoproomName == null ? null : shoproomName.trim();
    }

    public String getShoproomCreatetime() {
        return shoproomCreatetime;
    }

    public void setShoproomCreatetime(String shoproomCreatetime) {
        this.shoproomCreatetime = shoproomCreatetime == null ? null : shoproomCreatetime.trim();
    }

    public String getShoproomMotifytime() {
        return shoproomMotifytime;
    }

    public void setShoproomMotifytime(String shoproomMotifytime) {
        this.shoproomMotifytime = shoproomMotifytime == null ? null : shoproomMotifytime.trim();
    }
}