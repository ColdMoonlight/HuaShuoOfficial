package com.atguigu.bean;

public class CrmCatalog {
    private Integer catalogId;

    private String catalogName;

    private Integer catalogParentId;

    private String catalogParentName;

    private String catalogDesc;

    private Integer catalogStatus;

    private Integer catalogFirthNum;

    private String catalogUrl;

    private String catalogCreatetime;

    private String catalogMotifytime;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public Integer getCatalogParentId() {
        return catalogParentId;
    }

    public void setCatalogParentId(Integer catalogParentId) {
        this.catalogParentId = catalogParentId;
    }

    public String getCatalogParentName() {
        return catalogParentName;
    }

    public void setCatalogParentName(String catalogParentName) {
        this.catalogParentName = catalogParentName == null ? null : catalogParentName.trim();
    }

    public String getCatalogDesc() {
        return catalogDesc;
    }

    public void setCatalogDesc(String catalogDesc) {
        this.catalogDesc = catalogDesc == null ? null : catalogDesc.trim();
    }

    public Integer getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Integer catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public Integer getCatalogFirthNum() {
        return catalogFirthNum;
    }

    public void setCatalogFirthNum(Integer catalogFirthNum) {
        this.catalogFirthNum = catalogFirthNum;
    }

    public String getCatalogUrl() {
        return catalogUrl;
    }

    public void setCatalogUrl(String catalogUrl) {
        this.catalogUrl = catalogUrl == null ? null : catalogUrl.trim();
    }

    public String getCatalogCreatetime() {
        return catalogCreatetime;
    }

    public void setCatalogCreatetime(String catalogCreatetime) {
        this.catalogCreatetime = catalogCreatetime == null ? null : catalogCreatetime.trim();
    }

    public String getCatalogMotifytime() {
        return catalogMotifytime;
    }

    public void setCatalogMotifytime(String catalogMotifytime) {
        this.catalogMotifytime = catalogMotifytime == null ? null : catalogMotifytime.trim();
    }

	public CrmCatalog() {
		super();
	}

	public CrmCatalog(Integer catalogId, String catalogName, Integer catalogParentId, String catalogParentName,
			String catalogDesc, Integer catalogStatus, Integer catalogFirthNum, String catalogUrl,
			String catalogCreatetime, String catalogMotifytime) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.catalogParentId = catalogParentId;
		this.catalogParentName = catalogParentName;
		this.catalogDesc = catalogDesc;
		this.catalogStatus = catalogStatus;
		this.catalogFirthNum = catalogFirthNum;
		this.catalogUrl = catalogUrl;
		this.catalogCreatetime = catalogCreatetime;
		this.catalogMotifytime = catalogMotifytime;
	}

	@Override
	public String toString() {
		return "CrmCatalog [catalogId=" + catalogId + ", catalogName=" + catalogName + ", catalogParentId="
				+ catalogParentId + ", catalogParentName=" + catalogParentName + ", catalogDesc=" + catalogDesc
				+ ", catalogStatus=" + catalogStatus + ", catalogFirthNum=" + catalogFirthNum + ", catalogUrl="
				+ catalogUrl + ", catalogCreatetime=" + catalogCreatetime + ", catalogMotifytime=" + catalogMotifytime
				+ "]";
	}
}