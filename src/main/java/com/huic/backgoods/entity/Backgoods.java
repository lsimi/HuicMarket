package com.huic.backgoods.entity;

import java.util.Date;

import com.huic.backcategory.entity.Backcategory;

public class Backgoods {
    private Integer gId;

    private String gName;

    private Integer cateId;

    private String gImg;

    private Long gSalenum;

    private Date gUptime;

    private Integer gStatus;

    private Date gDowntime;

    private Integer sId;

    private String gDetail;

    private Integer gGreat;

    private Integer gDelete;
    
    private Backcategory backcategory;
    
    
    
    public Backcategory getBackcategory() {
		return backcategory;
	}

	public void setBackcategory(Backcategory backcategory) {
		this.backcategory = backcategory;
	}

	public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getgImg() {
        return gImg;
    }

    public void setgImg(String gImg) {
        this.gImg = gImg == null ? null : gImg.trim();
    }

    public Long getgSalenum() {
        return gSalenum;
    }

    public void setgSalenum(Long gSalenum) {
        this.gSalenum = gSalenum;
    }

    public Date getgUptime() {
        return gUptime;
    }

    public void setgUptime(Date gUptime) {
        this.gUptime = gUptime;
    }

    public Integer getgStatus() {
        return gStatus;
    }

    public void setgStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }

    public Date getgDowntime() {
        return gDowntime;
    }

    public void setgDowntime(Date gDowntime) {
        this.gDowntime = gDowntime;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getgDetail() {
        return gDetail;
    }

    public void setgDetail(String gDetail) {
        this.gDetail = gDetail == null ? null : gDetail.trim();
    }

    public Integer getgGreat() {
        return gGreat;
    }

    public void setgGreat(Integer gGreat) {
        this.gGreat = gGreat;
    }

    public Integer getgDelete() {
        return gDelete;
    }

    public void setgDelete(Integer gDelete) {
        this.gDelete = gDelete;
    }

	@Override
	public String toString() {
		return "Backgoods [gId=" + gId + ", gName=" + gName + ", cateId=" + cateId + ", gImg=" + gImg + ", gSalenum="
				+ gSalenum + ", gUptime=" + gUptime + ", gStatus=" + gStatus + ", gDowntime=" + gDowntime + ", sId="
				+ sId + ", gDetail=" + gDetail + ", gGreat=" + gGreat + ", gDelete=" + gDelete + ", backcategory="
				+ backcategory + "]";
	}
    
    
    
}