package com.atguigu.bean;

import java.math.BigDecimal;

public class MarketSensationInfo {
	
    private Integer sensationinfoId;

    private String sensationinfoName;

    private String sensationinfoAccount;

    private Integer sensationinfoSalesmenid;

    private String sensationinfoSalesmenname;

    private Integer sensationinfoShoproomid;

    private String sensationinfoShoproomname;

    private String sensationinfoPlatform;

    private BigDecimal sensationinfoPrice;

    private Integer sensationinfoSalesnum;

    private BigDecimal sensationinfoOutputprice;

    private Integer sensationinfoFlowlnum;

    private String sensationinfoCreatetime;

    private String sensationinfoUpdatetime;

    public Integer getSensationinfoId() {
        return sensationinfoId;
    }

    public void setSensationinfoId(Integer sensationinfoId) {
        this.sensationinfoId = sensationinfoId;
    }

    public String getSensationinfoName() {
        return sensationinfoName;
    }

    public void setSensationinfoName(String sensationinfoName) {
        this.sensationinfoName = sensationinfoName == null ? null : sensationinfoName.trim();
    }

    public String getSensationinfoAccount() {
        return sensationinfoAccount;
    }

    public void setSensationinfoAccount(String sensationinfoAccount) {
        this.sensationinfoAccount = sensationinfoAccount == null ? null : sensationinfoAccount.trim();
    }

    public Integer getSensationinfoSalesmenid() {
        return sensationinfoSalesmenid;
    }

    public void setSensationinfoSalesmenid(Integer sensationinfoSalesmenid) {
        this.sensationinfoSalesmenid = sensationinfoSalesmenid;
    }

    public String getSensationinfoSalesmenname() {
        return sensationinfoSalesmenname;
    }

    public void setSensationinfoSalesmenname(String sensationinfoSalesmenname) {
        this.sensationinfoSalesmenname = sensationinfoSalesmenname == null ? null : sensationinfoSalesmenname.trim();
    }

    public Integer getSensationinfoShoproomid() {
        return sensationinfoShoproomid;
    }

    public void setSensationinfoShoproomid(Integer sensationinfoShoproomid) {
        this.sensationinfoShoproomid = sensationinfoShoproomid;
    }

    public String getSensationinfoShoproomname() {
        return sensationinfoShoproomname;
    }

    public void setSensationinfoShoproomname(String sensationinfoShoproomname) {
        this.sensationinfoShoproomname = sensationinfoShoproomname;
    }

    public String getSensationinfoPlatform() {
        return sensationinfoPlatform;
    }

    public void setSensationinfoPlatform(String sensationinfoPlatform) {
        this.sensationinfoPlatform = sensationinfoPlatform == null ? null : sensationinfoPlatform.trim();
    }

    public BigDecimal getSensationinfoPrice() {
        return sensationinfoPrice;
    }

    public void setSensationinfoPrice(BigDecimal sensationinfoPrice) {
        this.sensationinfoPrice = sensationinfoPrice;
    }

    public Integer getSensationinfoSalesnum() {
        return sensationinfoSalesnum;
    }

    public void setSensationinfoSalesnum(Integer sensationinfoSalesnum) {
        this.sensationinfoSalesnum = sensationinfoSalesnum;
    }

    public BigDecimal getSensationinfoOutputprice() {
        return sensationinfoOutputprice;
    }

    public void setSensationinfoOutputprice(BigDecimal sensationinfoOutputprice) {
        this.sensationinfoOutputprice = sensationinfoOutputprice;
    }

    public Integer getSensationinfoFlowlnum() {
        return sensationinfoFlowlnum;
    }

    public void setSensationinfoFlowlnum(Integer sensationinfoFlowlnum) {
        this.sensationinfoFlowlnum = sensationinfoFlowlnum;
    }

    public String getSensationinfoCreatetime() {
        return sensationinfoCreatetime;
    }

    public void setSensationinfoCreatetime(String sensationinfoCreatetime) {
        this.sensationinfoCreatetime = sensationinfoCreatetime == null ? null : sensationinfoCreatetime.trim();
    }

    public String getSensationinfoUpdatetime() {
        return sensationinfoUpdatetime;
    }

    public void setSensationinfoUpdatetime(String sensationinfoUpdatetime) {
        this.sensationinfoUpdatetime = sensationinfoUpdatetime == null ? null : sensationinfoUpdatetime.trim();
    }

	public MarketSensationInfo() {
		super();
	}

	public MarketSensationInfo(Integer sensationinfoId, String sensationinfoName, String sensationinfoAccount,
			Integer sensationinfoSalesmenid, String sensationinfoSalesmenname, Integer sensationinfoShoproomid,
			String sensationinfoShoproomname, String sensationinfoPlatform, BigDecimal sensationinfoPrice,
			Integer sensationinfoSalesnum, BigDecimal sensationinfoOutputprice, Integer sensationinfoFlowlnum,
			String sensationinfoCreatetime, String sensationinfoUpdatetime) {
		super();
		this.sensationinfoId = sensationinfoId;
		this.sensationinfoName = sensationinfoName;
		this.sensationinfoAccount = sensationinfoAccount;
		this.sensationinfoSalesmenid = sensationinfoSalesmenid;
		this.sensationinfoSalesmenname = sensationinfoSalesmenname;
		this.sensationinfoShoproomid = sensationinfoShoproomid;
		this.sensationinfoShoproomname = sensationinfoShoproomname;
		this.sensationinfoPlatform = sensationinfoPlatform;
		this.sensationinfoPrice = sensationinfoPrice;
		this.sensationinfoSalesnum = sensationinfoSalesnum;
		this.sensationinfoOutputprice = sensationinfoOutputprice;
		this.sensationinfoFlowlnum = sensationinfoFlowlnum;
		this.sensationinfoCreatetime = sensationinfoCreatetime;
		this.sensationinfoUpdatetime = sensationinfoUpdatetime;
	}

	@Override
	public String toString() {
		return "MarketSensationInfo [sensationinfoId=" + sensationinfoId + ", sensationinfoName=" + sensationinfoName
				+ ", sensationinfoAccount=" + sensationinfoAccount + ", sensationinfoSalesmenid="
				+ sensationinfoSalesmenid + ", sensationinfoSalesmenname=" + sensationinfoSalesmenname
				+ ", sensationinfoShoproomid=" + sensationinfoShoproomid + ", sensationinfoShoproomname="
				+ sensationinfoShoproomname + ", sensationinfoPlatform=" + sensationinfoPlatform
				+ ", sensationinfoPrice=" + sensationinfoPrice + ", sensationinfoSalesnum=" + sensationinfoSalesnum
				+ ", sensationinfoOutputprice=" + sensationinfoOutputprice + ", sensationinfoFlowlnum="
				+ sensationinfoFlowlnum + ", sensationinfoCreatetime=" + sensationinfoCreatetime
				+ ", sensationinfoUpdatetime=" + sensationinfoUpdatetime + "]";
	}
}