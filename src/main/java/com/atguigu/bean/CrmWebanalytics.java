package com.atguigu.bean;

import java.math.BigDecimal;

public class CrmWebanalytics {
    private Integer webanalyticsId;

    private String webanalyticsChannelname;

    private BigDecimal webanalyticsChannelinvestmoney;
    
    private Integer webanalyticsChannelintousernum;
    
    private Integer webanalyticsChannelintousernewnum;

    private Integer webanalyticsChannelflowlnum;

    private Integer webanalyticsChannelsellnum;

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

    public Integer getWebanalyticsChannelintousernum() {
		return webanalyticsChannelintousernum;
	}

	public void setWebanalyticsChannelintousernum(Integer webanalyticsChannelintousernum) {
		this.webanalyticsChannelintousernum = webanalyticsChannelintousernum;
	}

	public Integer getWebanalyticsChannelintousernewnum() {
		return webanalyticsChannelintousernewnum;
	}

	public void setWebanalyticsChannelintousernewnum(Integer webanalyticsChannelintousernewnum) {
		this.webanalyticsChannelintousernewnum = webanalyticsChannelintousernewnum;
	}

	public Integer getWebanalyticsChannelflowlnum() {
        return webanalyticsChannelflowlnum;
    }

    public void setWebanalyticsChannelflowlnum(Integer webanalyticsChannelflowlnum) {
        this.webanalyticsChannelflowlnum = webanalyticsChannelflowlnum;
    }

    public Integer getWebanalyticsChannelsellnum() {
        return webanalyticsChannelsellnum;
    }

    public void setWebanalyticsChannelsellnum(Integer webanalyticsChannelsellnum) {
        this.webanalyticsChannelsellnum = webanalyticsChannelflowlnum;
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

	public CrmWebanalytics() {
		super();
	}

	public CrmWebanalytics(Integer webanalyticsId, String webanalyticsChannelname,
			BigDecimal webanalyticsChannelinvestmoney, Integer webanalyticsChannelintousernum,
			Integer webanalyticsChannelintousernewnum, Integer webanalyticsChannelflowlnum,
			Integer webanalyticsChannelsellnum, BigDecimal webanalyticsChannelsellmoney, String webanalyticsBrandname,
			String webanalyticsCreatetime, String webanalyticsMotifytime) {
		super();
		this.webanalyticsId = webanalyticsId;
		this.webanalyticsChannelname = webanalyticsChannelname;
		this.webanalyticsChannelinvestmoney = webanalyticsChannelinvestmoney;
		this.webanalyticsChannelintousernum = webanalyticsChannelintousernum;
		this.webanalyticsChannelintousernewnum = webanalyticsChannelintousernewnum;
		this.webanalyticsChannelflowlnum = webanalyticsChannelflowlnum;
		this.webanalyticsChannelsellnum = webanalyticsChannelsellnum;
		this.webanalyticsChannelsellmoney = webanalyticsChannelsellmoney;
		this.webanalyticsBrandname = webanalyticsBrandname;
		this.webanalyticsCreatetime = webanalyticsCreatetime;
		this.webanalyticsMotifytime = webanalyticsMotifytime;
	}

	@Override
	public String toString() {
		return "CrmWebanalytics [webanalyticsId=" + webanalyticsId + ", webanalyticsChannelname="
				+ webanalyticsChannelname + ", webanalyticsChannelinvestmoney=" + webanalyticsChannelinvestmoney
				+ ", webanalyticsChannelintousernum=" + webanalyticsChannelintousernum
				+ ", webanalyticsChannelintousernewnum=" + webanalyticsChannelintousernewnum
				+ ", webanalyticsChannelflowlnum=" + webanalyticsChannelflowlnum + ", webanalyticsChannelsellnum="
				+ webanalyticsChannelsellnum + ", webanalyticsChannelsellmoney=" + webanalyticsChannelsellmoney
				+ ", webanalyticsBrandname=" + webanalyticsBrandname + ", webanalyticsCreatetime="
				+ webanalyticsCreatetime + ", webanalyticsMotifytime=" + webanalyticsMotifytime + "]";
	}
}