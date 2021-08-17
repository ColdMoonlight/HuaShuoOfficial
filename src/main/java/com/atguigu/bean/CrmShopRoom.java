package com.atguigu.bean;

public class CrmShopRoom {
    private Integer shoproomId;

    private String shoproomName;
    //
    private Integer shoproomIdDepartmentId;

    private String shoproomNameDepartmentName;

    private String shoproomCreatetime;

    private String shoproomMotifytime;

    public Integer getShoproomId() {
        return shoproomId;
    }

    public void setShoproomId(Integer shoproomId) {
        this.shoproomId = shoproomId;
    }

    public String getShoproomName() {
        return shoproomName;
    }

    public void setShoproomName(String shoproomName) {
        this.shoproomName = shoproomName == null ? null : shoproomName.trim();
    }

    public Integer getShoproomIdDepartmentId() {
		return shoproomIdDepartmentId;
	}

	public void setShoproomIdDepartmentId(Integer shoproomIdDepartmentId) {
		this.shoproomIdDepartmentId = shoproomIdDepartmentId;
	}

	public String getShoproomNameDepartmentName() {
		return shoproomNameDepartmentName;
	}

	public void setShoproomNameDepartmentName(String shoproomNameDepartmentName) {
		this.shoproomNameDepartmentName = shoproomNameDepartmentName;
	}

	public String getShoproomCreatetime() {
        return shoproomCreatetime;
    }

    public void setShoproomCreatetime(String shoproomCreatetime) {
        this.shoproomCreatetime = shoproomCreatetime == null ? null : shoproomCreatetime.trim();
    }

    public String getShoproomMotifytime() {
        return shoproomMotifytime;
    }

    public void setShoproomMotifytime(String shoproomMotifytime) {
        this.shoproomMotifytime = shoproomMotifytime == null ? null : shoproomMotifytime.trim();
    }

	public CrmShopRoom() {
		super();
	}

	public CrmShopRoom(Integer shoproomId, String shoproomName, Integer shoproomIdDepartmentId,
			String shoproomNameDepartmentName, String shoproomCreatetime, String shoproomMotifytime) {
		super();
		this.shoproomId = shoproomId;
		this.shoproomName = shoproomName;
		this.shoproomIdDepartmentId = shoproomIdDepartmentId;
		this.shoproomNameDepartmentName = shoproomNameDepartmentName;
		this.shoproomCreatetime = shoproomCreatetime;
		this.shoproomMotifytime = shoproomMotifytime;
	}

	@Override
	public String toString() {
		return "CrmShopRoom [shoproomId=" + shoproomId + ", shoproomName=" + shoproomName + ", shoproomIdDepartmentId="
				+ shoproomIdDepartmentId + ", shoproomNameDepartmentName=" + shoproomNameDepartmentName
				+ ", shoproomCreatetime=" + shoproomCreatetime + ", shoproomMotifytime=" + shoproomMotifytime + "]";
	}
}