package com.atguigu.bean;

public class CrmAdmin {
    private Integer adminId;

    private String adminAccount;

    private String adminPassword;

    private String adminName;

    private String adminDepartment;

    private Integer adminDepartmentLevel;

    private String adminDepartmentDesc;

    private Integer adminStatus;

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

    public String getAdminDepartment() {
        return adminDepartment;
    }

    public void setAdminDepartment(String adminDepartment) {
        this.adminDepartment = adminDepartment == null ? null : adminDepartment.trim();
    }

    public Integer getAdminDepartmentLevel() {
        return adminDepartmentLevel;
    }

    public void setAdminDepartmentLevel(Integer adminDepartmentLevel) {
        this.adminDepartmentLevel = adminDepartmentLevel;
    }

    public String getAdminDepartmentDesc() {
        return adminDepartmentDesc;
    }

    public void setAdminDepartmentDesc(String adminDepartmentDesc) {
        this.adminDepartmentDesc = adminDepartmentDesc == null ? null : adminDepartmentDesc.trim();
    }

    public Integer getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Integer adminStatus) {
        this.adminStatus = adminStatus;
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
			String adminDepartment, Integer adminDepartmentLevel, String adminDepartmentDesc, Integer adminStatus,
			String adminCreatetime, String adminMotifytime) {
		super();
		this.adminId = adminId;
		this.adminAccount = adminAccount;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
		this.adminDepartment = adminDepartment;
		this.adminDepartmentLevel = adminDepartmentLevel;
		this.adminDepartmentDesc = adminDepartmentDesc;
		this.adminStatus = adminStatus;
		this.adminCreatetime = adminCreatetime;
		this.adminMotifytime = adminMotifytime;
	}

	@Override
	public String toString() {
		return "CrmAdmin [adminId=" + adminId + ", adminAccount=" + adminAccount + ", adminPassword=" + adminPassword
				+ ", adminName=" + adminName + ", adminDepartment=" + adminDepartment + ", adminDepartmentLevel="
				+ adminDepartmentLevel + ", adminDepartmentDesc=" + adminDepartmentDesc + ", adminStatus=" + adminStatus
				+ ", adminCreatetime=" + adminCreatetime + ", adminMotifytime=" + adminMotifytime + "]";
	}
}