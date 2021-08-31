package com.atguigu.bean;

public class CrmAdmin {
    private Integer adminId;

    private String adminAccount;

    private String adminPassword;

    private String adminName;

    private String adminDepartmentIdStr;

    private String adminDepartmentName;

    private String adminShopIdStr;

    private String adminShopName;

    private Integer adminStatus;

    private String adminMenuIdstr;

    private String adminMenuNamestr;

    private String adminMenuUrlstr;

    private String adminCreatetime;

    private String adminMotifytime;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount == null ? null : adminAccount.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminDepartmentIdStr() {
        return adminDepartmentIdStr;
    }

    public void setAdminDepartmentIdStr(String adminDepartmentIdStr) {
        this.adminDepartmentIdStr = adminDepartmentIdStr;
    }

    public String getAdminDepartmentName() {
        return adminDepartmentName;
    }

    public void setAdminDepartmentName(String adminDepartmentName) {
        this.adminDepartmentName = adminDepartmentName == null ? null : adminDepartmentName.trim();
    }

    public String getAdminShopIdStr() {
        return adminShopIdStr;
    }

    public void setAdminShopIdStr(String adminShopIdStr) {
        this.adminShopIdStr = adminShopIdStr;
    }

    public String getAdminShopName() {
        return adminShopName;
    }

    public void setAdminShopName(String adminShopName) {
        this.adminShopName = adminShopName == null ? null : adminShopName.trim();
    }

    public Integer getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Integer adminStatus) {
        this.adminStatus = adminStatus;
    }

    public String getAdminMenuIdstr() {
        return adminMenuIdstr;
    }

    public void setAdminMenuIdstr(String adminMenuIdstr) {
        this.adminMenuIdstr = adminMenuIdstr == null ? null : adminMenuIdstr.trim();
    }

    public String getAdminMenuNamestr() {
        return adminMenuNamestr;
    }

    public void setAdminMenuNamestr(String adminMenuNamestr) {
        this.adminMenuNamestr = adminMenuNamestr == null ? null : adminMenuNamestr.trim();
    }

    public String getAdminMenuUrlstr() {
        return adminMenuUrlstr;
    }

    public void setAdminMenuUrlstr(String adminMenuUrlstr) {
        this.adminMenuUrlstr = adminMenuUrlstr == null ? null : adminMenuUrlstr.trim();
    }

    public String getAdminCreatetime() {
        return adminCreatetime;
    }

    public void setAdminCreatetime(String adminCreatetime) {
        this.adminCreatetime = adminCreatetime == null ? null : adminCreatetime.trim();
    }

    public String getAdminMotifytime() {
        return adminMotifytime;
    }

    public void setAdminMotifytime(String adminMotifytime) {
        this.adminMotifytime = adminMotifytime == null ? null : adminMotifytime.trim();
    }

	public CrmAdmin() {
		super();
	}

	public CrmAdmin(Integer adminId, String adminAccount, String adminPassword, String adminName,
			String adminDepartmentIdStr, String adminDepartmentName, String adminShopIdStr, String adminShopName,
			Integer adminStatus, String adminMenuIdstr, String adminMenuNamestr, String adminMenuUrlstr,
			String adminCreatetime, String adminMotifytime) {
		super();
		this.adminId = adminId;
		this.adminAccount = adminAccount;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
		this.adminDepartmentIdStr = adminDepartmentIdStr;
		this.adminDepartmentName = adminDepartmentName;
		this.adminShopIdStr = adminShopIdStr;
		this.adminShopName = adminShopName;
		this.adminStatus = adminStatus;
		this.adminMenuIdstr = adminMenuIdstr;
		this.adminMenuNamestr = adminMenuNamestr;
		this.adminMenuUrlstr = adminMenuUrlstr;
		this.adminCreatetime = adminCreatetime;
		this.adminMotifytime = adminMotifytime;
	}

	@Override
	public String toString() {
		return "CrmAdmin [adminId=" + adminId + ", adminAccount=" + adminAccount + ", adminPassword=" + adminPassword
				+ ", adminName=" + adminName + ", adminDepartmentIdStr=" + adminDepartmentIdStr + ", adminDepartmentName="
				+ adminDepartmentName + ", adminShopIdStr=" + adminShopIdStr + ", adminShopName=" + adminShopName
				+ ", adminStatus=" + adminStatus + ", adminMenuIdstr=" + adminMenuIdstr + ", adminMenuNamestr="
				+ adminMenuNamestr + ", adminMenuUrlstr=" + adminMenuUrlstr + ", adminCreatetime=" + adminCreatetime
				+ ", adminMotifytime=" + adminMotifytime + "]";
	}
    
}