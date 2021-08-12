package com.atguigu.bean;

import java.math.BigDecimal;

public class CrmWebanalytics {
    private Integer webanalyticsId;

    private String webanalyticsChannelname;

    private BigDecimal webanalyticsChannelinvestmoney;

    private Integer webanalyticsChannelflowlnum;

    private String webanalyticsChannelsellnum;

    private BigDecimal webanalyticsChannelsellmoney;

    private String webanalyticsBrandname;

    private String webanalyticsCreatetime;

    private String webanalyticsMotifytime;

    public Integer getWebanalyticsId() {
        return webanalyticsId;
    }

    public void setWebanalyticsId(Integer webanalyticsId) {
        this.webanalyticsId = webanalyticsId;
    }

    public String getWebanalyticsChannelname() {
        return webanalyticsChannelname;
    }

    public void setWebanalyticsChannelname(String webanalyticsChannelname) {
        this.webanalyticsChannelname = webanalyticsChannelname == null ? null : webanalyticsChannelname.trim();
    }

    public BigDecimal getWebanalyticsChannelinvestmoney() {
        return webanalyticsChannelinvestmoney;
    }

    public void setWebanalyticsChannelinvestmoney(BigDecimal webanalyticsChannelinvestmoney) {
        this.webanalyticsChannelinvestmoney = webanalyticsChannelinvestmoney;
    }

    public Integer getWebanalyticsChannelflowlnum() {
        return webanalyticsChannelflowlnum;
    }

    public void setWebanalyticsChannelflowlnum(Integer webanalyticsChannelflowlnum) {
        this.webanalyticsChannelflowlnum = webanalyticsChannelflowlnum;
    }

    public String getWebanalyticsChannelsellnum() {
        return webanalyticsChannelsellnum;
    }

    public void setWebanalyticsChannelsellnum(String webanalyticsChannelsellnum) {
        this.webanalyticsChannelsellnum = webanalyticsChannelsellnum == null ? null : webanalyticsChannelsellnum.trim();
    }

    public BigDecimal getWebanalyticsChannelsellmoney() {
        return webanalyticsChannelsellmoney;
    }

    public void setWebanalyticsChannelsellmoney(BigDecimal webanalyticsChannelsellmoney) {
        this.webanalyticsChannelsellmoney = webanalyticsChannelsellmoney;
    }

    public String getWebanalyticsBrandname() {
        return webanalyticsBrandname;
    }

    public void setWebanalyticsBrandname(String webanalyticsBrandname) {
        this.webanalyticsBrandname = webanalyticsBrandname == null ? null : webanalyticsBrandname.trim();
    }

    public String getWebanalyticsCreatetime() {
        return webanalyticsCreatetime;
    }

    public void setWebanalyticsCreatetime(String webanalyticsCreatetime) {
        this.webanalyticsCreatetime = webanalyticsCreatetime == null ? null : webanalyticsCreatetime.trim();
    }

    public String getWebanalyticsMotifytime() {
        return webanalyticsMotifytime;
    }

    public void setWebanalyticsMotifytime(String webanalyticsMotifytime) {
        this.webanalyticsMotifytime = webanalyticsMotifytime == null ? null : webanalyticsMotifytime.trim();
    }
}