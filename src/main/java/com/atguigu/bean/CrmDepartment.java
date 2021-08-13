package com.atguigu.bean;

public class CrmDepartment {
    private Integer departmentId;

    private String departmentName;

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
}