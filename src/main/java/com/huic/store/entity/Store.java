package com.huic.store.entity;

import java.util.List;

import com.huic.express.entity.Express;

public class Store {
    private Integer sId;

    private String sName;

    private String sLogo;

    private Integer roId;

    private String sStatus;

    private String sAdminname;

    private String sPassword;
    
    private List<Express> exps;
    

    public List<Express> getExps() {
		return exps;
	}

	public void setExps(List<Express> exps) {
		this.exps = exps;
	}

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
}