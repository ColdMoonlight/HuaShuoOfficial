package com.atguigu.bean;

import java.math.BigDecimal;

public class CrmProductSellInfo {
    private Integer productsellinfoId;
    
    private String productsellinfoPlatformName;

    private String productsellinfoBrandname;

    private String productsellinfoPlatenum;

    private String productsellinfoProducttype;

    private Integer productsellinfoProductid;

    private String productsellinfoProductname;

    private String productsellinfoProductsku;

    private BigDecimal productsellinfoProductmarkprice;

    private BigDecimal productsellinfoProductrealprice;

    private Integer productsellinfoProductsellnum;

    private BigDecimal productsellinfoCouponprice;

    private String productsellinfoCouponcode;

    private String productsellinfoProductselltime;

    private String productsellinfoMotifytime;

    public Integer getProductsellinfoId() {
        return productsellinfoId;
    }

    public void setProductsellinfoId(Integer productsellinfoId) {
        this.productsellinfoId = productsellinfoId;
    }

	public String getProductsellinfoPlatformName() {
		return productsellinfoPlatformName;
	}

	public void setProductsellinfoPlatformName(String productsellinfoPlatformName) {
		this.productsellinfoPlatformName = productsellinfoPlatformName;
	}
    public String getProductsellinfoBrandname() {
        return productsellinfoBrandname;
    }

    public void setProductsellinfoBrandname(String productsellinfoBrandname) {
        this.productsellinfoBrandname = productsellinfoBrandname == null ? null : productsellinfoBrandname.trim();
    }

    public String getProductsellinfoPlatenum() {
        return productsellinfoPlatenum;
    }

    public void setProductsellinfoPlatenum(String productsellinfoPlatenum) {
        this.productsellinfoPlatenum = productsellinfoPlatenum == null ? null : productsellinfoPlatenum.trim();
    }

    public String getProductsellinfoProducttype() {
        return productsellinfoProducttype;
    }

    public void setProductsellinfoProducttype(String productsellinfoProducttype) {
        this.productsellinfoProducttype = productsellinfoProducttype == null ? null : productsellinfoProducttype.trim();
    }

    public Integer getProductsellinfoProductid() {
        return productsellinfoProductid;
    }

    public void setProductsellinfoProductid(Integer productsellinfoProductid) {
        this.productsellinfoProductid = productsellinfoProductid;
    }

    public String getProductsellinfoProductname() {
        return productsellinfoProductname;
    }

    public void setProductsellinfoProductname(String productsellinfoProductname) {
        this.productsellinfoProductname = productsellinfoProductname == null ? null : productsellinfoProductname.trim();
    }

    public String getProductsellinfoProductsku() {
        return productsellinfoProductsku;
    }

    public void setProductsellinfoProductsku(String productsellinfoProductsku) {
        this.productsellinfoProductsku = productsellinfoProductsku == null ? null : productsellinfoProductsku.trim();
    }

    public BigDecimal getProductsellinfoProductmarkprice() {
        return productsellinfoProductmarkprice;
    }

    public void setProductsellinfoProductmarkprice(BigDecimal productsellinfoProductmarkprice) {
        this.productsellinfoProductmarkprice = productsellinfoProductmarkprice;
    }

    public BigDecimal getProductsellinfoProductrealprice() {
        return productsellinfoProductrealprice;
    }

    public void setProductsellinfoProductrealprice(BigDecimal productsellinfoProductrealprice) {
        this.productsellinfoProductrealprice = productsellinfoProductrealprice;
    }

    public Integer getProductsellinfoProductsellnum() {
        return productsellinfoProductsellnum;
    }

    public void setProductsellinfoProductsellnum(Integer productsellinfoProductsellnum) {
        this.productsellinfoProductsellnum = productsellinfoProductsellnum;
    }

    public BigDecimal getProductsellinfoCouponprice() {
        return productsellinfoCouponprice;
    }

    public void setProductsellinfoCouponprice(BigDecimal productsellinfoCouponprice) {
        this.productsellinfoCouponprice = productsellinfoCouponprice;
    }

    public String getProductsellinfoCouponcode() {
        return productsellinfoCouponcode;
    }

    public void setProductsellinfoCouponcode(String productsellinfoCouponcode) {
        this.productsellinfoCouponcode = productsellinfoCouponcode == null ? null : productsellinfoCouponcode.trim();
    }

    public String getProductsellinfoProductselltime() {
        return productsellinfoProductselltime;
    }

    public void setProductsellinfoProductselltime(String productsellinfoProductselltime) {
        this.productsellinfoProductselltime = productsellinfoProductselltime == null ? null : productsellinfoProductselltime.trim();
    }

    public String getProductsellinfoMotifytime() {
        return productsellinfoMotifytime;
    }

    public void setProductsellinfoMotifytime(String productsellinfoMotifytime) {
        this.productsellinfoMotifytime = productsellinfoMotifytime == null ? null : productsellinfoMotifytime.trim();
    }

	public CrmProductSellInfo() {
		super();
	}

	public CrmProductSellInfo(Integer productsellinfoId, String productsellinfoPlatformName,
			String productsellinfoBrandname, String productsellinfoPlatenum, String productsellinfoProducttype,
			Integer productsellinfoProductid, String productsellinfoProductname, String productsellinfoProductsku,
			BigDecimal productsellinfoProductmarkprice, BigDecimal productsellinfoProductrealprice,
			Integer productsellinfoProductsellnum, BigDecimal productsellinfoCouponprice,
			String productsellinfoCouponcode, String productsellinfoProductselltime, String productsellinfoMotifytime) {
		super();
		this.productsellinfoId = productsellinfoId;
		this.productsellinfoPlatformName = productsellinfoPlatformName;
		this.productsellinfoBrandname = productsellinfoBrandname;
		this.productsellinfoPlatenum = productsellinfoPlatenum;
		this.productsellinfoProducttype = productsellinfoProducttype;
		this.productsellinfoProductid = productsellinfoProductid;
		this.productsellinfoProductname = productsellinfoProductname;
		this.productsellinfoProductsku = productsellinfoProductsku;
		this.productsellinfoProductmarkprice = productsellinfoProductmarkprice;
		this.productsellinfoProductrealprice = productsellinfoProductrealprice;
		this.productsellinfoProductsellnum = productsellinfoProductsellnum;
		this.productsellinfoCouponprice = productsellinfoCouponprice;
		this.productsellinfoCouponcode = productsellinfoCouponcode;
		this.productsellinfoProductselltime = productsellinfoProductselltime;
		this.productsellinfoMotifytime = productsellinfoMotifytime;
	}

	@Override
	public String toString() {
		return "CrmProductSellInfo [productsellinfoId=" + productsellinfoId + ", productsellinfoPlatformName="
				+ productsellinfoPlatformName + ", productsellinfoBrandname=" + productsellinfoBrandname
				+ ", productsellinfoPlatenum=" + productsellinfoPlatenum + ", productsellinfoProducttype="
				+ productsellinfoProducttype + ", productsellinfoProductid=" + productsellinfoProductid
				+ ", productsellinfoProductname=" + productsellinfoProductname + ", productsellinfoProductsku="
				+ productsellinfoProductsku + ", productsellinfoProductmarkprice=" + productsellinfoProductmarkprice
				+ ", productsellinfoProductrealprice=" + productsellinfoProductrealprice
				+ ", productsellinfoProductsellnum=" + productsellinfoProductsellnum + ", productsellinfoCouponprice="
				+ productsellinfoCouponprice + ", productsellinfoCouponcode=" + productsellinfoCouponcode
				+ ", productsellinfoProductselltime=" + productsellinfoProductselltime + ", productsellinfoMotifytime="
				+ productsellinfoMotifytime + "]";
	}

}