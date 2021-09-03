package com.atguigu.bean;

import java.math.BigDecimal;

public class MarketSensationDetailOutput {
    private Integer sensationdetailoutputId;

    private String sensationdetailoutputProduct;

    private String sensationdetailoutputOriginallink;

    private String sensationdetailoutputResourcelink;

    private BigDecimal sensationdetailoutputSalesprice;

    private String sensationdetailoutputPlatenum;

    private Integer sensationdetailoutputShoproomid;

    private String sensationdetailoutputShoproomname;

    private Integer sensationdetailoutputSensationinfoid;

    private String sensationdetailoutputSensationinfoname;

    private String sensationdetailoutputCreatetime;

    private String sensationdetailoutputUpdatetime;

    public Integer getSensationdetailoutputId() {
        return sensationdetailoutputId;
    }

    public void setSensationdetailoutputId(Integer sensationdetailoutputId) {
        this.sensationdetailoutputId = sensationdetailoutputId;
    }

    public String getSensationdetailoutputProduct() {
        return sensationdetailoutputProduct;
    }

    public void setSensationdetailoutputProduct(String sensationdetailoutputProduct) {
        this.sensationdetailoutputProduct = sensationdetailoutputProduct == null ? null : sensationdetailoutputProduct.trim();
    }

    public String getSensationdetailoutputOriginallink() {
        return sensationdetailoutputOriginallink;
    }

    public void setSensationdetailoutputOriginallink(String sensationdetailoutputOriginallink) {
        this.sensationdetailoutputOriginallink = sensationdetailoutputOriginallink == null ? null : sensationdetailoutputOriginallink.trim();
    }

    public String getSensationdetailoutputResourcelink() {
        return sensationdetailoutputResourcelink;
    }

    public void setSensationdetailoutputResourcelink(String sensationdetailoutputResourcelink) {
        this.sensationdetailoutputResourcelink = sensationdetailoutputResourcelink == null ? null : sensationdetailoutputResourcelink.trim();
    }

    public BigDecimal getSensationdetailoutputSalesprice() {
        return sensationdetailoutputSalesprice;
    }

    public void setSensationdetailoutputSalesprice(BigDecimal sensationdetailoutputSalesprice) {
        this.sensationdetailoutputSalesprice = sensationdetailoutputSalesprice;
    }

    public String getSensationdetailoutputPlatenum() {
        return sensationdetailoutputPlatenum;
    }

    public void setSensationdetailoutputPlatenum(String sensationdetailoutputPlatenum) {
        this.sensationdetailoutputPlatenum = sensationdetailoutputPlatenum == null ? null : sensationdetailoutputPlatenum.trim();
    }

    public Integer getSensationdetailoutputShoproomid() {
        return sensationdetailoutputShoproomid;
    }

    public void setSensationdetailoutputShoproomid(Integer sensationdetailoutputShoproomid) {
        this.sensationdetailoutputShoproomid = sensationdetailoutputShoproomid;
    }

    public String getSensationdetailoutputShoproomname() {
        return sensationdetailoutputShoproomname;
    }

    public void setSensationdetailoutputShoproomname(String sensationdetailoutputShoproomname) {
        this.sensationdetailoutputShoproomname = sensationdetailoutputShoproomname == null ? null : sensationdetailoutputShoproomname.trim();
    }

    public Integer getSensationdetailoutputSensationinfoid() {
        return sensationdetailoutputSensationinfoid;
    }

    public void setSensationdetailoutputSensationinfoid(Integer sensationdetailoutputSensationinfoid) {
        this.sensationdetailoutputSensationinfoid = sensationdetailoutputSensationinfoid;
    }

    public String getSensationdetailoutputSensationinfoname() {
        return sensationdetailoutputSensationinfoname;
    }

    public void setSensationdetailoutputSensationinfoname(String sensationdetailoutputSensationinfoname) {
        this.sensationdetailoutputSensationinfoname = sensationdetailoutputSensationinfoname == null ? null : sensationdetailoutputSensationinfoname.trim();
    }

    public String getSensationdetailoutputCreatetime() {
        return sensationdetailoutputCreatetime;
    }

    public void setSensationdetailoutputCreatetime(String sensationdetailoutputCreatetime) {
        this.sensationdetailoutputCreatetime = sensationdetailoutputCreatetime == null ? null : sensationdetailoutputCreatetime.trim();
    }

    public String getSensationdetailoutputUpdatetime() {
        return sensationdetailoutputUpdatetime;
    }

    public void setSensationdetailoutputUpdatetime(String sensationdetailoutputUpdatetime) {
        this.sensationdetailoutputUpdatetime = sensationdetailoutputUpdatetime == null ? null : sensationdetailoutputUpdatetime.trim();
    }

	public MarketSensationDetailOutput() {
		super();
	}

	public MarketSensationDetailOutput(Integer sensationdetailoutputId, String sensationdetailoutputProduct,
			String sensationdetailoutputOriginallink, String sensationdetailoutputResourcelink,
			BigDecimal sensationdetailoutputSalesprice, String sensationdetailoutputPlatenum,
			Integer sensationdetailoutputShoproomid, String sensationdetailoutputShoproomname,
			Integer sensationdetailoutputSensationinfoid, String sensationdetailoutputSensationinfoname,
			String sensationdetailoutputCreatetime, String sensationdetailoutputUpdatetime) {
		super();
		this.sensationdetailoutputId = sensationdetailoutputId;
		this.sensationdetailoutputProduct = sensationdetailoutputProduct;
		this.sensationdetailoutputOriginallink = sensationdetailoutputOriginallink;
		this.sensationdetailoutputResourcelink = sensationdetailoutputResourcelink;
		this.sensationdetailoutputSalesprice = sensationdetailoutputSalesprice;
		this.sensationdetailoutputPlatenum = sensationdetailoutputPlatenum;
		this.sensationdetailoutputShoproomid = sensationdetailoutputShoproomid;
		this.sensationdetailoutputShoproomname = sensationdetailoutputShoproomname;
		this.sensationdetailoutputSensationinfoid = sensationdetailoutputSensationinfoid;
		this.sensationdetailoutputSensationinfoname = sensationdetailoutputSensationinfoname;
		this.sensationdetailoutputCreatetime = sensationdetailoutputCreatetime;
		this.sensationdetailoutputUpdatetime = sensationdetailoutputUpdatetime;
	}

	@Override
	public String toString() {
		return "MarketSensationDetailOutput [sensationdetailoutputId=" + sensationdetailoutputId
				+ ", sensationdetailoutputProduct=" + sensationdetailoutputProduct
				+ ", sensationdetailoutputOriginallink=" + sensationdetailoutputOriginallink
				+ ", sensationdetailoutputResourcelink=" + sensationdetailoutputResourcelink
				+ ", sensationdetailoutputSalesprice=" + sensationdetailoutputSalesprice
				+ ", sensationdetailoutputPlatenum=" + sensationdetailoutputPlatenum
				+ ", sensationdetailoutputShoproomid=" + sensationdetailoutputShoproomid
				+ ", sensationdetailoutputShoproomname=" + sensationdetailoutputShoproomname
				+ ", sensationdetailoutputSensationinfoid=" + sensationdetailoutputSensationinfoid
				+ ", sensationdetailoutputSensationinfoname=" + sensationdetailoutputSensationinfoname
				+ ", sensationdetailoutputCreatetime=" + sensationdetailoutputCreatetime
				+ ", sensationdetailoutputUpdatetime=" + sensationdetailoutputUpdatetime + "]";
	}
}