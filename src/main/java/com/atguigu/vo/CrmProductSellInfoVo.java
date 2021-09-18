package com.atguigu.vo;

import java.math.BigDecimal;

public class CrmProductSellInfoVo {
	
	private Integer productsellinfoId;
    
    private String productsellinfoPlatformName;

    private String productsellinfoBrandname;

    private String productsellinfoProductsku;

    private BigDecimal productsellinfoProductrealprice;

    private Integer productsellinfoProductsellnum;

    private String productsellinfoProductselltime;

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
		this.productsellinfoBrandname = productsellinfoBrandname;
	}

	public String getProductsellinfoProductsku() {
		return productsellinfoProductsku;
	}

	public void setProductsellinfoProductsku(String productsellinfoProductsku) {
		this.productsellinfoProductsku = productsellinfoProductsku;
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

	public String getProductsellinfoProductselltime() {
		return productsellinfoProductselltime;
	}

	public void setProductsellinfoProductselltime(String productsellinfoProductselltime) {
		this.productsellinfoProductselltime = productsellinfoProductselltime;
	}

	public CrmProductSellInfoVo() {
		super();
	}

	public CrmProductSellInfoVo(Integer productsellinfoId, String productsellinfoPlatformName,
			String productsellinfoBrandname, String productsellinfoProductsku,
			BigDecimal productsellinfoProductrealprice, Integer productsellinfoProductsellnum,
			String productsellinfoProductselltime) {
		super();
		this.productsellinfoId = productsellinfoId;
		this.productsellinfoPlatformName = productsellinfoPlatformName;
		this.productsellinfoBrandname = productsellinfoBrandname;
		this.productsellinfoProductsku = productsellinfoProductsku;
		this.productsellinfoProductrealprice = productsellinfoProductrealprice;
		this.productsellinfoProductsellnum = productsellinfoProductsellnum;
		this.productsellinfoProductselltime = productsellinfoProductselltime;
	}

	@Override
	public String toString() {
		return "CrmProductSellInfoVo [productsellinfoId=" + productsellinfoId + ", productsellinfoPlatformName="
				+ productsellinfoPlatformName + ", productsellinfoBrandname=" + productsellinfoBrandname
				+ ", productsellinfoProductsku=" + productsellinfoProductsku + ", productsellinfoProductrealprice="
				+ productsellinfoProductrealprice + ", productsellinfoProductsellnum=" + productsellinfoProductsellnum
				+ ", productsellinfoProductselltime=" + productsellinfoProductselltime + "]";
	}

}
