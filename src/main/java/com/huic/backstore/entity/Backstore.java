package com.huic.backstore.entity;

public class Backstore {
    private Integer sId;

    private String sName;

    private String sLogo;

    private Integer roId;

    private String sStatus;

    private String sAdminname;

    private String sPassword;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsLogo() {
        return sLogo;
    }

    public void setsLogo(String sLogo) {
        this.sLogo = sLogo == null ? null : sLogo.trim();
    }

    public Integer getRoId() {
        return roId;
    }

    public void setRoId(Integer roId) {
        this.roId = roId;
    }

    public String getsStatus() {
        return sStatus;
    }

    public void setsStatus(String sStatus) {
        this.sStatus = sStatus == null ? null : sStatus.trim();
    }

    public String getsAdminname() {
        return sAdminname;
    }

    public void setsAdminname(String sAdminname) {
        this.sAdminname = sAdminname == null ? null : sAdminname.trim();
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword == null ? null : sPassword.trim();
    }

	@Override
	public String toString() {
		return "Backstore [sId=" + sId + ", sName=" + sName + ", sLogo=" + sLogo + ", roId=" + roId + ", sStatus="
				+ sStatus + ", sAdminname=" + sAdminname + ", sPassword=" + sPassword + "]";
	}
    
    
}