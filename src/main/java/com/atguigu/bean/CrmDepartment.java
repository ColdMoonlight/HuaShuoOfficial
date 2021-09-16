package com.atguigu.bean;

public class CrmDepartment {
    private Integer departmentId;

    private String departmentName;
    
    private String departmentSqlName;

    private String departmentCreatetime;

    private String departmentMotifytime;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }
    
    public String getDepartmentSqlName() {
		return departmentSqlName;
	}

	public void setDepartmentSqlName(String departmentSqlName) {
		this.departmentSqlName = departmentSqlName == null ? null : departmentSqlName.trim();
	}

	public String getDepartmentCreatetime() {
        return departmentCreatetime;
    }

    public void setDepartmentCreatetime(String departmentCreatetime) {
        this.departmentCreatetime = departmentCreatetime == null ? null : departmentCreatetime.trim();
    }

    public String getDepartmentMotifytime() {
        return departmentMotifytime;
    }

    public void setDepartmentMotifytime(String departmentMotifytime) {
        this.departmentMotifytime = departmentMotifytime == null ? null : departmentMotifytime.trim();
    }

	public CrmDepartment() {
		super();
	}

	public CrmDepartment(Integer departmentId, String departmentName, String departmentSqlName,
			String departmentCreatetime, String departmentMotifytime) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentSqlName = departmentSqlName;
		this.departmentCreatetime = departmentCreatetime;
		this.departmentMotifytime = departmentMotifytime;
	}

	@Override
	public String toString() {
		return "CrmDepartment [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentSqlName=" + departmentSqlName + ", departmentCreatetime=" + departmentCreatetime
				+ ", departmentMotifytime=" + departmentMotifytime + "]";
	}

}